-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tienda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tienda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tienda` DEFAULT CHARACTER SET utf8 ;
USE `tienda` ;

-- -----------------------------------------------------
-- Table `tienda`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(19,2) NOT NULL,
  `foto` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` CHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `usuarios_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nif_UNIQUE` (`dni` ASC) VISIBLE,
  INDEX `fk_clientes_usuarios1_idx` (`usuarios_id` ASC) VISIBLE,
  UNIQUE INDEX `usuarios_id_UNIQUE` (`usuarios_id` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `tienda`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`facturas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` CHAR(8) NOT NULL,
  `fecha` DATE NOT NULL,
  `clientes_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) VISIBLE,
  INDEX `fk_facturas_clientes_idx` (`clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_clientes`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `tienda`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`facturas_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`facturas_has_productos` (
  `facturas_id` INT NOT NULL,
  `productos_id` INT NOT NULL,
  `cantidad` INT NOT NULL,
  INDEX `fk_facturas_has_productos_productos1_idx` (`productos_id` ASC) VISIBLE,
  INDEX `fk_facturas_has_productos_facturas1_idx` (`facturas_id` ASC) VISIBLE,
  PRIMARY KEY (`productos_id`, `facturas_id`),
  CONSTRAINT `fk_facturas_has_productos_facturas1`
    FOREIGN KEY (`facturas_id`)
    REFERENCES `tienda`.`facturas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_has_productos_productos1`
    FOREIGN KEY (`productos_id`)
    REFERENCES `tienda`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`empleados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `jefe_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_empleados_empleados1_idx` (`jefe_id` ASC) VISIBLE,
  CONSTRAINT `fk_empleados_empleados1`
    FOREIGN KEY (`jefe_id`)
    REFERENCES `tienda`.`empleados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`hoteles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`hoteles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tienda`.`habitaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tienda`.`habitaciones` (
  `numero` CHAR(3) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `hoteles_id` INT NOT NULL,
  PRIMARY KEY (`numero`, `hoteles_id`),
  INDEX `fk_habitaciones_hoteles1_idx` (`hoteles_id` ASC) VISIBLE,
  CONSTRAINT `fk_habitaciones_hoteles1`
    FOREIGN KEY (`hoteles_id`)
    REFERENCES `tienda`.`hoteles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
