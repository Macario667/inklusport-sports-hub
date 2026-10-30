package com.inklusport.athlete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.jboss.logging.Logger;

import com.inklusport.athlete.dto.AthleteRequest;
import com.inklusport.athlete.dto.AthleteResponse;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * @ApplicationScoped: Quarkus administra una instancia del servicio 
 * para la aplicación.
 */
@ApplicationScoped 
public class AthleteService {
    
    private final List<AthleteResponse> athletes = new ArrayList<>();

    /**
     * AtomicLong: genera identificadores consecutivos.
     */
    private final AtomicLong sequence = new AtomicLong(0);

    private static final Logger LOG = Logger.getLogger(AthleteService.class);

    public List<AthleteResponse> findAll() {
        LOG.debug("Consultando todos los deportistas");
        return athletes;
    }

    public Optional<AthleteResponse> findById(Long id) {
        LOG.debugf("Consultando deportista. ID: %d", id);

        Optional<AthleteResponse> athlete = athletes.stream()
                .filter(item -> item.id.equals(id))
                .findFirst();

        if (athlete.isEmpty()) {
            LOG.warnf("No se encontró el deportista. ID: %d", id);
        }

        return athlete;
    }

    public AthleteResponse create(AthleteRequest request) {
        Long id = sequence.incrementAndGet();

        AthleteResponse athlete = new AthleteResponse(
                id,
                request.firstName,
                request.lastName,
                request.email,
                request.discipline
        );

        athletes.add(athlete);

        LOG.infof("Deportista creado. ID: %d", id);

        return athlete;
    }

    public Optional<AthleteResponse> update(
            Long id,
            AthleteRequest request) {

        Optional<AthleteResponse> existing = findById(id);

        if (existing.isEmpty()) {
            return Optional.empty();
        }

        AthleteResponse updated = new AthleteResponse(
                id,
                request.firstName,
                request.lastName,
                request.email,
                request.discipline
        );

        athletes.remove(existing.get());
        athletes.add(updated);

        LOG.infof("Deportista actualizado. ID: %d", id);

        return Optional.of(updated);
    }

    public boolean delete(Long id) {
        boolean removed = athletes.removeIf(
                athlete -> athlete.id.equals(id)
        );

        if (removed) {
            LOG.infof("Deportista eliminado. ID: %d", id);
        } else {
            LOG.warnf("No se pudo eliminar. ID inexistente: %d", id);
        }

        return removed;    
    }
}
