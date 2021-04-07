package com.davadzh.bluebeard.DTO.RecordDtos;

import java.time.LocalDate;

public class UpdateRecordDto {
    public Long recordId;
    public Long masterId;
    public Long workTypeId;
    public LocalDate recordDate;
    public String clientName;
    public String clientPhone;
    public String clientEmail;
}
