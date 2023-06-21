# FROM eclipse-temurin:17-jdk-alpine
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /java_back
COPY . .
CMD [ "./gradlew", "bootrun" ]
