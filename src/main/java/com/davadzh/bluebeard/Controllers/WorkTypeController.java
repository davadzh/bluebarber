package com.davadzh.bluebeard.Controllers;
import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.Services.WorkTypeService.IWorkTypeService;
import com.davadzh.bluebeard.DAL.WorkType;
import com.davadzh.bluebeard.DTO.MasterDtos.GetWorkTypesByMasterIdDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.WorkTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@RestController
@RequestMapping("api/worktype")
public class WorkTypeController {

    private IWorkTypeService workTypeService;

    @Autowired
    public void setWorkTypeService(IWorkTypeService workTypeService){
        this.workTypeService = workTypeService;
    }

//    private List<WorkType> workTypes = new ArrayList<>();

//    @PostMapping
//    public String postText(@RequestBody Map<String, String> body) {
//        JSONObject jsonObject = new JSONObject(body);
////        workTypes.add(jsonObject.toString());
//        return jsonObject.toString() + " is added";
//    }

    @GetMapping ("/getworktypes")
    Response<List<WorkType>> getWorkTypes() {
        var workTypes = workTypeService.getWorkTypes();

        Response<List<WorkType>> res = new Response<>(workTypes);

        return res;
    }

    @PostMapping("/addworktype")
    WorkType addWorkType(@RequestBody WorkTypeDto workTypeDto) {
        var newWorkType = workTypeService.addWorkType(workTypeDto);

        return newWorkType;
    }

    @PostMapping("/getWorkTypesByMasterId")
    List<WorkType> getWorkTypesByMasterId(@RequestBody GetWorkTypesByMasterIdDto getWorkTypesByMasterIdDto) {
        var workTypes = workTypeService.getWorkTypesByMasterId(getWorkTypesByMasterIdDto.id);

        return workTypes;
    }
}
