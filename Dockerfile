FROM eclipse-temurin:17-jdk-alpine

WORKDIR /cecy_java_backend

COPY . .

CMD [ "./gradlew", "bootrun" ]