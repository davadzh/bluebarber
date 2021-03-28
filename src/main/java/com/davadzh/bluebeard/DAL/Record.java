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
}
