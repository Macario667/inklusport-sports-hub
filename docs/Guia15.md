# Guía 15 — MongoDB con Panache

## 1. Descripción General

Esta guía introduce MongoDB con Panache en Inklusport Sports Hub.

Se implementó un módulo de persistencia basado en documentos para gestionar los eventos deportivos de forma independiente al módulo de atletas almacenado en PostgreSQL.

## 2. Objetivos

- Configurar MongoDB en Quarkus.
- Comprender Panache para MongoDB.
- Crear entidades de documentos.
- Implementar repositorios de MongoDB.
- Desarrollar servicios REST para eventos deportivos.
- Realizar operaciones CRUD.
- Verificar la persistencia de los documentos.

## 3. Tecnologías

- Java
- Quarkus
- MongoDB
- MongoDB con Panache
- Maven
- Jakarta REST
- Hibernate Validator

## 4. Arquitectura

La aplicación utiliza dos tecnologías de persistencia:

- PostgreSQL con Hibernate ORM y Panache para los atletas.
- MongoDB con MongoDB Panache para los eventos deportivos.

## 5. Entidad

La entidad `SportEvent` extiende de `PanacheMongoEntity`.

Contiene:

- name (nombre)
- description (descripción)
- sport (deporte)
- location (ubicación)
- eventDate (fecha del evento)
- status (estado)

El identificador heredado es un `ObjectId`.

## 6. Repositorio

`SportEventRepository` implementa `PanacheMongoRepository<SportEvent>`.

Esto proporciona operaciones comunes para documentos, incluyendo listar, buscar, persistir, actualizar y eliminar.

## 7. Capa de Servicio

`SportEventService` implementa la lógica de la aplicación y delega las operaciones de persistencia al repositorio.

Métodos implementados:

- findAll()
- findById()
- create()
- update()
- delete()

## 8. API REST

El recurso expone:

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/events` | Listar eventos |
| GET | `/api/events/{id}` | Recuperar un evento |
| POST | `/api/events` | Crear un evento |
| PUT | `/api/events/{id}` | Actualizar un evento |
| DELETE | `/api/events/{id}` | Eliminar un evento |

## 9. Validación

La validación de las solicitudes se realiza mediante Jakarta Bean Validation.

Los nombres de los eventos, deportes, ubicaciones, fechas y estados se validan antes de la persistencia.

## 10. Pruebas

Las operaciones CRUD se prueban mediante solicitudes HTTP de PowerShell.

La persistencia de los documentos de MongoDB se verifica a través de MongoDB Shell o MongoDB Compass.

## 11. Conclusión

MongoDB con Panache se introdujo como una solución de persistencia complementaria en Inklusport Sports Hub.

La aplicación ahora separa los datos relacionales de los atletas de los datos orientados a documentos de los eventos deportivos.
