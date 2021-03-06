package com.davadzh.bluebeard.DAL.MasterWorkType;

import com.davadzh.bluebeard.DAL.BaseEntity;
import com.davadzh.bluebeard.DAL.Master.Master;
import com.davadzh.bluebeard.DAL.WorkType.WorkType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_work_type", schema = "public")
public class MasterWorkType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id", nullable = false)
    Master master;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_type_id", nullable = false)
    WorkType workType;

    public MasterWorkType() { }

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
