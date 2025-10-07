FROM eclipse-temurin:21.0.8_9-jre

WORKDIR /app

# hadolint ignore=DL3002
# USER root

# ARG UID=10001
# RUN adduser \
#     --disabled-password \
#     --gecos "" \
#     --home "/nonexistent" \
#     --shell "/sbin/nologin" \
#     --no-create-home \
#     --uid "${UID}" \
#     spring

COPY build/libs/mydemo.jar mydemo.jar

EXPOSE 8080

# USER spring

ENTRYPOINT ["java", "-jar", "/app/mydemo.jar"]
