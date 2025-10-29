# GitHub Client — Examen P3 (JavaFX)

Aplicación JavaFX que consulta la API pública de GitHub para:

Buscar un usuario por su login.

Mostrar su perfil (avatar, nombre, bio, seguidores, ubicación, blog, fecha de creación).

Listar repositorios públicos en una TableView con: nombre, descripción, lenguaje, ⭐ estrellas y fecha de última actualización.

Graficar los lenguajes usados (conteo por repositorio) en un PieChart.

Mostrar el porcentaje por lenguaje en una ListView.

Indicar el Rate Limit de GitHub: OK (N repos) — limit: X, remaining: Y, reset: hh:mm:ss.

# Tecnologias

Java 17+

JavaFX 23 (controls, fxml)

java.net.http (HTTP client)

Jackson (jackson-databind, jackson-annotations) para JSON

Maven

# Requisitos 
JDK 17 o superior

Maven 3.9+

Internet (la app consulta api.github.com)

# Como usar
git clone https://github.com/Josue20212/examen_Git.git

cd examen_Git

O tambien..

Importa el proyecto Maven.

Asegúrate que la clase principal sea application.examen_git.App.

Ejecuta el proyecto.

# POM Recomendada 
<properties>
  <maven.compiler.release>17</maven.compiler.release>
  <javafx.version>23</javafx.version>
  <jackson.version>2.18.0</jackson.version>
</properties>

<dependencies>
  <dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>${javafx.version}</version>
  </dependency>
  <dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>${javafx.version}</version>
  </dependency>

  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>${jackson.version}</version>
  </dependency>
  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>${jackson.version}</version>
  </dependency>
</dependencies>

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.13.0</version>
      <configuration>
        <release>${maven.compiler.release}</release>
      </configuration>
    </plugin>

    <plugin>
      <groupId>org.openjfx</groupId>
      <artifactId>javafx-maven-plugin</artifactId>
      <version>0.0.9</version>
      <configuration>
        <mainClass>application.examen_git.App</mainClass>
      </configuration>
    </plugin>
  </plugins>
</build>

# Model Info recomendado 
module application.examen_git {
  requires java.net.http;
  requires javafx.controls;
  requires javafx.fxml;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.annotation;
  requires java.desktop; // para Desktop.browse (abrir enlaces)

  opens application.examen_git to javafx.fxml;
  exports application.examen_git;

  // Jackson deserializa dominios
  opens application.examen_git.domain to com.fasterxml.jackson.databind;
}

# Estructura Deseada 
application.examen_git/
 ├─ App.java                     // main JavaFX
 ├─ PrimaryController.java       // controlador principal (UI)
 ├─ resources/application/examen_git/
 │   ├─ primary.fxml             // vista principal
 │   └─ styles.css               // (opcional)
 ├─ domain/
 │   ├─ User.java                // datos de usuario (Jackson)
 │   ├─ Repo.java                // repos (propiedades JavaFX)
 │   └─ LanguageStats.java       // porcentajes por lenguaje
 ├─ service/
 │   ├─ GitHubApi.java           // llamadas HTTP a GitHub
 │   └─ HttpClientFactory.java   // cliente HTTP reutilizable
 └─ util/
     └─ Formatter.java           // fechas bonitas, helpers
# Salida esperada 
<img width="1210" height="776" alt="image" src="https://github.com/user-attachments/assets/3d3babb1-0dc2-4431-88e9-daa2976c430a" />

  




