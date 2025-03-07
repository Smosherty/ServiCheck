# 📌 Documentación para Desarrolladores

Este proyecto consta de un backend en **Spring Boot** y un frontend en **Angular**. A continuación, se detallan los aspectos clave para entender y trabajar en el código.

## 📁 Estructura de la Documentación

La documentación se organiza en varios archivos para facilitar su consulta:

- [Arquitectura del Proyecto](docs/arquitectura.md)
- [Endpoints de la API](docs/endpoints.md)
- [Convenciones de Código](docs/convenciones-codigo.md)
- [Guía de Despliegue](docs/guia-despliegue.md)
- [Pruebas y Testing](docs/testing.md)
- [Variables de Entorno](.env.example)

---

## 📜 1. [Arquitectura del Proyecto](docs/arquitectura.md)

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

---

## 🌐 2. [Endpoints de la API](docs/endpoints.md)

- Listado de endpoints con detalles sobre cada uno.
- Se accede desde los controladores (`controllers/`).

---

## 📏 3. [Convenciones de Código](docs/convenciones-codigo.md)

- Uso de **Lombok** para getters/setters.
- Estilo de nombres de clases, métodos y variables.
- Organización de paquetes y dependencias.

---

## 🚀 4. [Guía de Despliegue](docs/guia-despliegue.md)

- Instalación de **Java 17**.
- Cómo ejecutar el backend con **Maven Wrapper**.
- Configuración de variables de entorno.
- Creación y configuración de la base de datos en **MySQL**.

---

## 🧪 5. [Pruebas y Testing](docs/testing.md)

- Cómo ejecutar pruebas unitarias.
- Uso de **Spring Boot Test**.

---

## 🔑 6. [Variables de Entorno](.env.example)

Ejemplo de archivo `.env` con las variables de entorno necesarias para ejecutar el proyecto correctamente.

---

✍️ **Esta documentación puede expandirse con más detalles según sea necesario.**
