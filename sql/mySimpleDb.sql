-- MySQL Script generated by MySQL Workbench
-- Mon Jun 10 00:12:21 2019
-- Model: New Model    Version: 1.0
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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`catalogue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`catalogue` (
                                                  `id` INT NOT NULL,
                                                  `index` VARCHAR(45) NOT NULL,
                                                  `title` VARCHAR(45) NOT NULL,
                                                  `cover` VARCHAR(45) NULL,
                                                  `language` JSON NOT NULL,
                                                  `publishers_id` INT NOT NULL,
                                                  PRIMARY KEY (`id`),
                                                  INDEX `fk_catalogue_publishers_idx` (`publishers_id` ASC) ,
                                                  UNIQUE INDEX `index_UNIQUE` (`index` ASC) ,
                                                  CONSTRAINT `fk_catalogue_publishers`
                                                      FOREIGN KEY (`publishers_id`)
                                                          REFERENCES `mydb`.`publishers` (`id`)
                                                          ON DELETE NO ACTION
                                                          ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
                                               `id` INT NOT NULL,
                                               `date` DATETIME NOT NULL,
                                               `users_id` INT NOT NULL,
                                               `catalogue_id` INT NOT NULL,
                                               `is_executed` TINYINT NOT NULL,
                                               `sum` INT NOT NULL,
                                               `period` INT NOT NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `fk_orders_users1_idx` (`users_id` ASC) ,
                                               INDEX `fk_orders_catalogue1_idx` (`catalogue_id` ASC) ,
                                               CONSTRAINT `fk_orders_users1`
                                                   FOREIGN KEY (`users_id`)
                                                       REFERENCES `mydb`.`users` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `fk_orders_catalogue1`
                                                   FOREIGN KEY (`catalogue_id`)
                                                       REFERENCES `mydb`.`catalogue` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`publishers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`publishers` (
                                                   `id` INT NOT NULL,
                                                   `name` VARCHAR(45) NOT NULL,
                                                   `country` VARCHAR(45) NOT NULL,
                                                   PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`users` (
                                              `id` INT NOT NULL,
                                              `name` VARCHAR(45) NOT NULL,
                                              `password_hash` VARCHAR(45) NOT NULL,
                                              `roles` JSON NOT NULL,
                                              `phone` VARCHAR(20) NOT NULL,
                                              `email` VARCHAR(45) NULL,
                                              `language` JSON NOT NULL,
                                              PRIMARY KEY (`id`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
