# Guía 8 – Writing JSON REST Services

## Objetivo
Implementar servicios REST que reciban y devuelvan JSON.

## Componentes
- `AthleteResource`
- `AthleteService`
- `AthleteRequest`
- `AthleteResponse`

## Configuración REST
El recurso utiliza:

```java
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
```

## Endpoints
- GET `/api/athletes`
- GET `/api/athletes/{id}`
- POST `/api/athletes`
- PUT `/api/athletes/{id}`
- DELETE `/api/athletes/{id}`

## Validación
- [ ] GET devuelve una lista JSON.
- [ ] GET por ID devuelve un objeto JSON.
- [ ] POST crea un deportista.
- [ ] PUT actualiza un deportista.
- [ ] DELETE elimina un deportista.
- [ ] Se comprueban los códigos HTTP esperados.

## Estado
Pendiente de validación práctica.