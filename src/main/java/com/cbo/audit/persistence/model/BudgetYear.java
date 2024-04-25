package com.cbo.audit.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ams_budget_year")
public class BudgetYear extends BaseEntity {

    @Column(name = "YEAR", unique = true)
    private String year;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "IS_CURRENT")
    private boolean isCurrent;
}
