package com.davadzh.bluebeard.BLL.Services.RecordService;

import com.davadzh.bluebeard.BLL.Services.MasterService.IMasterService;
import com.davadzh.bluebeard.BLL.Services.WorkTypeService.IWorkTypeService;
import com.davadzh.bluebeard.DAL.Record;
import com.davadzh.bluebeard.DTO.RecordDtos.AddRecordDto;
import com.davadzh.bluebeard.Repositories.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService implements IRecordService {
    private RecordRepository recordRepository;
    private IMasterService masterService;
    private IWorkTypeService workTypeService;

    public RecordService(RecordRepository recordRepository,
                         IMasterService masterService,
                         IWorkTypeService workTypeService) {
        this.recordRepository = recordRepository;
        this.masterService = masterService;
        this.workTypeService = workTypeService;
    }

    @Override
    public List<Record> getRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record addRecord(AddRecordDto record) {
        var master = masterService.findMasterById(record.masterId)
                                          .orElseThrow(() -> new RuntimeException());

        var workType = workTypeService.findWorkTypeById(record.workTypeId)
                                                 .orElseThrow(() -> new RuntimeException());

        var newRecord = new Record(
                master,
                workType,
                record.recordDate,
                null,
                null,
                null,
                false,
                false
        );

        return newRecord;
    }
}
