package com.davadzh.bluebeard.DAL;

import com.davadzh.bluebeard.DTO.WorkTypeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

//    public List<MasterWorkType> getMasterWorkTypes() {
//        return masterWorkTypes;
//    }
//
//    public void setMasterWorkTypes(List<MasterWorkType> masterWorkTypes) {
//        this.masterWorkTypes = masterWorkTypes;
//    }

    public WorkType() {
    }

    public WorkType(WorkTypeDto workTypeDto) {
        this.name = workTypeDto.name;
        this.price = workTypeDto.price;
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
