# imagem base do Java
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado da aplicação
COPY target/*.jar app.jar

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]