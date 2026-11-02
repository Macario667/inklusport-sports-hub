package com.inklusport.athlete.repository;

import com.inklusport.athlete.entity.Athlete;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AthleteRepository implements PanacheRepository<Athlete> {
}