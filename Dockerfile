FROM openjdk:17.0.2-jdk-slim
MAINTAINER namene grocery payment service
COPY target/paymentservice-0.0.1-SNAPSHOT.jar paymentservice-0.0.1-SNAPSHOT.jar

#RUN chmod 755 /posdataservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar", "/paymentservice-0.0.1-SNAPSHOT.jar" ]
