package com.cbo.audit.persistence.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ams_risk_item")
public class RiskItem extends BaseEntity{

    @Column(name = "NAME")
    private String name;

}
