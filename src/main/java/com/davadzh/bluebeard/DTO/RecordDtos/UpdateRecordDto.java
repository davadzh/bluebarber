package com.davadzh.bluebeard.DTO.RecordDtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class UpdateRecordDto {
    public Long recordId;
    public Long masterId;
    public Long workTypeId;
    public Calendar recordDate;
    public String clientName;
    public String clientPhone;
    public String clientEmail;
}
