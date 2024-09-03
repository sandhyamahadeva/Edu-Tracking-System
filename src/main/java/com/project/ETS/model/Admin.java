package com.project.ETS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "admins")
@EntityListeners(AuditingEntityListener.class)
public class Admin extends User {

}
