FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/*.jar TweetApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /TweetApplication-0.0.1-SNAPSHOT.jar"]
