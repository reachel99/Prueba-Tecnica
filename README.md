** Proyecto API con Java y Spring Boot
Este proyecto consiste en una API desarrollada con Java y Spring Boot, utilizando una base de datos PostgreSQL y pruebas realizadas en Postman.

** Instalación
Clona el repositorio:
git clone (https://github.com/reachel99/Prueba-Tecnica)

** Configura la base de datos PostgreSQL:
Crea una base de datos llamada tecnica.
Configura las credenciales de la base de datos en el archivo application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/mi_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

** Enpoints
Los enpoints manejados para las peticiones JSON son: 

/clientes
/movimientos
/cuentas 
