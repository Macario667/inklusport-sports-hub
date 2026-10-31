# Guía 7 – JSON

## Objetivo
Comprender la serialización y deserialización JSON en Quarkus utilizando Jackson.

## Conceptos
- JSON
- Serialización
- Deserialización
- Jackson
- Content-Type
- Accept

## Configuración
Se configuró Jackson en `application.properties`:

```properties
quarkus.jackson.fail-on-unknown-properties=false
quarkus.jackson.serialization-inclusion=non-null
```

## Dependencia
Se utiliza la extensión `rest-jackson`, incluida en el proyecto.

## Validación
- [ ] La aplicación inicia correctamente.
- [ ] GET devuelve JSON.
- [ ] POST recibe JSON.
- [ ] La respuesta contiene los datos esperados.

## Estado
Pendiente de validación práctica.