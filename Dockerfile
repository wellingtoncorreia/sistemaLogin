# imagem base do Java [cite: 1]
FROM openjdk:17-jdk-slim [cite: 1]

# Define o diretório de trabalho [cite: 1]
WORKDIR /app [cite: 1]

# Copia o JAR gerado da aplicação [cite: 1]
COPY target/*.jar app.jar [cite: 1]

# Executa a aplicação [cite: 1]
ENTRYPOINT ["java", "-jar", "app.jar"] [cite: 1]