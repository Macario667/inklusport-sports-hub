package com.inklusport.athlete;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import com.inklusport.athlete.dto.AthleteRequest;
import com.inklusport.athlete.dto.AthleteResponse;
import com.inklusport.athlete.entity.Athlete;
import com.inklusport.athlete.repository.AthleteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AthleteService {

    private static final Logger LOG = Logger.getLogger(AthleteService.class);

    @Inject
    AthleteRepository athleteRepository;

    public List<AthleteResponse> findAll() {
        LOG.debug("Consultando todos los deportistas");

        return athleteRepository.listAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public Optional<AthleteResponse> findById(Long id) {
        LOG.debugf("Consultando deportista. ID: %d", id);

        Optional<AthleteResponse> athlete =
                athleteRepository.findByIdOptional(id)
                        .map(this::toResponse);

        if (athlete.isEmpty()) {
            LOG.warnf("No se encontró el deportista. ID: %d", id);
        }

        return athlete;
    }

    @Transactional
    public AthleteResponse create(AthleteRequest request) {
        Athlete athlete = new Athlete();

        athlete.firstName = request.firstName;
        athlete.lastName = request.lastName;
        athlete.email = request.email;
        athlete.discipline = request.discipline;

        athleteRepository.persist(athlete);

        LOG.infof("Deportista creado. ID: %d", athlete.id);

        return toResponse(athlete);
    }

    @Transactional
    public Optional<AthleteResponse> update(
            Long id, AthleteRequest request) {

        return athleteRepository.findByIdOptional(id)
                .map(athlete -> {
                    athlete.firstName = request.firstName;
                    athlete.lastName = request.lastName;
                    athlete.email = request.email;
                    athlete.discipline = request.discipline;

                    LOG.infof("Deportista actualizado. ID: %d", id);

                    return toResponse(athlete);
                });
    }

    @Transactional
    public boolean delete(Long id) {
        boolean removed = athleteRepository.deleteById(id);

        if (removed) {
            LOG.infof("Deportista eliminado. ID: %d", id);
        } else {
            LOG.warnf("No se pudo eliminar. ID inexistente: %d", id);
        }

        return removed;
    }

    private AthleteResponse toResponse(Athlete athlete) {
        return new AthleteResponse(
                athlete.id,
                athlete.firstName,
                athlete.lastName,
                athlete.email,
                athlete.discipline
        );
    }
}