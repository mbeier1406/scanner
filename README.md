# Scanner Demoanwendung

Demonstration Jakarta&reg; EE Technologien.

# Technologien
Es wird die Java EE `Version 7.0` verwendet. Es existieren Beispiele für folgende APIs:
- **JavaServer Faces (JSF)** Version `2.2`: [Informationen bei Wikipedia](https://de.wikipedia.org/wiki/JavaServer_Faces)
- **Java Persistence API (JPA)** Version `2.1`: [Informationen bei Wikipedia](https://de.wikipedia.org/wiki/Java_Persistence_API)

Die verwendete [Maven dependency](https://mvnrepository.com/artifact/javax/javaee-api/7.0) ist:

```xml
        <dependency>
              <groupId>javax</groupId>
              <artifactId>javaee-api</artifactId>
              <version>7.0</version>
              <scope>provided</scope>
        </dependency>
```

## Persistenz
![oracle logo](https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Oracle_logo.svg/663px-Oracle_logo.svg.png "Oracle")<p/>
Zur Speicherung der Daten wird eine
[Oracle Database Express Edition (XE) Release 18.4.0.0.0 (18c)](https://www.oracle.com/database/technologies/xe-downloads.html) in einem [Docker Container](https://github.com/oracle/docker-images) verwendet
(siehe [Installationsbeschreibung](https://blogs.oracle.com/oraclemagazine/deliver-oracle-database-18c-express-edition-in-containers)).




