package com.davadzh.bluebeard.DAL;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id", nullable = false)
    Master master;

//    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_type_id", nullable = false)
    WorkType workType;

    @Column(nullable = false)
    LocalDate recordDate;

    @Column(nullable = true)
    String clientName;

    @Column(nullable = true)
    String clientPhone;

    @Column(nullable = true)
    String clientEmail;

    @Column(nullable = false)
    boolean isConfirmed = false;

    @Column(nullable = false)
    boolean isCanceled = false;

    public Record(){}

    public Record(Master master,
                  WorkType workType,
                  LocalDate recordDate,
                  String clientName,
                  String clientPhone,
                  String clientEmail,
                  boolean isConfirmed,
                  boolean isCanceled){

        this.master = master;
        this.workType = workType;
        this.recordDate = recordDate;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.isConfirmed = isConfirmed;
        this.isCanceled = isCanceled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
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
