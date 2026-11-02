# Guía 12 – SmallRye Fault Tolerance

## Objetivo
Proteger las comunicaciones externas frente a fallos y tiempos de espera.

## Tecnología
SmallRye Fault Tolerance y MicroProfile Fault Tolerance.

## Mecanismos implementados
- `@Retry`: reintentos automáticos.
- `@Timeout`: límite de tiempo.
- `@CircuitBreaker`: interrupción temporal de llamadas ante fallos repetidos.
- `@Fallback`: respuesta alternativa.

## Clase modificada
`ExternalPostService`

## Pruebas
- [ ] La consulta externa funciona normalmente.
- [ ] Se comprueba un fallo de conexión.
- [ ] Se observa el comportamiento de reintentos.
- [ ] Se comprueba la respuesta alternativa.
- [ ] Se restaura la URL externa original.

## Consideraciones
La respuesta fallback del ejercicio devuelve HTTP 200. En un escenario productivo se debería evaluar una respuesta HTTP de error apropiada.

## Estado
Pendiente de validación práctica.