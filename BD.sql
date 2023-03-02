CREATE DATABASE quickmarket;
USE quickmarket;

  CREATE TABLE `quickmarket`.`roles` (
  `idroles` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`idroles`));

  
INSERT INTO `quickmarket`.`roles` (`nombres`) VALUES ('Administrador');
INSERT INTO `quickmarket`.`roles` (`nombres`) VALUES ('Cajero');

CREATE UNIQUE INDEX roles_pk ON `roles` (`idroles`);

CREATE TABLE `quickmarket`.`usuarios`(
  `idusuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idroles` INT UNSIGNED NOT NULL,
  `usuario` VARCHAR(25) NOT NULL,
  `contrasenia` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT FK_USUARIOS_TIENE_ROLES FOREIGN KEY (`idroles`) REFERENCES `roles` (`idroles`)
);

CREATE UNIQUE INDEX USUARIOS_PK ON USUARIOS (`idusuario`);

CREATE INDEX TIENE_FK ON USUARIOS (`idroles`);

INSERT INTO `quickmarket`.`usuarios` (`idroles`, `usuario`, `contrasenia`) VALUES ('1', 'dannyV', '1234');
INSERT INTO `quickmarket`.`usuarios` (`idroles`, `usuario`, `contrasenia`) VALUES ('2', 'danielQ', '1111');
INSERT INTO `quickmarket`.`usuarios` (`idroles`, `usuario`, `contrasenia`) VALUES ('1', 'nestorC', '1211');
INSERT INTO `quickmarket`.`usuarios` (`idroles`, `usuario`, `contrasenia`) VALUES ('2', 'joseP', '1122');

DELETE FROM `quickmarket`.`usuarios` WHERE (`idusuario` = '1');
SELECT * FROM ROLES;
SELECT * FROM USUARIOS;
