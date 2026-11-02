package com.inklusport.sportevent.repository;

import com.inklusport.sportevent.entity.SportEvent;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SportEventRepository
        implements PanacheMongoRepository<SportEvent> {
}