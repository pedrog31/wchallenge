# Wchallenge
Este proyecto esta construido bajo las siguientes consideraciones:
 - Java 14 (OpenJDK)
 - SpringBoot V2.4.2 como Framework
 - Arquitectura hexagonal (DDD)
 - Capa de persistencia implementada con ayuda de spring-boot-starter-data-mongodb, base de datos desplegada en la nube con la ayuda del producto Mongo DB Cloud
 - Capa de seguridad implementada con ayuda de spring-boot-starter-security

Detalles de la implementacion:

 - Para la autenticacion de los servicios web se construyo el servicio "/au/autenticacion" que recibe en el cuerpo de la petición un correo y contraseña (Por facilidades en la implementacion se definió que la contraseña es el identificador del usuario) este devuelve un token que debe ser enviado en las demás peticiones (Bearer), en Swagger ver botón "Authorize"
 - Para la autorización de los servicios web se manejo un estándar de nombramiento para los endpoints basado en su prefijo así:
	 - "/ops/**": Servicios que pueden ser consumidos por usuarios administrativos (Por facilidades en la implementacion se definió que el único administrador era el usuario con identificador 1).
	 - "/us/**": Servicios que pueden ser consumidos por cualquier usuario autenticado.
	- "/au/**": Servicios que no requieren autorización (para realizar autenticacion). 
- Para los permisos sobre los Álbumes se definieron los siguientes roles:
	- Lector: Tiene acceso a la lectura del álbum.
	- Seguidor: Lector + Acceso para compartir álbumes solo en modo lectura.
	- Gestor: Seguidor + Acceso para modificar permisos.
	- *Los Dueños de los álbumes tienen permisos sobre estos de tipo Gestor.
