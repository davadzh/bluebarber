package com.davadzh.bluebeard.DTO.RecordDtos;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class AddRecordDto {
    public Long masterId;
    public Long workTypeId;
    public Calendar recordDate;
}
