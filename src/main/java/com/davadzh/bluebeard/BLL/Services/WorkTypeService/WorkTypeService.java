package com.davadzh.bluebeard.BLL.Services.WorkTypeService;

import com.davadzh.bluebeard.DAL.WorkType;
import com.davadzh.bluebeard.DTO.WorkTypeDto;
import com.davadzh.bluebeard.Repositories.MasterWorkTypeRepository;
import com.davadzh.bluebeard.Repositories.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkTypeService implements IWorkTypeService {
    private WorkTypeRepository workTypeRepository;
    private MasterWorkTypeRepository masterWorkTypeRepository;

    @Autowired
    public void setWorkTypeRepository(WorkTypeRepository workTypeRepository,
                                      MasterWorkTypeRepository masterWorkTypeRepository) {
        this.workTypeRepository = workTypeRepository;
        this.masterWorkTypeRepository = masterWorkTypeRepository;
    }

    public List<WorkType> getWorkTypes() {
        var a = workTypeRepository.findAll();
        System.out.println(a);
        return a;
    }

    public WorkType addWorkType(WorkTypeDto workTypeDto) {
        WorkType newWorkType = new WorkType(workTypeDto);
        workTypeRepository.save(newWorkType);

        return newWorkType;
    }

    public List<WorkType> getWorkTypesByMasterId(Long masterId) {

        return masterWorkTypeRepository
                .findAll()
                .stream()
                .filter(masterWorkType -> masterWorkType.getMaster().getId() == masterId)
                .map(masterWorkType -> masterWorkType.getWorkType())
                .collect(Collectors.toList());
    }
}
