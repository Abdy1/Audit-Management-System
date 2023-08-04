package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "CREATED_USER")
  private String createdUser;

  @Column(name = "MODIFIED_USER")
  private String modifiedUser;

  @Column(name = "CREATED_TS")
  @CreationTimestamp
  private LocalDateTime createdTimestamp;

  @UpdateTimestamp
  @Column(name = "MODIFIED_TS")
  private LocalDateTime modifiedTimestamp;


}
