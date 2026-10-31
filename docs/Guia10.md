# Guía 10 – Using OpenAPI and Swagger UI

## Objetivo
Documentar los endpoints REST de Inklusport Sports Hub y facilitar su exploración.

## Tecnología
- SmallRye OpenAPI.
- Swagger UI.
- MicroProfile OpenAPI.

## Configuración
Se agregó información descriptiva de la API en `application.properties`:

```properties
quarkus.smallrye-openapi.info-title=Inklusport Sports Hub API
quarkus.smallrye-openapi.info-version=1.0.0
quarkus.smallrye-openapi.info-description=API para la gestión de deportistas de Inklusport Sports Hub
quarkus.swagger-ui.always-include=true
```

## Documentación del recurso
Se incorporaron anotaciones `@Tag` y `@Operation` en `AthleteResource`.

## Direcciones
- Swagger UI: `/q/swagger-ui`
- Documento OpenAPI: `/q/openapi`

## Pruebas
- [ ] Acceder a Swagger UI.
- [ ] Visualizar los endpoints de deportistas.
- [ ] Consultar el documento OpenAPI.
- [ ] Ejecutar una petición GET desde Swagger UI.
- [ ] Ejecutar una petición POST desde Swagger UI.

## Estado
Pendiente de validación práctica.