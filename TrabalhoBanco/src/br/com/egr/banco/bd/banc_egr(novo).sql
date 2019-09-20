-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema banco_egr
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema banco_egr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco_egr` DEFAULT CHARACTER SET latin1 ;
USE `banco_egr` ;

-- -----------------------------------------------------
-- Table `banco_egr`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_egr`.`cliente` (
  `idcliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `endereco` VARCHAR(60) NOT NULL,
  `telefone` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `banco_egr`.`conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_egr`.`conta` (
  `numero` BIGINT(20) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `situacao` TINYINT(1) NOT NULL,
  `tipo` VARCHAR(50) NULL DEFAULT NULL,
  `cliente_idcliente` INT(11) NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_conta_cliente1_idx` (`cliente_idcliente` ASC),
  CONSTRAINT `fk_conta_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `banco_egr`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `banco_egr`.`pessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_egr`.`pessoaFisica` (
  `cpf` VARCHAR(20) NOT NULL,
  `idcliente` INT(11) NOT NULL,
  `nomeMae` VARCHAR(60) NULL DEFAULT NULL,
  `nomePai` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  INDEX `idcliente` (`idcliente` ASC),
  CONSTRAINT `pessoaFisica_ibfk_1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `banco_egr`.`cliente` (`idcliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `banco_egr`.`pessoaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_egr`.`pessoaJuridica` (
  `cnpj` VARCHAR(40) NOT NULL,
  `idcliente` INT(11) NOT NULL,
  `nomeFantasia` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`cnpj`),
  INDEX `idcliente` (`idcliente` ASC),
  CONSTRAINT `pessoaJuridica_ibfk_1`
    FOREIGN KEY (`idcliente`)
    REFERENCES `banco_egr`.`cliente` (`idcliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `banco_egr`.`seguro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_egr`.`seguro` (
  `numero` INT(11) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `situacao` TINYINT(1) NOT NULL,
  `cliente_idcliente` INT(11) NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_seguro_cliente1_idx` (`cliente_idcliente` ASC),
  CONSTRAINT `fk_seguro_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `banco_egr`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
