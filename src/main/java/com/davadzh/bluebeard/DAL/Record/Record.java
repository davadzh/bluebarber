package com.davadzh.bluebeard.DAL.Record;

import com.davadzh.bluebeard.DAL.BaseEntity;
import com.davadzh.bluebeard.DAL.Master.Master;
import com.davadzh.bluebeard.DAL.WorkType.WorkType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.TimeZone;

@Entity
@Table(name = "record", schema = "public")
public class Record extends BaseEntity implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id", nullable = false)
    Master master;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_type_id", nullable = false)
    WorkType workType;

    Calendar recordDate;
    String clientName;
    String clientPhone;
    String clientEmail;
    boolean isConfirmed = false;
    boolean isCanceled = false;

    public Record(){}

    public Record(Master master,
                  WorkType workType,
                  Calendar recordDate,
                  String clientName,
                  String clientPhone,
                  String clientEmail,
                  boolean isConfirmed,
                  boolean isCanceled) {
        super();
        this.master = master;
        this.workType = workType;
        this.recordDate = recordDate;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.isConfirmed = isConfirmed;
        this.isCanceled = isCanceled;
    }



    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public Calendar getRecordDate() {
        recordDate.setTimeZone(TimeZone.getTimeZone("UTC"));
        return recordDate;
    }

    public void setRecordDate(Calendar recordDate) {
        this.recordDate = recordDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
