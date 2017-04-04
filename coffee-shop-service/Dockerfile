FROM jboss/wildfly:10.0.0.Final
MAINTAINER arichardson2189@gmail.com

## Add admin console user
RUN /opt/jboss/wildfly/bin/add-user.sh -u admin -p pwd --silent

## COPY over war into deployments folder
COPY target/coffee-shop-service.war /opt/jboss/wildfly/standalone/deployments/coffee-shop.war

## Install postgres JDBC driver && datasource configuration
WORKDIR /tmp
RUN curl -LO http://repo1.maven.org/maven2/org/postgresql/postgresql/9.4.1210/postgresql-9.4.1210.jar
WORKDIR ~
COPY commands.cli /opt/jboss/wildfly/customization/
COPY execute.sh /opt/jboss/wildfly/customization/

## Execute standalone modifications
RUN sh /opt/jboss/wildfly/customization/execute.sh

## fix problem with modifying standalone causing permissions issues
RUN rm -rf /opt/jboss/wildfly/configuration/standalone_xml_history/current/*

## This will be process 1 of the container
CMD ["/opt/jboss/wildfly/bin/standalone.sh","-b","0.0.0.0","-bmanagement","0.0.0.0"]