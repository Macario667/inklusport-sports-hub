package com.inklusport.athlete.dto;

public class AthleteResponse {
    
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String discipline;

    public AthleteResponse(
            Long id,
            String firstName,
            String lastName,
            String email,
            String discipline) {
            
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.discipline = discipline;
    }
}
