package com.inklusport.sportevent.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class SportEvent extends PanacheMongoEntity {

    public String name;

    public String description;

    public String sport;

    public String location;

    public String eventDate;

    public String status;
}