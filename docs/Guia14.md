# Guía 14 — Uso de Hibernate ORM con Panache

## 1. Descripción General

En esta guía, se integró Hibernate ORM con Panache en Inklusport Sports Hub para proporcionar almacenamiento persistente para la información de los atletas.

La implementación anterior en memoria se reemplazó con persistencia en PostgreSQL a través de Hibernate ORM y el patrón de repositorio de Panache.

## 2. Objetivos

- Comprender Hibernate ORM con Panache.
- Crear entidades persistentes.
- Implementar repositorios utilizando Panache.
- Separar los recursos REST, los servicios y el acceso a datos.
- Realizar operaciones CRUD con PostgreSQL.
- Verificar la persistencia de los datos.

## 3. Tecnologías

- Java
- Quarkus
- Hibernate ORM con Panache
- PostgreSQL
- Maven
- Jakarta Transactions
- Jakarta REST

## 4. Estructura del Proyecto

```text
com.inklusport.athlete
├── AthleteResource.java
├── AthleteService.java
├── dto
│   ├── AthleteRequest.java
│   └── AthleteResponse.java
├── entity
│   └── Athlete.java
└── repository
    └── AthleteRepository.java
```

## 5. Implementación de la Entidad

La entidad `Athlete` extiende de `PanacheEntity`, lo que proporciona un identificador generado automáticamente.

La entidad se mapea con la tabla `athletes` de PostgreSQL.

Sus atributos son:

- `firstName`
- `lastName`
- `email`
- `discipline`

La configuración de las columnas se define mediante anotaciones JPA como `@Entity`, `@Table` y `@Column`.

## 6. Implementación del Repositorio

El `AthleteRepository` implementa `PanacheRepository<Athlete>`.

Esto proporciona operaciones de base de datos comunes, que incluyen:

- `listAll()`
- `findByIdOptional()`
- `persist()`
- `deleteById()`

## 7. Capa de Servicio

El `AthleteService` implementa la lógica de la aplicación y delega las operaciones de la base de datos a `AthleteRepository`.

Proporciona los siguientes métodos:

- `findAll()`
- `findById(Long id)`
- `create(AthleteRequest request)`
- `update(Long id, AthleteRequest request)`
- `delete(Long id)`

El servicio también convierte las entidades persistentes en DTOs de respuesta.

Las operaciones de escritura utilizan `@Transactional` para gestionar las transacciones de la base de datos.

## 8. Endpoints REST

El `AthleteResource` expone los siguientes endpoints:

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/athletes` | Listar atletas |
| GET | `/api/athletes/{id}` | Buscar un atleta |
| POST | `/api/athletes` | Crear un atleta |
| PUT | `/api/athletes/{id}` | Actualizar un atleta |
| DELETE | `/api/athletes/{id}` | Eliminar un atleta |

La validación de las solicitudes se mantiene a través de Hibernate Validator y `@Valid`.

## 9. Pruebas

Se probaron las siguientes operaciones CRUD:

1. Crear un atleta mediante POST.
2. Listar atletas mediante GET.
3. Recuperar un atleta por ID.
4. Actualizar la información del atleta mediante PUT.
5. Eliminar un atleta mediante DELETE.
6. Verificar los registros directamente en PostgreSQL.

Las pruebas confirmaron que la API REST se comunica con la base de datos PostgreSQL y que la información del atleta se persiste.

## 10. Ejecución de la Aplicación

Inicie la aplicación en modo de desarrollo:

```bash
mvn quarkus:dev
```

La API está disponible en:

```text
http://localhost:8080/api/athletes
```

## 11. Conclusión

Hibernate ORM con Panache se integró con éxito en Inklusport Sports Hub.

La información de los atletas ahora se almacena de forma persistente en PostgreSQL en lugar de una colección en memoria.

La aplicación mantiene una separación de responsabilidades entre los recursos REST, servicios, repositorios, entidades y DTOs.
