poc-swagger-springmvc
======================

A set of apps that test or demo swagger-spring mvc https://github.com/martypitt/swagger-springmvc/

About Swagger: http://swagger.wordnik.com/

Swagger UI is a dependency-free collection of HTML, Javascript, and CSS assets that dynamically generate beautiful documentation from a Swagger-compliant API;

https://github.com/wordnik/swagger-ui

## Build dan Run ##

Running the project : 

1. Execute mvn clean install in top level folder
2. Go to web folder, and run mvn jetty:run
3. Browse your http://localhost:9699

## Configuration ##

* Application's port : edit 'pom.xml' in top level folder, property: 'appserver.port.http'
* Context Path : edit 'pom.xml' in top level folder, property: 'appserver.deployment.context'

### Automated testing used :  ###

rest-assured
* http://code.google.com/p/rest-assured/wiki/Usage 
* http://www.hascode.com/2011/10/testing-restful-web-services-made-easy-using-the-rest-assured-framework/ 


## For Techies, Geeks 'n Coders ##

### Framework dan Libraries ###

* Spring Framework 4.0.6
* Spring Security 2.3.5
* swagger-springmvc 0.8.8
* jackson-jaxrs 1.9.13
* Google Guava 15.0 (important, lesser version may causing runtime error)

### Tools ###

* Build Tool : Maven 3
* Integration Test Runner : Maven Failsafe Plugin
* Functional Test : Rest-Assured, swagger-ui


## Dariawan or Dallanube? ##
Dariawan is short-form of my full name Desson Ariawan. It's translated into "From The Cloud" in English or "Dalla Nube" in Italian. That's the background of my project name

Cheers,
Desson Ariawan
