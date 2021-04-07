package com.davadzh.bluebeard.BLL.Services.WorkTypeService;

import com.davadzh.bluebeard.BLL.Constants.ExceptionMessages;
import com.davadzh.bluebeard.BLL.Exceptions.NotFoundException;
import com.davadzh.bluebeard.DAL.WorkType;
import com.davadzh.bluebeard.DTO.MasterDtos.GetWorkTypesByMasterIdDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.AddWorkTypeDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.DeleteWorkTypeDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.UpdateWorkTypeDto;
import com.davadzh.bluebeard.Repositories.MasterWorkTypeRepository;
import com.davadzh.bluebeard.Repositories.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkTypeService implements IWorkTypeService {
    private WorkTypeRepository workTypeRepository;
    private MasterWorkTypeRepository masterWorkTypeRepository;

    @Autowired
    public void setWorkTypeServiceConfig(WorkTypeRepository workTypeRepository,
                                      MasterWorkTypeRepository masterWorkTypeRepository) {
        this.workTypeRepository = workTypeRepository;
        this.masterWorkTypeRepository = masterWorkTypeRepository;
    }


    @Override
    public List<WorkType> getWorkTypes() {
        return workTypeRepository.findAll();
    }


    @Override
    public WorkType addWorkType(AddWorkTypeDto addWorkTypeDto) {
        WorkType newWorkType = new WorkType(addWorkTypeDto);
        workTypeRepository.save(newWorkType);

        return newWorkType;
    }


    @Override
    public WorkType updateWorkType(UpdateWorkTypeDto updateWorkTypeDto) {
        var workType = workTypeRepository.findById(updateWorkTypeDto.workTypeId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.WORKTYPE_NOT_FOUND));

        workType.setName(updateWorkTypeDto.name);
        workType.setPrice(updateWorkTypeDto.price);
        workTypeRepository.save(workType);

        return workType;
    }

    @Override
    public WorkType deleteWorkType(DeleteWorkTypeDto deleteWorkTypeDto) {
        var workType = workTypeRepository.findById(deleteWorkTypeDto.workTypeId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.WORKTYPE_NOT_FOUND));

        workTypeRepository.deleteById(deleteWorkTypeDto.workTypeId);
        return workType;
    }

    @Override
    public List<WorkType> getWorkTypesByMasterId(GetWorkTypesByMasterIdDto getWorkTypesByMasterIdDto) {

        return masterWorkTypeRepository
                .findAll()
                .stream()
                .filter(masterWorkType -> masterWorkType.getMaster().getId().equals(
                        getWorkTypesByMasterIdDto.masterId
                ))
                .map(masterWorkType -> masterWorkType.getWorkType())
                .collect(Collectors.toList());
    }


    @Override
    public Optional<WorkType> findWorkTypeById(Long workTypeId) {
        return workTypeRepository.findById(workTypeId);
    }
}
