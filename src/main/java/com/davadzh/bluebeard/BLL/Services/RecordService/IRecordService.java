package com.davadzh.bluebeard.BLL.Services.RecordService;

import com.davadzh.bluebeard.DAL.Record;
import com.davadzh.bluebeard.DTO.RecordDtos.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRecordService {
    List<Record> getRecords();
    Record addRecord(AddRecordDto record);
    Record addCustomerToRecord(AddCustomerToRecordDto addCustomerToRecordDto);
    Record cancelCustomerRecord(CancelCustomerRecordDto cancelCustomerRecordDto);
    Record updateRecord(UpdateRecordDto updateRecordDto);
    Record deleteRecord(DeleteRecordDto deleteRecordDto);
}
