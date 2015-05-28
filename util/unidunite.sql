-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema unidunite
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `unidunite` ;

-- -----------------------------------------------------
-- Schema unidunite
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `unidunite` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `unidunite` ;

-- -----------------------------------------------------
-- Table `unidunite`.`competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unidunite`.`competencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` CHAR(6) NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unidunite`.`projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unidunite`.`projeto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `dt_inicio` DATETIME NOT NULL,
  `dt_fim` DATETIME NOT NULL,
  `aberto` TINYINT(1) NOT NULL,
  `descricao` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unidunite`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unidunite`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_projeto` INT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cargo` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_funcionario_projeto1_idx` (`id_projeto` ASC),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  CONSTRAINT `fk_funcionario_projeto1`
    FOREIGN KEY (`id_projeto`)
    REFERENCES `unidunite`.`projeto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `unidunite`.`funcionario_has_competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `unidunite`.`funcionario_has_competencia` (
  `id_funcionario` INT NOT NULL,
  `id_competencia` INT NOT NULL,
  PRIMARY KEY (`id_funcionario`, `id_competencia`),
  INDEX `fk_funcionario_has_competencia_competencia1_idx` (`id_competencia` ASC),
  INDEX `fk_funcionario_has_competencia_funcionario_idx` (`id_funcionario` ASC),
  CONSTRAINT `fk_funcionario_has_competencia_funcionario`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `unidunite`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_has_competencia_competencia1`
    FOREIGN KEY (`id_competencia`)
    REFERENCES `unidunite`.`competencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
