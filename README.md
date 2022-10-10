**Payment Methods**

Pre-requisite
1. Java 11
2. Maven 3.6.3
3. Postgres

Setup:
1. Create Database `postgres`
2. Add following credentials in `application-dev.yml`
   1. `database-url`
   2. `database-username`
   3. `database-password`
3. Build then Run Project using the following commands
   1. `mvn clean`
   2. `mvn package`
   3. `java -jar target/payment_methods.jar`
4. To access the swagger-document hit the following url in your browser
   1. http://localhost:8989/api/v1.0/configuration/swagger-ui/index.html

**Note:** Currently application runs on port **8989**
   