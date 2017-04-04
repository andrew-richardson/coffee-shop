FROM jboss/wildfly:10.0.0.Final
MAINTAINER arichardson2189@gmail.com

COPY target/coffee-shop-ui-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/coffee-shop-ui.war

CMD ["/opt/jboss/wildfly/bin/standalone.sh","-b","0.0.0.0","-bmanagement","0.0.0.0"]