package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "ams_checklist_item")
public class ChecklistItem extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ElementCollection
    @Column(name = "OBJECTIVE_LIST")
    private List<String> objective_list;

    @ElementCollection
    @Column(name = "ACTION_LIST")
    private List<String> action_list;

    @ManyToOne
    @JoinColumn(name = "auditable_area_id")
    private AuditableArea auditableArea;

}
