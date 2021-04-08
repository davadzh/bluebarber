package com.davadzh.bluebeard.DAL.WorkType;

import com.davadzh.bluebeard.DAL.BaseEntity;
import com.davadzh.bluebeard.DAL.MasterWorkType.MasterWorkType;
import com.davadzh.bluebeard.DAL.Record.Record;
import com.davadzh.bluebeard.DTO.WorkTypeDtos.AddWorkTypeDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "work_type", schema = "public")
public class WorkType extends BaseEntity implements Serializable {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    @OneToMany(mappedBy = "workType", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MasterWorkType> masterWorkTypes;

    @OneToMany(mappedBy = "workType", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Record> records;

    public WorkType() {
    }

    public WorkType(AddWorkTypeDto addWorkTypeDto) {
        super();
        this.name = addWorkTypeDto.name;
        this.price = addWorkTypeDto.price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
