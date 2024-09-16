This is a simple Java project using Spring Framework, and the following dependency:

Spring Web
Spring Data JPA
H2 Database
OpenFeign
Spring Doc OpenAPI (Swagger)

The main idea of the project is provide a service where can be inputted few fields for a car register as name, brand and the fabrication year.
Then the application will consume a service provided by [Fipe API Http Rest](https://deividfortuna.github.io/fipe/) and will complete the car information with gas type and price.

Example of input:

```
{
  "name": "Uno 1.6",
  "brand": "Fiat",
  "madeYear": 1996
}
```

output:

```
{
  "id": 1,
  "name": "Uno 1.6 mpi 2p e 4p",
  "brand": "Fiat",
  "madeYear": 1996,
  "gasType": "Gasolina",
  "price": "R$ 8.769,00"
}
```
<div>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" alt="spring" width="30" height="30"/>
</div>


