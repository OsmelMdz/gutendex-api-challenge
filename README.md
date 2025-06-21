# Curso Java: Trabajar con lambdas, streams y Spring Framework

Este repositorio contiene el proyecto **Gutendex API Challenge**, desarrollado como parte del curso **"Java: Trabajar con lambdas, streams y Spring Framework"** impartido por **Génesys Rondón** a través de **Alura Latam**.

Durante este proyecto, puse en práctica técnicas para consumir APIs públicas, manipular colecciones de datos con Java Streams, aplicar estadísticas y realizar filtros avanzados utilizando programación funcional con expresiones lambda.

## Descripción
Este proyecto es una aplicación de consola que interactúa con la API pública de **Gutendex**, un índice de libros gratuitos del Proyecto Gutenberg. Entre las funcionalidades desarrolladas se encuentran:

- Consumo de API REST: Realización de solicitudes HTTP para obtener libros disponibles.
- Búsqueda personalizada: Filtrado de libros por título o por rango de fechas de nacimiento de autores.
- Ranking: Visualización del Top 10 de libros más descargados.
- Estadísticas: Cálculo de valores como promedio, máximo y mínimo de descargas usando `DoubleSummaryStatistics`.
- Funciones lambda y Streams: Uso de expresiones lambda para ordenar, filtrar, transformar y agrupar datos eficientemente.
- Manejo de entrada del usuario: Interacción en consola mediante menú y entrada de datos con `Scanner`.

## Tecnologías utilizadas
- **Java**: Lenguaje de programación principal utilizado.
- **JDK 17.0.6**: Versión del Java Development Kit empleada.
- **IntelliJ IDEA**: IDE utilizado para el desarrollo.
- **Spring Framework (CLI)**: Utilizado para estructurar el proyecto en un contexto real.
- **Jackson**: Biblioteca utilizada para deserializar datos JSON.
- **Gutendex API**: Fuente de datos basada en el catálogo del Proyecto Gutenberg.

## Requisitos
- Tener instalado [Java JDK 17.0.6](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
- IntelliJ IDEA u otro IDE compatible con Java.
- Conexión a internet para consumir la API de Gutendex en https://gutendex.com.

## Cómo ejecutar el proyecto
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto con IntelliJ IDEA.
3. Asegúrate de tener añadida la biblioteca Jackson al classpath.
4. Ejecuta la clase `Principal.java` ubicada en el paquete `com.aluracursos.desafio.principal`.
5. Sigue las instrucciones que aparecen en consola para realizar búsquedas y consultar información.

## Lo aprendido en este curso
- Aplicación de Streams y expresiones lambda para manipular datos.
- Consumo de APIs REST públicas con Java.
- Deserialización de estructuras JSON complejas a objetos Java.
- Implementación de operaciones estadísticas sobre colecciones.
- Diseño de aplicaciones de consola interactivas y dinámicas.

## Instructor
**Génesys Rondón**  
Ingeniera de Sistemas, especializada en desarrollo web Back End.  
Con experiencia en Java, C#, C++, JavaScript, Node.js, Spring y ASP.NET Core.  
Amante de los gatos, los videojuegos y la literatura clásica.  
LinkedIn: https://www.linkedin.com/in/genesysrondon914762182/  
GitHub: https://github.com/genesysrm
