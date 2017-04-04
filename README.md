# coffee-shop
This project demonstrates how to use docker to package and deploy an application stack including a user interface, a rest service, and an ephemeral database.

**Note**: This project requires docker to be installed. See https://docs.docker.com for information on how to install docker on your OS. 

This project contains three projects:
 - coffee-shop-ui
 - coffee-shop-service
 - coffee-shop database
 
 
In order to build the three docker images run the following commands.
```bash
cd coffee-shop-ui
mvn clean package
docker build -t coffee-shop/ui:latest .
```
```bash
cd coffee-shop-service
mvn clean package
docker build -t coffee-shop/service:latest .
```
```bash
cd coffee-shop-database
docker build -t coffee-shop/database:latest .
```

Follow these commands to wire together the containers using docker service names:

```bash
docker network create coffee-shop
```
```bash
docker run -d --net coffee-shop --name coffee-shop-database coffee-shop/database:latest
```
```bash
docker run -d --net coffee-shop --name coffee-shop-service coffee-shop/service:latest
```
```bash
docker run -d --net coffee-shop --name coffee-shop-ui -p 8080:8080 coffee-shop/ui:latest
```

Once those are all up and running, Navigate to http://localhost:8080/coffee-shop-ui
Voila! You have successfully deployed a full web app end to end using docker.