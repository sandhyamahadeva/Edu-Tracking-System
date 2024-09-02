package com.project.ETS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "super_admins")
@EntityListeners(AuditingEntityListener.class)
public class Super_Admin extends User{

}
