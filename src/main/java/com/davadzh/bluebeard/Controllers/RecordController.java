package com.davadzh.bluebeard.Controllers;
import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.Services.RecordService.IRecordService;
import com.davadzh.bluebeard.DAL.Record.Record;
import com.davadzh.bluebeard.DTO.RecordDtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/admin/record")
public class RecordController {

    private IRecordService recordService;

    @Autowired
    public void setRecordServices(IRecordService recordService){
        this.recordService = recordService;
    }

    @GetMapping ("/getRecords")
    Response<List<Record>> getRecords() {
        var records = recordService.getRecords();

        return new Response<>(records);
    }

    @PostMapping("/addRecord")
    Response<Record> addRecord(@RequestBody AddRecordDto addRecordDto) {
        var record = recordService.addRecord(addRecordDto);

        return new Response<>(record);
    }

    @PostMapping("/addCustomerToRecord")
    Response<Record> addCustomerToRecord(@RequestBody AddCustomerToRecordDto addCustomerToRecordDto) {
        var record = recordService.addCustomerToRecord(addCustomerToRecordDto);

        return new Response<>(record);
    }

    @PostMapping("/cancelCustomerRecord")
    Response<Record> cancelCustomerRecord(@RequestBody CancelCustomerRecordDto cancelCustomerRecordDto) {
        var record = recordService.cancelCustomerRecord(cancelCustomerRecordDto);

        return new Response<>(record);
    }

    @PutMapping("/updateRecord")
    Response<Record> updateRecord(@RequestBody UpdateRecordDto updateRecordDto) {
        var record = recordService.updateRecord(updateRecordDto);

        return new Response<>(record);
    }

    @DeleteMapping("/deleteRecord")
    Response<Record> deleteRecord(@RequestBody DeleteRecordDto deleteRecordDto) {
        var record = recordService.deleteRecord(deleteRecordDto);

        return new Response<>(record);
    }
}
