package com.davadzh.bluebeard.BLL.Services.WorkTypeService;

import com.davadzh.bluebeard.DAL.Master;
import com.davadzh.bluebeard.DAL.MasterWorkType;
import com.davadzh.bluebeard.DAL.WorkType;
import com.davadzh.bluebeard.DTO.WorkTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWorkTypeService {
    List<WorkType> getWorkTypes();
    WorkType addWorkType(WorkTypeDto workTypeDto);
    List<WorkType> getWorkTypesByMasterId(Long masterId);
}
