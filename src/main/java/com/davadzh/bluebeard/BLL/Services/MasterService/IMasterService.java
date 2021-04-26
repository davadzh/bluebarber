package com.davadzh.bluebeard.BLL.Services.MasterService;

import com.davadzh.bluebeard.DAL.Master.Master;
import com.davadzh.bluebeard.DTO.MasterDtos.AddMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.DeleteMasterDto;
import com.davadzh.bluebeard.DTO.MasterDtos.GetMasterByIdDto;
import com.davadzh.bluebeard.DTO.MasterDtos.UpdateMasterDto;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.GetMastersByWorkTypeIdDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IMasterService {
    List<Master> getMasters();
    Master getMasterById(GetMasterByIdDto getMasterByIdDto);
    Master addMaster(AddMasterDto addMasterDto);
    Master updateMaster(UpdateMasterDto updateMasterDto);
    Master deleteMaster(DeleteMasterDto deleteMasterDto);
    List<Master> getMastersByWorkTypeId(GetMastersByWorkTypeIdDto getMastersByWorkTypeIdDto);
    Optional<Master> findMasterById(Long masterId);
}
