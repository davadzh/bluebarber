package com.davadzh.bluebeard.BLL.Services.WorkTypeService;

import com.davadzh.bluebeard.DAL.WorkType.WorkType;
import com.davadzh.bluebeard.DTO.MasterDtos.GetWorkTypesByMasterIdDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.AddWorkTypeDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.DeleteWorkTypeDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.GetWorkTypeByIdDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.UpdateWorkTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IWorkTypeService {
    List<WorkType> getWorkTypes();
    WorkType addWorkType(AddWorkTypeDto addWorkTypeDto);
    WorkType getWorkTypeById(GetWorkTypeByIdDto getWorkTypeByIdDto);
    WorkType updateWorkType(UpdateWorkTypeDto updateWorkTypeDto);
    WorkType deleteWorkType(DeleteWorkTypeDto deleteWorkTypeDto);
    List<WorkType> getWorkTypesByMasterId(GetWorkTypesByMasterIdDto getWorkTypesByMasterIdDto);
    Optional<WorkType> findWorkTypeById(Long workTypeId);
}
