package com.inklusport.athlete.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "athletes")
public class Athlete extends PanacheEntity {

    @Column(name = "first_name", nullable = false, length = 50)
    public String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    public String lastName;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false, length = 60)
    public String discipline;
}