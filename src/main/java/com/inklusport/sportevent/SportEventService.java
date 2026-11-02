package com.inklusport.sportevent;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.jboss.logging.Logger;

import com.inklusport.sportevent.dto.SportEventRequest;
import com.inklusport.sportevent.dto.SportEventResponse;
import com.inklusport.sportevent.entity.SportEvent;
import com.inklusport.sportevent.repository.SportEventRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SportEventService {

    private static final Logger LOG =
            Logger.getLogger(SportEventService.class);

    @Inject
    SportEventRepository repository;

    public List<SportEventResponse> findAll() {
        LOG.debug("Consultando todos los eventos deportivos");

        return repository.listAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public Optional<SportEventResponse> findById(String id) {
        if (!ObjectId.isValid(id)) {
            return Optional.empty();
        }

        return repository.findByIdOptional(new ObjectId(id))
                .map(this::toResponse);
    }

    public SportEventResponse create(SportEventRequest request) {
        SportEvent event = new SportEvent();

        event.name = request.name;
        event.description = request.description;
        event.sport = request.sport;
        event.location = request.location;
        event.eventDate = request.eventDate;
        event.status = request.status;

        repository.persist(event);

        LOG.infof("Evento deportivo creado. ID: %s", event.id);

        return toResponse(event);
    }

    public Optional<SportEventResponse> update(
            String id,
            SportEventRequest request) {

        if (!ObjectId.isValid(id)) {
            return Optional.empty();
        }

        return repository.findByIdOptional(new ObjectId(id))
                .map(event -> {
                    event.name = request.name;
                    event.description = request.description;
                    event.sport = request.sport;
                    event.location = request.location;
                    event.eventDate = request.eventDate;
                    event.status = request.status;

                    repository.persistOrUpdate(event);

                    LOG.infof("Evento actualizado. ID: %s", id);

                    return toResponse(event);
                });
    }

    public boolean delete(String id) {
        if (!ObjectId.isValid(id)) {
            return false;
        }

        boolean removed = repository.deleteById(new ObjectId(id));

        if (removed) {
            LOG.infof("Evento eliminado. ID: %s", id);
        } else {
            LOG.warnf("No se encontró el evento. ID: %s", id);
        }

        return removed;
    }

    private SportEventResponse toResponse(SportEvent event) {
        return new SportEventResponse(
                event.id.toHexString(),
                event.name,
                event.description,
                event.sport,
                event.location,
                event.eventDate,
                event.status
        );
    }
}