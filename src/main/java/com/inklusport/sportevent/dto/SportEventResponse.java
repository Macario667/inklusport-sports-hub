package com.inklusport.sportevent.dto;

public class SportEventResponse {

    public String id;
    public String name;
    public String description;
    public String sport;
    public String location;
    public String eventDate;
    public String status;

    public SportEventResponse(
            String id,
            String name,
            String description,
            String sport,
            String location,
            String eventDate,
            String status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.sport = sport;
        this.location = location;
        this.eventDate = eventDate;
        this.status = status;
    }
}