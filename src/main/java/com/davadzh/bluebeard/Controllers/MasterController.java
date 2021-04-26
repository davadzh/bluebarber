package com.davadzh.bluebeard.Controllers;

import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.Services.MasterService.IMasterService;
import com.davadzh.bluebeard.DAL.Master.Master;
import com.davadzh.bluebeard.DTO.MasterDtos.AddMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.DeleteMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.GetMasterByIdDto;
import com.davadzh.bluebeard.DTO.MasterDtos.UpdateMasterDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.GetMastersByWorkTypeIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/master")
public class MasterController {

    private IMasterService masterService;

    @Autowired
    public void setMasterServices(IMasterService masterService){
        this.masterService = masterService;
    }

    @GetMapping("/getMasters")
    Response<List<Master>> getMasters() {
        var masters = masterService.getMasters();

        return new Response<>(masters);
    }

    @PostMapping("/getMastersByWorkTypeId")
    Response<List<Master>> getMastersByWorkTypeId(@RequestBody GetMastersByWorkTypeIdDto getMastersByWorkTypeIdDto) {
        var masters = masterService.getMastersByWorkTypeId(getMastersByWorkTypeIdDto);

        return new Response<>(masters);
    }

    @PostMapping("/getMasterById")
    Response<Master> getMasterById(@RequestBody GetMasterByIdDto getMasterByIdDto) {
        var newMaster = masterService.getMasterById(getMasterByIdDto);

        return new Response<>(newMaster);
    }

    @PostMapping("/addMaster")
    Response<Master> addMaster(@RequestBody AddMasterDto addMasterDto) {
        var newMaster = masterService.addMaster(addMasterDto);

        return new Response<>(newMaster);
    }

    @PostMapping("/updateMaster")
    Response<Master> updateMaster(@RequestBody UpdateMasterDto updateMasterDto) {
        var master = masterService.updateMaster(updateMasterDto);

        return new Response<>(master);
    }

    @PostMapping("/deleteMaster")
    Response<Master> deleteMaster(@RequestBody DeleteMasterDto deleteMasterDto) {
        var master = masterService.deleteMaster(deleteMasterDto);

        return new Response<>(master);
    }
}

