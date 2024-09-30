package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "ams_report_template")
public class ReportTemplate extends BaseEntity {


    @Column(name = "NAME")
    private String name;

    @Column(name = "INTRODUCTION")
    private String introduction;

    @Column(name = "SUMMARY")
    private String summary;

}
