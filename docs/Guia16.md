# Guía 16 — Transacciones

## 1. Descripción General

Esta guía introduce la gestión de transacciones en Inklusport Sports Hub utilizando Jakarta Transactions y Quarkus.

La implementación demuestra cómo las operaciones de la base de datos se pueden confirmar (commit) o revertir (rollback) cuando ocurre un error.

## 2. Objetivos

- Comprender las transacciones de bases de datos.
- Aprender las propiedades ACID.
- Utilizar `@Transactional`.
- Comprender los límites de las transacciones (boundaries).
- Demostrar el comportamiento de reversión (rollback).
- Verificar la consistencia transaccional en PostgreSQL.

## 3. Tecnologías

- Java
- Quarkus
- Hibernate ORM con Panache
- PostgreSQL
- Jakarta Transactions

## 4. Propiedades ACID

- Atomicidad: todas las operaciones tienen éxito o se revierten.
- Consistencia: las reglas de integridad de la base de datos se mantienen satisfechas.
- Aislamiento: las transacciones concurrentes están aisladas entre sí.
- Durabilidad: los cambios confirmados permanecen persistentes.

## 5. Gestión de Transacciones

La anotación `@Transactional` define el límite de una transacción alrededor de un método de servicio.

La transacción se confirma cuando el método finaliza correctamente.

Una excepción en tiempo de ejecución (runtime exception) provoca que la transacción se revierta de forma predeterminada.

## 6. Demostración de Reversión (Rollback)

Un servicio de demostración crea un atleta y luego lanza deliberadamente una excepción en tiempo de ejecución.

Se espera que la transacción se revierta, no dejando ningún registro de atleta correspondiente en PostgreSQL.

## 7. Verificación

El comportamiento de la reversión se verifica consultando en PostgreSQL la dirección de correo electrónico de prueba.

El resultado esperado es cero registros coincidentes.

## 8. Conclusión

La gestión de transacciones ayuda a mantener la consistencia y fiabilidad de la base de datos.

Quarkus y Jakarta Transactions proporcionan un enfoque declarativo para gestionar transacciones en la capa de servicio de la aplicación.
