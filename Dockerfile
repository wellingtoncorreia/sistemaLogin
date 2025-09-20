# ESTÁGIO 1: Build (Compilação com Maven)
# Usamos uma imagem que já vem com Maven e Java 17
FROM maven:3.8-openjdk-17 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia primeiro o pom.xml para otimizar o cache do Docker
COPY pom.xml .

# Copia o código-fonte
COPY src ./src

# Executa o build do Maven para gerar o .jar, pulando os testes
RUN mvn package -DskipTests


# ESTÁGIO 2: Run (Execução)
# Usamos a imagem leve, apenas com o necessário para rodar Java
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar gerado no estágio 'builder' para a imagem final
COPY --from=builder /app/target/*.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]