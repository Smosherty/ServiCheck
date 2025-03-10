## 📏 3. Convenciones de Código

### 3.1 Uso de Lombok
Para reducir el código repetitivo, se recomienda el uso de **Lombok** en las entidades y clases auxiliares. Las anotaciones más utilizadas son:

```java
@Data // Genera getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
```

Sin embargo, Lombok **no funciona correctamente en relaciones entre entidades** cuando se realiza un `@JoinColumn` para obtener un campo de otra tabla. En estos casos, es necesario definir manualmente los **getters y setters**.

### 3.2 Estilo de nombres
Se debe seguir la convención **camelCase** para nombrar clases, métodos y variables:

- **Clases**: PascalCase (Ejemplo: `UserService`, `EmployeeController`).
- **Métodos y variables**: camelCase (Ejemplo: `calculateSalary()`, `employeeName`).
- **Constantes**: UPPER_CASE con separadores de guion bajo (Ejemplo: `DEFAULT_TIMEOUT`).

### 3.3 Organización de paquetes
La estructura de paquetes debe seguir la convención basada en el `groupId` del `pom.xml`:  
**`com.fichajespi`** → División recomendada:

```
com.fichajespi
 ├── config          # Configuración de la aplicación
 ├── controller      # Controladores (API REST)
 ├── dto            # Clases DTO (Data Transfer Object)
 ├── entity         # Entidades JPA
 ├── repository     # Repositorios de acceso a datos
 ├── service        # Servicios de la aplicación
 ├── security       # Configuración de seguridad y JWT
 ├── specifications # Consultas complejas y filtros avanzados
```

### 3.4 Uso de dependencias y `pom.xml`
El archivo `pom.xml` debe mantenerse organizado y actualizado. Recomendaciones:
- **Versiones explícitas** solo cuando sea necesario (por ejemplo, `modelmapper` y `jjwt`).
- **Evitar dependencias innecesarias** para mantener un proyecto liviano.
- **Uso de `spring-boot-starter`** para incluir paquetes completos sin dependencias individuales.

Ejemplo de buenas prácticas en `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```