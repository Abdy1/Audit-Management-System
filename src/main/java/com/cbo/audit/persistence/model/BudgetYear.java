package com.cbo.audit.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ams_budget_year")
public class BudgetYear extends BaseEntity{

    @Column(name = "YEAR")
    private String year;

    @Column(name = "DETAILS")
    private String details;
}
