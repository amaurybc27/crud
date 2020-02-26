# crud
 
Proyecto crud para prueba solicitada en entrevista
--proyecto spring boot, se debe ejecutar como spring boot app, utiliza thymelife, bd mysql, data jpa

BD mysql
--se creo base de datos local para la prueba, los datos estan en el application.properties, el script de la tabla es:

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

--inserta, actualiza, elimina y lista los registros de la tabla user de la base de datos
