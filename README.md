**Test project for Propellerhead**
**_Customers application_**

The project front-end is using Angular 6, so please 
consider having node.js installed on your computer https://nodejs.org/en/.
In order to launch the project, please type in command line gradlew bootRun
in Unix systems or gradlew.bat bootRun in Windows in the root folder of the project. The web-ui URL is http://localhost:8080
. Also you can run tests with a command gradlew test or gradlew.bat test in the root folder of the project.
The project uses in-memory database H2, thus only one
 default Spring Boot profile is intentionally left so you can
monitor sql queries in console and check database state 
on address http://localhost:8080/h2console. Also there is Swagger UI to check
REST API requests accessible via http://localhost:8080/swagger-ui.html.