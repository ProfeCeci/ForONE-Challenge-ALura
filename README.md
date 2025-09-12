## **ForoONE-Challenge-ALura**

¡Bienvenido al repositorio de la API del ForoONE\! Este proyecto es una **API RESTful** para un foro, desarrollada como parte del desafío de backend de Alura.

### **Descripción del Proyecto**

Esta API permite a los usuarios gestionar temas de discusión, incluyendo la creación, visualización, edición y eliminación de temas y respuestas. El objetivo principal es proporcionar una base sólida para una aplicación de foro, siguiendo las mejores prácticas de desarrollo y la arquitectura REST.

### **Tecnologías Utilizadas**

  * **Lenguaje de Programación:** Java
  * **Framework:** Spring Boot 3
  * **Base de Datos:** MySQL
  * **Mapeo de Objetos Relacionales (ORM):** Spring Data JPA
  * **Librerías Adicionales:** Lombok (para reducir el código repetitivo)
  * **Control de Versiones:** Git y GitHub

### **Funcionalidades Clave**

  * **Gestión de Temas:**
      * Crear un nuevo tema.
      * Listar todos los temas existentes.
      * Ver detalles de un tema específico.
      * Actualizar un tema existente.
      * Eliminar un tema.
  * **Gestión de Respuestas:**
      * Crear respuestas para los temas.
      * Listar las respuestas de un tema.
      * Actualizar una respuesta.
      * Eliminar una respuesta.
  * **Autenticación y Autorización (Opcional, si está implementado):**
      * Registro e inicio de sesión de usuarios.
      * Protección de endpoints para usuarios autenticados.

### **Instalación y Configuración**

Sigue estos pasos para poner en marcha el proyecto en tu entorno local:

1.  **Clona el repositorio:**

    ```bash
    git clone https://github.com/ProfeCeci/ForONE-Challenge-ALura.git
    ```

2.  **Configura la base de datos:**

      * Asegúrate de tener un servidor MySQL en funcionamiento.
      * Crea una base de datos llamada `foro_db` (o el nombre que prefieras).
      * Abre el archivo `application.properties` (o `application.yml`) en `src/main/resources` y configura las credenciales de tu base de datos:

    <!-- end list -->

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/foro_db
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

3.  **Compila y ejecuta la aplicación:**

      * Navega al directorio del proyecto en tu terminal.
      * Ejecuta el proyecto con Maven:

    <!-- end list -->

    ```bash
    ./mvnw spring-boot:run
    ```

4.  La API estará disponible en `http://localhost:8080`.

### **Uso de la API**

Puedes usar herramientas como **Postman**, **Insomnia** o `cURL` para interactuar con la API. Aquí tienes un ejemplo de un endpoint común:

  * **POST** `/topics` - Crea un nuevo tema.
  * **GET** `/topics` - Obtiene la lista de todos los temas.

### **Créditos**

Este proyecto es parte del programa ONE (Oracle Next Education) de Alura Latam.

[Git y GitHub para Principiantes](https://www.youtube.com/watch?v=-LmFK6skG7s) es un video útil para quienes se están familiarizando con el uso de estas herramientas.
http://googleusercontent.com/youtube_content/0
