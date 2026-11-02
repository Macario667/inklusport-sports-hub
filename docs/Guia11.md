# Guía 11 – Using the REST Client

## Objetivo
Consumir servicios REST externos desde Inklusport Sports Hub.

## Tecnología
- Quarkus REST Client.
- MicroProfile REST Client.
- Jackson.

## Componentes creados
- `ExternalPostClient`
- `ExternalPostService`
- `ExternalPostResource`
- `ExternalPostResponse`

## Configuración
Se registró el cliente mediante `@RegisterRestClient` y se configuró la URL externa en `application.properties`.

## Endpoint interno
GET `/api/external/posts/{id}`

## Servicio externo
JSONPlaceholder: `https://jsonplaceholder.typicode.com/posts/{id}`

## Pruebas
- [ ] La aplicación inicia correctamente.
- [ ] El cliente REST se inyecta correctamente.
- [ ] La petición externa devuelve datos.
- [ ] El recurso interno devuelve JSON.
- [ ] Se comprueba el manejo de errores de conexión.

## Estado
Pendiente de validación práctica.