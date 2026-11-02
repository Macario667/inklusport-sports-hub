package com.inklusport.athlete;

import com.inklusport.athlete.entity.Athlete;
import com.inklusport.athlete.repository.AthleteRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TransactionDemoService {

    @Inject
    AthleteRepository athleteRepository;

    @Transactional
    public void createAthleteAndFail() {

        Athlete athlete = new Athlete();

        athlete.firstName = "Test";
        athlete.lastName = "Transaction";
        athlete.email = "transaction.test@example.com";
        athlete.discipline = "Atletismo";

        athleteRepository.persist(athlete);

        throw new RuntimeException(
                "Simulación de error para comprobar rollback"
        );
    }
}