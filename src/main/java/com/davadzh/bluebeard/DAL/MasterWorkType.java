package com.davadzh.bluebeard.DAL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_work_type")
public class MasterWorkType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id")
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    Master master;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_type_id")
    WorkType workType;

    public MasterWorkType() {

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
}
