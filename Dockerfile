# Utiliza Java 17 para a etapa de construção
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Utiliza uma imagem base Java 17 para a execução
FROM openjdk:17-alpine


COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Define o ponto de entrada para iniciar a aplicação Java
ENTRYPOINT ["java", "-jar", "/app.jar"]
