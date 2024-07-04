# We must use an image based on a JDK (not a JRE) for Azure App Insight activated programmatically
FROM acrdcactia.azurecr.io/openjdk/jdk:21-ubuntu@sha256:35a79861b4fd4616dc45122ee0b98619a15d13d10ead1b332db986824da1433b
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
CMD ["-Xms500m", "-Xmx500m"]
