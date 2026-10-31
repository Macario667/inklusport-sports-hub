# Inklusport Sports Hub

API REST para la gestión de una plataforma deportiva inclusiva, desarrollada con Quarkus.

## Tecnologías

- Java 21
- Quarkus 3.40.1
- Maven
- PostgreSQL
- Hibernate ORM with Panache
- MongoDB with Panache
- REST Jackson
- Hibernate Validator
- SmallRye OpenAPI
- SmallRye Fault Tolerance
- Scheduler
- REST Client

## Objetivo

Construir una API REST que permita gestionar deportistas, disciplinas, eventos deportivos, inscripciones, resultados e información de accesibilidad.

El proyecto utiliza PostgreSQL para los datos relacionales y MongoDB para información complementaria y flexible.

## Guías de implementación

| Guía | Tema | Estado |
|---|---|---|
| 01 | Creating Your First Application | Listo |
| 02 | Configuring Your Application | Listo |
| 03 | RESTEasy Classic | Listo |
| 04 | Configuration Reference Guide | Listo |
| 05 | Writing REST Services | Listo |
| 06 | Configuring Logging | Listo |
| 07 | JSON | Listo |
| 08 | Writing JSON REST Services | Listo |
| 09 | Validation | Pendiente |
| 10 | OpenAPI and Swagger UI | Pendiente |
| 11 | REST Client | Pendiente |
| 12 | SmallRye Fault Tolerance | Pendiente |
| 13 | Datasources | Pendiente |
| 14 | Hibernate ORM with Panache | Pendiente |
| 15 | MongoDB Client | Pendiente |
| 16 | MongoDB with Panache | Pendiente |
| 17 | Scheduling Periodic Tasks | Pendiente |
| 18 | Testing Your Application | Pendiente |

## Documentación

La explicación detallada de cada etapa estará disponible en la carpeta `docs/`.

## Ejecución

Para iniciar la aplicación en modo desarrollo:

```bash
mvn quarkus:dev
```

## Endpoints iniciales

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/health` | Estado de la aplicación |
| GET | `/api/config` | Consulta de configuración |

## Autoría y aprendizaje

Proyecto de aprendizaje práctico y progresivo de Quarkus, construido mediante la implementación de sus guías oficiales y aplicado al dominio de Inklusport Sports Hub.