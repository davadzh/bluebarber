package com.davadzh.bluebeard.BLL.Services.RecordService;

import com.davadzh.bluebeard.DAL.Record;
import com.davadzh.bluebeard.DTO.RecordDtos.AddRecordDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRecordService {
    List<Record> getRecords();
    Record addRecord(AddRecordDto record);
}
