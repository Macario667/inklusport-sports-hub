package com.inklusport.sportevent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SportEventRequest {

    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    public String name;

    @Size(max = 500, message = "La descripción no puede superar 500 caracteres")
    public String description;

    @NotBlank(message = "La disciplina deportiva es obligatoria")
    @Size(max = 60)
    public String sport;

    @NotBlank(message = "La ubicación es obligatoria")
    @Size(max = 150)
    public String location;

    @NotBlank(message = "La fecha del evento es obligatoria")
    @Pattern(
        regexp = "^\\d{4}-\\d{2}-\\d{2}$",
        message = "La fecha debe tener el formato yyyy-MM-dd"
    )
    public String eventDate;

    @NotBlank(message = "El estado del evento es obligatorio")
    @Pattern(
        regexp = "PLANNED|ACTIVE|COMPLETED|CANCELLED",
        message = "Estado no válido"
    )
    public String status;
}