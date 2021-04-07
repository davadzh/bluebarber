package com.davadzh.bluebeard.Controllers;
import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.Services.WorkTypeService.IWorkTypeService;
import com.davadzh.bluebeard.DAL.WorkType.WorkType;
import com.davadzh.bluebeard.DTO.MasterDtos.GetWorkTypesByMasterIdDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.AddWorkTypeDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.DeleteWorkTypeDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.UpdateWorkTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/admin/worktype")
public class WorkTypeController {

    private IWorkTypeService workTypeService;

    @Autowired
    public void setWorkTypeServices(IWorkTypeService workTypeService){
        this.workTypeService = workTypeService;
    }

    @GetMapping ("/getworktypes")
    Response<List<WorkType>> getWorkTypes() {
        var workTypes = workTypeService.getWorkTypes();

        return new Response<>(workTypes);
    }

    @PostMapping("/addworktype")
    Response<WorkType> addWorkType(@RequestBody AddWorkTypeDto addWorkTypeDto) {
        var newWorkType = workTypeService.addWorkType(addWorkTypeDto);

        return new Response<>(newWorkType);
    }

    @PostMapping("/getWorkTypesByMasterId")
    Response<List<WorkType>> getWorkTypesByMasterId(@RequestBody GetWorkTypesByMasterIdDto getWorkTypesByMasterIdDto) {
        var workTypes = workTypeService.getWorkTypesByMasterId(getWorkTypesByMasterIdDto);

        return new Response<>(workTypes);
    }

    @PutMapping("/updateworktype")
    Response<WorkType> updateWorkType(@RequestBody UpdateWorkTypeDto updateWorkTypeDto) {
        var workType = workTypeService.updateWorkType(updateWorkTypeDto);

        return new Response<>(workType);
    }

    @DeleteMapping("/deleteworktype")
    Response<WorkType> deleteWorkType(@RequestBody DeleteWorkTypeDto deleteWorkTypeDto) {
        var workType = workTypeService.deleteWorkType(deleteWorkTypeDto);

        return new Response<>(workType);
    }
}
