package com.davadzh.bluebeard.Controllers;

import com.davadzh.bluebeard.BLL.Services.MasterService.IMasterService;
import com.davadzh.bluebeard.DAL.Master;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.GetMastersByWorkTypeIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/master")
public class MasterController {

    private IMasterService masterService;

    @Autowired
    public void setMasterService(IMasterService masterService){
        this.masterService = masterService;
    }

    @GetMapping("/getmasters")
    List<Master> getMasters() {
        var masters = masterService.getMasters();

        return masters;
    }

    @PostMapping("/getMastersByWorkTypeId")
    List<Master> getMastersByWorkTypeId(@RequestBody GetMastersByWorkTypeIdDto getMastersByWorkTypeIdDto) {
        var masters = masterService.getMastersByWorkTypeId(getMastersByWorkTypeIdDto.id);

        return masters;
    }

//    @PostMapping
//    WorkType addWorkType(@RequestBody WorkTypeDto workTypeDto) {
//        var newWorkType = workTypeService.addWorkType(workTypeDto);
//
//        return newWorkType;
//    }
}

