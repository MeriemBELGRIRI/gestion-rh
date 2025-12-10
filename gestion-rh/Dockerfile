# -------------------------
# Étape 1 : Build avec Maven + JDK 21
# -------------------------
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le pom.xml et télécharger les dépendances d'abord pour accélérer le build
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier tout le code source
COPY . .

# Compiler le projet et générer le jar (tests ignorés)
RUN mvn clean package -DskipTests

# -------------------------
# Étape 2 : Run avec JDK 21
# -------------------------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copier le jar construit depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port de l'application (à adapter si besoin)
EXPOSE 8083

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
