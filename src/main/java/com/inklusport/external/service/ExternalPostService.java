package com.inklusport.external.service;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.inklusport.external.client.ExternalPostClient;
import com.inklusport.external.dto.ExternalPostResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped 
public class ExternalPostService {
    
    @Inject 
    @RestClient 
    ExternalPostClient externalPostClient;

    /**
     * @Retry(maxRetries = 2, delay = 500): 2 intentos adicionales con un tiempo de espera de 500 milisegundo
     * @Timeout(4000): limita la ejecución a cuatro segundos.
     * @CircuitBreaker: analiza los fallos y puede abrir el circuito.
     * @Fallback: proporciona una respuesta alternativa si la operación no se completa.
     */
    @Retry(maxRetries = 2, delay = 500)
    @Timeout(4000)
    @CircuitBreaker(
        requestVolumeThreshold = 4, /** Monitorea bloques de 4 solicitudes consecutivas */
        failureRatio = 0.5, /** Abre el circuito si el 50% de las solicitudes fallan (2 de 4) */
        delay = 5000 /** Mantiene el circuito OPEN por 5 segundos antes de pasar a HALF-OPEN */
    )
    @Fallback(fallbackMethod = "getPostFallback")
    public ExternalPostResponse getPost(Long id) {
        return externalPostClient.getPost(id);
    }

    public ExternalPostResponse getPostFallback(Long id) {
        return new ExternalPostResponse(
            null,
            id,
            "Servicio externo temporalmente no disponible",
            "No fue posible consultar la información en este momento."
        );
    }

}
