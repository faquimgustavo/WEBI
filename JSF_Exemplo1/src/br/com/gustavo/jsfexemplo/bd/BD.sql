
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema JSF_Exemplo1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema JSF_Exemplo1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JSF_Exemplo1` DEFAULT CHARACTER SET utf8 ;
USE `JSF_Exemplo1` ;

-- -----------------------------------------------------
-- Table `JSF_Exemplo1`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JSF_Exemplo1`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `estado` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JSF_Exemplo1`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `JSF_Exemplo1`.`estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(80) NOT NULL,
  `idade` INT NOT NULL,
  `idCidade` INT NOT NULL,
  PRIMARY KEY (`id`, `idCidade`),
  INDEX `fk_estado_cidade_idx` (`idCidade` ASC),
  CONSTRAINT `fk_estado_cidade`
    FOREIGN KEY (`idCidade`)
    REFERENCES `JSF_Exemplo1`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
