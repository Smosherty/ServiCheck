## [Arquitectura del Proyecto]

### Backend (Spring Boot)

- Se encuentra en `spring-boot_fichajesPi/`.
- Requiere **Java 17**.
- Usa **Maven Wrapper** (`./mvnw`) para la gestión de dependencias.
- Se inicia con `./mvnw spring-boot:run`.
- Variables de entorno en `src/main/resources/application.properties`.
- Código principal en `src/main/java/com/fichajesPi/` con módulos como:
  - **config/**       →   Configuración del proyecto.
  - **controllers/**  →   Definición de endpoints.
  - **dto/**          →   Conversión de entidades a DTOs.
  - **entity/**       →   Definición de entidades y relaciones con **Lombok**.
  - **security/**     →   Manejo de autenticación JWT.
  - **service/**      →   Lógica de negocio.
  - **repository/**   →   Acceso a la base de datos (MySQL).

### Dependencias Clave (pom.xml)
- `spring-boot-starter-parent`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-web`
- `lombok`

### Base de Datos
- **MySQL** como base de datos principal.
- Entidades definidas en `src/main/java/com/fichajesPi/entity/`.

## [Endpoints de la API](docs/endpoints.md)

- Listado de endpoints con detalles sobre cada uno.
- Se accede desde los controladores (`controllers/`).
