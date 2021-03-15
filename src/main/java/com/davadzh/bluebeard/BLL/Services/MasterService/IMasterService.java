package com.davadzh.bluebeard.BLL.Services.MasterService;

import com.davadzh.bluebeard.DAL.Master;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMasterService {
    List<Master> getMasters();
    List<Master> getMastersByWorkTypeId(Long workTypeId);
}
