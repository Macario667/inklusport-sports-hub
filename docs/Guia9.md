# Guía 9 – Validation with Hibernate Validator

## Objetivo
Implementar validaciones automáticas para los datos recibidos por la API.

## Tecnología
Hibernate Validator y Jakarta Bean Validation.

## Clases modificadas
- `AthleteRequest`
- `AthleteResource`

## Validaciones implementadas
- `@NotBlank`: campos obligatorios.
- `@Email`: formato del correo electrónico.
- `@Size`: longitud máxima de los campos.

## Activación
Los métodos POST y PUT reciben objetos anotados con `@Valid`.

## Pruebas
- [ ] Crear deportista con datos válidos.
- [ ] Rechazar nombre vacío.
- [ ] Rechazar correo inválido.
- [ ] Rechazar disciplina vacía.
- [ ] Comprobar respuesta HTTP 400 ante datos inválidos.

## Estado
Pendiente de validación práctica.