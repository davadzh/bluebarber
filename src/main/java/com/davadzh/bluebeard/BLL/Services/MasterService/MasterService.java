package com.davadzh.bluebeard.BLL.Services.MasterService;

import com.davadzh.bluebeard.DAL.Master;
import com.davadzh.bluebeard.Repositories.MasterRepository;
import com.davadzh.bluebeard.Repositories.MasterWorkTypeRepository;
import com.davadzh.bluebeard.Repositories.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterService implements IMasterService {
    private MasterRepository masterRepository;
    private MasterWorkTypeRepository masterWorkTypeRepository;

    @Autowired
    public void setMasterRepository(MasterRepository masterRepository,
                                    MasterWorkTypeRepository masterWorkTypeRepository){
        this.masterRepository = masterRepository;
        this.masterWorkTypeRepository = masterWorkTypeRepository;
    }

    public List<Master> getMasters() {
        return masterRepository.findAll();
    }

    public List<Master> getMastersByWorkTypeId(Long workTypeId) {
        return masterWorkTypeRepository
                .findAll()
                .stream()
                .filter(masterWorkType -> masterWorkType.getWorkType().getId() == workTypeId)
                .map(masterWorkType -> masterWorkType.getMaster())
                .collect(Collectors.toList());
    }
}
