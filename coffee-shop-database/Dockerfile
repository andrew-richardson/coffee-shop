FROM postgres:9.6

ENV POSTGRES_USER=coffee_admin
ENV POSTGRES_PASSWORD=password

COPY create-database.sql /docker-entrypoint-initdb.d/create-database.sql