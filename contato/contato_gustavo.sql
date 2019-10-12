-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contato_gustavo` DEFAULT CHARACTER SET utf8 ;
USE `contato_gustavo` ;

-- -----------------------------------------------------
-- Table `mydb`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contato_gustavo`.`contato` (
  `idcontato` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone1` VARCHAR(20) NOT NULL,
  `telefone2` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `dataNascimento` INT NOT NULL,
  `profissao` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `estadoCivil` VARCHAR(45) NOT NULL,
  `escolaridade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcontato`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
