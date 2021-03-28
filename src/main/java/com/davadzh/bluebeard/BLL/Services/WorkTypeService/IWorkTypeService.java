package com.davadzh.bluebeard.BLL.Services.WorkTypeService;

import com.davadzh.bluebeard.DAL.WorkType;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.WorkTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IWorkTypeService {
    List<WorkType> getWorkTypes();
    WorkType addWorkType(WorkTypeDto workTypeDto);
    List<WorkType> getWorkTypesByMasterId(Long masterId);
    Optional<WorkType> findWorkTypeById(Long workTypeId);
}
