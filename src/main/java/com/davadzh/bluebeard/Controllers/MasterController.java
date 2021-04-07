package com.davadzh.bluebeard.Controllers;

import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.Services.MasterService.IMasterService;
import com.davadzh.bluebeard.DAL.Master.Master;
import com.davadzh.bluebeard.DTO.MasterDtos.AddMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.DeleteMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.UpdateMasterDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.GetMastersByWorkTypeIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/master")
public class MasterController {

    private IMasterService masterService;

    @Autowired
    public void setMasterServices(IMasterService masterService){
        this.masterService = masterService;
    }

    @GetMapping("/getmasters")
    Response<List<Master>> getMasters() {
        var masters = masterService.getMasters();

        return new Response<>(masters);
    }

    @PostMapping("/getMastersByWorkTypeId")
    Response<List<Master>> getMastersByWorkTypeId(@RequestBody GetMastersByWorkTypeIdDto getMastersByWorkTypeIdDto) {
        var masters = masterService.getMastersByWorkTypeId(getMastersByWorkTypeIdDto);

        return new Response<>(masters);
    }

    @PostMapping("/addmaster")
    Response<Master> addMaster(@RequestBody AddMasterDto addMasterDto) {
        var newMaster = masterService.addMaster(addMasterDto);

        return new Response<>(newMaster);
    }

    @PostMapping("/updatemaster")
    Response<Master> updateMaster(@RequestBody UpdateMasterDto updateMasterDto) {
        var master = masterService.updateMaster(updateMasterDto);

        return new Response<>(master);
    }

    @DeleteMapping("/deletemaster")
    Response<Master> deleteMaster(@RequestBody DeleteMasterDto deleteMasterDto) {
        var master = masterService.deleteMaster(deleteMasterDto);

        return new Response<>(master);
    }
}

