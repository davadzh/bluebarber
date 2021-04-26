package com.davadzh.bluebeard.BLL.Services.RecordService;

import com.davadzh.bluebeard.BLL.Constants.ExceptionMessages;
import com.davadzh.bluebeard.BLL.Exceptions.BadRequestException;
import com.davadzh.bluebeard.BLL.Exceptions.NotFoundException;
import com.davadzh.bluebeard.BLL.Services.MasterService.IMasterService;
import com.davadzh.bluebeard.BLL.Services.WorkTypeService.IWorkTypeService;
import com.davadzh.bluebeard.DAL.Record.Record;
import com.davadzh.bluebeard.DTO.RecordDtos.*;
import com.davadzh.bluebeard.DAL.Master.MasterRepository;
import com.davadzh.bluebeard.DAL.Record.RecordRepository;
import com.davadzh.bluebeard.DAL.WorkType.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class RecordService implements IRecordService {
    private RecordRepository recordRepository;
    private MasterRepository masterRepository;
    private WorkTypeRepository workTypeRepository;
    private IMasterService masterService;
    private IWorkTypeService workTypeService;

    @Autowired
    public void setRecordServiceConfig(RecordRepository recordRepository,
                                 MasterRepository masterRepository,
                                 WorkTypeRepository workTypeRepository,
                                 IWorkTypeService workTypeService,
                                 IMasterService masterService) {
        this.recordRepository = recordRepository;
        this.masterRepository = masterRepository;
        this.workTypeRepository = workTypeRepository;
        this.workTypeService = workTypeService;
        this.masterService = masterService;
    }


    @Override
    public List<Record> getRecords() {
        return recordRepository.findAll();
    }


    @Override
    public Record addRecord(AddRecordDto record) {
        var master = masterService.findMasterById(record.masterId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.MASTER_NOT_FOUND));

//        var isMasterBusy = recordRepository
//                .findAll()
//                .stream()
//                .filter(rec -> rec.getMaster().getId().equals(record.masterId))
//                .map(rec -> rec.getRecordDate().get(Calendar.YEAR) == record.recordDate.get(Calendar.YEAR)
//                        && rec.getRecordDate().get(Calendar.MONTH) == record.recordDate.get(Calendar.MONTH)
//                        && rec.getRecordDate().get(Calendar.DAY_OF_MONTH) == record.recordDate.get(Calendar.DAY_OF_MONTH)
//                        && rec.getRecordDate().get(Calendar.HOUR_OF_DAY) == record.recordDate.get(Calendar.HOUR_OF_DAY)
//                        && rec.getRecordDate().get(Calendar.MINUTE) == record.recordDate.get(Calendar.MINUTE))
//                .findAny();
//
//        if (isMasterBusy.isPresent())
//            throw new BadRequestException(ExceptionMessages.MASTER_IS_BUSY);

        var workType = workTypeService.findWorkTypeById(record.workTypeId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.WORKTYPE_NOT_FOUND));

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

        recordRepository.save(newRecord);

        return newRecord;
    }

    @Override
    public Record getRecordById(GetRecordByIdDto getRecordByIdDto) {
        var record = recordRepository.findById(getRecordByIdDto.recordId);

        if (record.isEmpty())
            throw new NotFoundException(ExceptionMessages.RECORD_NOT_FOUND);

        return record.get();
    }


    @Override
    public Record addCustomerToRecord(AddCustomerToRecordDto addCustomerToRecordDto) {
        var record = recordRepository.findById(addCustomerToRecordDto.recordId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.RECORD_NOT_FOUND));

        if (record.isConfirmed())
            throw new BadRequestException(ExceptionMessages.RECORD_ALREADY_CONFIRMED);

        record.setClientName(addCustomerToRecordDto.clientName);
        record.setClientPhone(addCustomerToRecordDto.clientPhone);
        record.setClientEmail(addCustomerToRecordDto.clientEmail);
        record.setConfirmed(true);
        record.setModifyDate(LocalDateTime.now(Clock.systemUTC()));

        recordRepository.save(record);

        return record;
    }


    @Override
    public Record cancelCustomerRecord(CancelCustomerRecordDto cancelCustomerRecordDto) {
        var record = recordRepository.findById(cancelCustomerRecordDto.recordId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.RECORD_NOT_FOUND));

        if (!record.isConfirmed())
            throw new BadRequestException(ExceptionMessages.RECORD_ALREADY_FREE);

        record.setConfirmed(false);
        record.setCanceled(true);
        record.setClientName(null);
        record.setClientPhone(null);
        record.setClientEmail(null);
        record.setModifyDate(LocalDateTime.now(Clock.systemUTC()));

        recordRepository.save(record);

        return record;
    }


    @Override
    public Record updateRecord(UpdateRecordDto updateRecordDto) {
        var record = recordRepository.findById(updateRecordDto.recordId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.RECORD_NOT_FOUND));

        var master = masterRepository.findById(updateRecordDto.masterId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.MASTER_NOT_FOUND));

        var workType = workTypeRepository.findById(updateRecordDto.workTypeId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.WORKTYPE_NOT_FOUND));

        record.setMaster(master);
        record.setWorkType(workType);
        record.setRecordDate(updateRecordDto.recordDate);
        record.setClientName(updateRecordDto.clientName);
        record.setClientPhone(updateRecordDto.clientPhone);
        record.setClientEmail(updateRecordDto.clientEmail);
        record.setModifyDate(LocalDateTime.now(Clock.systemUTC()));

        recordRepository.save(record);

        return record;
    }


    @Override
    public Record deleteRecord(DeleteRecordDto deleteRecordDto) {
        var record = recordRepository.findById(deleteRecordDto.recordId)
                .orElseThrow(() -> new NotFoundException(ExceptionMessages.RECORD_NOT_FOUND));

        recordRepository.deleteById(deleteRecordDto.recordId);
        return record;
    }
}
