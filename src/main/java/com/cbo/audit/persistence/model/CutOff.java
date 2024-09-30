package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cut_off")
public class CutOff extends BaseEntity {

    @Column(name = "cut_off")
    private int cutOff;

}
