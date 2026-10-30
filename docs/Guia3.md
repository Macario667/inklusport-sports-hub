# Guía 03 — RESTEasy Classic

## Objetivo

Comprender el modelo REST tradicional de Quarkus y practicar las anotaciones de Jakarta REST para construir servicios HTTP.

## Conceptos estudiados

- `@Path`
- `@GET`
- `@POST`
- `@PUT`
- `@DELETE`
- `@Produces`
- `@Consumes`
- `@PathParam`
- Códigos de respuesta HTTP.

## Consideración arquitectónica

El proyecto principal utiliza Quarkus REST mediante la extensión `rest-jackson`. RESTEasy Classic es un stack diferente. Esta guía se utiliza para estudiar y comparar el modelo clásico, sin incorporar sus extensiones al proyecto principal.

## Implementación

Se creó `AthleteResource`, encargado de gestionar deportistas mediante operaciones CRUD.

Endpoint base:

`/api/athletes`

| Método | Ruta | Función |
|---|---|---|
| GET | `/api/athletes` | Listar deportistas |
| GET | `/api/athletes/{id}` | Consultar deportista |
| POST | `/api/athletes` | Crear deportista |
| PUT | `/api/athletes/{id}` | Actualizar deportista |
| DELETE | `/api/athletes/{id}` | Eliminar deportista |

## Persistencia

Se utilizó temporalmente una lista en memoria para practicar los endpoints. Los datos no son persistentes y se perderán al reiniciar la aplicación.

En las siguientes etapas se implementará PostgreSQL con Hibernate ORM y Panache.

## Pruebas

- [ ] Crear un deportista.
- [ ] Consultar todos los deportistas.
- [ ] Consultar un deportista por ID.
- [ ] Actualizar un deportista.
- [ ] Eliminar un deportista.
- [ ] Comprobar respuestas para identificadores inexistentes.

## Resultado

Pendiente de validación práctica.

## Referencias

- https://quarkus.io/guides/resteasy
- https://quarkus.io/guides/rest