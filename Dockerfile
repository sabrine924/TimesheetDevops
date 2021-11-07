
FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war Timesheet-1.0.war
ENTRYPOINT ["java","-jar","/timesheet-1.0.war"]
