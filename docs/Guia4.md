# Guía 04 — Configuration Reference Guide

## Objetivo

Profundizar en el sistema de configuración de Quarkus y aprender a administrar propiedades según el entorno de ejecución.

## Conceptos estudiados

- Configuración general.
- Perfiles `dev`, `test` y `prod`.
- Variables de entorno.
- Sobrescritura de propiedades.
- `@ConfigProperty`.
- `@ConfigMapping`.

## Configuración implementada

Se organizaron las propiedades de Inklusport en `application.properties`.

Propiedades principales:

- `inklusport.application.name`
- `inklusport.application.version`
- `inklusport.registration.max-per-event`
- `inklusport.notifications.enabled`

## Perfiles

| Perfil | Configuración |
|---|---|
| dev | Puerto 8080 y logs INFO |
| test | Puerto de pruebas dinámico y límite de 10 inscripciones |
| prod | Puerto 8080 y logs WARN |

## Variables de entorno

Se practicó la sobrescritura de propiedades mediante variables de entorno.

Ejemplo en PowerShell:

`$env:INKLUSPORT_REGISTRATION_MAX_PER_EVENT="50"`

## Configuración agrupada

Se creó la interfaz `InklusportConfig` con `@ConfigMapping`.

También se creó `ApplicationSettingsResource` para consultar las propiedades agrupadas.

## Endpoints de configuración

| Método | Endpoint | Función |
|---|---|---|
| GET | `/api/config` | Consultar propiedades individuales |
| GET | `/api/settings` | Consultar propiedades agrupadas |

## Pruebas

- [ ] Consultar la configuración general.
- [ ] Comprobar los valores del perfil dev.
- [ ] Comprobar la sobrescritura mediante variables de entorno.
- [ ] Consultar las propiedades agrupadas.
- [ ] Verificar la configuración del perfil test.

## Resultado

Pendiente de validación práctica.

## Referencias

- https://quarkus.io/guides/config
- https://quarkus.io/guides/config-reference