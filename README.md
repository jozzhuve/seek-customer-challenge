## Reto Tecnico Seek

### Sistema de Gestión de registro, consulta y análisis de datos de clientes
### Microservicio basado en spring boot 2.x y Java 17 implementado bajo una arquitectura hexagonal

<img alt="img.png" src="https://miro.medium.com/v2/resize:fit:1400/1*yR4C1B-YfMh5zqpbHzTyag.png?raw=true">

### Stack tecnologico
:
- Spring boot
- Spring Security
- Mysql
- Flyway
- JWT
- Open Api 3.0
- JPA
- Lombok
- MapStruck
- Docker
- Junit with Mockito

## Ejecutar mediante comando Spring Boot application
```
mvn spring-boot:run
```
## Construir y ejecutar con docker
```
docker build -t reto-tecnico .
docker run -p 8080:8080 reto-tecnico
```

## Ruta Swagger
```
http://localhost:8080/swagger-ui/index.html
```

Endpoints disponibles:

1- Obtener Token

| Método | URI       |
|--------|-----------|
| Get    | /v1/seguridad/token |

##### Headers

```javascript
user: jhurtado
password: $e3K2024
```

##### Payload Response exitoso

```javascript
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJcInVzZXJUZXN0XCIiLCJpYXQiOjE3Mjc2NzE0MTQsImV4cCI6MTcyNzY4MDA1NH0.a577SnL6hmTHqAj47doKWEJ07k2DgjUJsM5H6xCo4RY"
}
```
2- Registrar candidato

| Método | URI       |
|--------|-----------|
| Post   | /v1/customers |

##### Headers

```javascript
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJcInVzZXJUZXN0XCIiLCJpYXQiOjE3Mjc2NzA1NTYsImV4cCI6MTcyNzY3OTE5Nn0.2r5iRxEVPpOtQMvT1JHNHvhlzyyVTnEkwO0hafNn0Eo
```

##### Payload request

```javascript
{
    "nombre": "Jose Antonio",
    "apellido": "Hurtado Vergara",
    "edad": 38,
    "fechaNacimiento": "28-09-1984"
}
```

##### Payload Response

```javascript
{
    "id": 13,
    "nombre": "Jose Antonio",
    "apellido": "Hurtado Vergara",
    "edad": 38,
    "fechaNacimiento": "1984-09-28T05:00:00.000+00:00"
}
```

3- Obtener metricas de promedio de edad y desviacion estandar de edades de clientes

| Método | URI                   |
|--------|-----------------------|
| Get    | /v1/customers/metrics |

##### Headers

```javascript
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJcInVzZXJUZXN0XCIiLCJpYXQiOjE3Mjc2NzA1NTYsImV4cCI6MTcyNzY3OTE5Nn0.2r5iRxEVPpOtQMvT1JHNHvhlzyyVTnEkwO0hafNn0Eo
```

##### Payload request

```javascript
(Al ser metodo get not existe payload por buena practica)
```

##### Payload Response

```javascript
{
    "promedioEdad": 37.92307692307692,
    "desviacionEstandarEdad": 7.130233985388596
}
```

4- Obtener clientes y su esperanza de vida basado en edades de mortalidad en Peru

| Método | URI                |
|--------|--------------------|
| Put    | /v1/customers/life-expectancy |

##### Headers

```javascript
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJcInVzZXJUZXN0XCIiLCJpYXQiOjE3Mjc2NzA1NTYsImV4cCI6MTcyNzY3OTE5Nn0.2r5iRxEVPpOtQMvT1JHNHvhlzyyVTnEkwO0hafNn0Eo
```

##### Payload request

```javascript
{
    "age": 40
}
```

##### Payload Response

```javascript
{
    "customers": [
        {
            "id": 1,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 2,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 3,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 4,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 5,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 6,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 7,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 8,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 9,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 40,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 10,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 22,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 62.666666666666664
        },
        {
            "id": 11,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 23,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 62.666666666666664
        },
        {
            "id": 12,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 50,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        },
        {
            "id": 13,
            "nombre": "Jose Antonio",
            "apellido": "Hurtado Vergara",
            "edad": 38,
            "fechaNacimiento": "1984-09-28T05:00:00.000+00:00",
            "esperanzaVida": 68.2
        }
    ]
}
```
##### Aspectos adicionales:

```javascript
Se agregaron validaciones de negocio, jerarquia de excepciones y advisors en la capa de infraestructura con la finalidad de mejorar la experiencia del usuario en caso de errores
```
