# Guía 05 — Writing REST Services with Quarkus REST

## Objetivo

Construir servicios REST utilizando Quarkus REST y separar las responsabilidades de la aplicación.

## Conceptos estudiados

- Recursos REST.
- Métodos HTTP.
- Inyección de dependencias.
- Capa de servicios.
- DTOs de entrada y salida.
- Códigos de respuesta HTTP.
- Uso de Optional.

## Arquitectura implementada

Se organizó el módulo de deportistas de la siguiente manera:

```text
athlete/
├── dto/
│   ├── AthleteRequest.java
│   └── AthleteResponse.java
├── AthleteResource.java
└── AthleteService.java
```

## Responsabilidades

- `AthleteResource`: gestiona las solicitudes HTTP.
- `AthleteService`: contiene la lógica de negocio.
- `AthleteRequest`: representa los datos recibidos.
- `AthleteResponse`: representa los datos devueltos.

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/athletes` | Listar deportistas |
| GET | `/api/athletes/{id}` | Consultar por ID |
| POST | `/api/athletes` | Registrar deportista |
| PUT | `/api/athletes/{id}` | Actualizar deportista |
| DELETE | `/api/athletes/{id}` | Eliminar deportista |

## Persistencia

Se utilizó almacenamiento temporal en memoria. Esta implementación se reemplazará por PostgreSQL y Panache en la Guía 14.

## Pruebas

- [ ] Listar deportistas.
- [ ] Crear deportista.
- [ ] Consultar por ID.
- [ ] Actualizar deportista.
- [ ] Eliminar deportista.
- [ ] Comprobar respuesta 404.

## Resultado

Pendiente de validación práctica.

## Referencia

https://quarkus.io/guides/rest