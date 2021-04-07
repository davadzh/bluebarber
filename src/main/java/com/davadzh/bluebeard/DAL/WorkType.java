package com.davadzh.bluebeard.DAL;

import com.davadzh.bluebeard.DTO.WorkTypeDtos.AddWorkTypeDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "work_type")
public class WorkType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    @OneToMany(mappedBy = "workType", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MasterWorkType> masterWorkTypes;

    @OneToMany(mappedBy = "workType", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Record> records;

//    public List<MasterWorkType> getMasterWorkTypes() {
//        return masterWorkTypes;
//    }
//
//    public void setMasterWorkTypes(List<MasterWorkType> masterWorkTypes) {
//        this.masterWorkTypes = masterWorkTypes;
//    }

    public WorkType() {
    }

    public WorkType(AddWorkTypeDto addWorkTypeDto) {
        this.name = addWorkTypeDto.name;
        this.price = addWorkTypeDto.price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
