SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema workdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workdb` DEFAULT CHARACTER SET utf8 ;
USE `workdb` ;

-- -----------------------------------------------------
-- Table `workdb`.`catalogue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workdb`.`catalogue` (
                                                    `id` INT NOT NULL AUTO_INCREMENT,
                                                    `index` VARCHAR(45) NOT NULL,
                                                    `title` VARCHAR(45) NOT NULL,
                                                    `cover` VARCHAR(45) NULL,
                                                    `language` VARCHAR(15) NOT NULL,
                                                    `publishers_id` INT NOT NULL,
                                                    PRIMARY KEY (`id`),
                                                    INDEX `fk_catalogue_publishers_idx` (`publishers_id` ASC) ,
                                                    UNIQUE INDEX `index_UNIQUE` (`index` ASC) ,
                                                    CONSTRAINT `fk_catalogue_publishers`
                                                        FOREIGN KEY (`publishers_id`)
                                                            REFERENCES `workdb`.`publishers` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workdb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workdb`.`orders` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `date` VARCHAR(100) NOT NULL,
                                                 `users_id` INT NOT NULL,
                                                 `catalogue_id` INT NOT NULL,
                                                 `is_executed` TINYINT NOT NULL,
                                                 `sum` VARCHAR(100) NOT NULL,
                                                 `period` VARCHAR(100) NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 INDEX `fk_orders_users1_idx` (`users_id` ASC) ,
                                                 INDEX `fk_orders_catalogue1_idx` (`catalogue_id` ASC) ,
                                                 CONSTRAINT `fk_orders_users1`
                                                     FOREIGN KEY (`users_id`)
                                                         REFERENCES `workdb`.`users` (`id`)
                                                         ON DELETE NO ACTION
                                                         ON UPDATE NO ACTION,
                                                 CONSTRAINT `fk_orders_catalogue1`
                                                     FOREIGN KEY (`catalogue_id`)
                                                         REFERENCES `workdb`.`catalogue` (`id`)
                                                         ON DELETE NO ACTION
                                                         ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workdb`.`publishers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workdb`.`publishers` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NOT NULL,
                                                     `country` VARCHAR(45) NOT NULL,
                                                     `description` TEXT NULL,
                                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workdb`.`users` (
                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                `name` VARCHAR(45) NOT NULL,
                                                `pass` VARCHAR(100) NOT NULL,
                                                `roles` VARCHAR(30) NOT NULL,
                                                `phone` VARCHAR(20) NOT NULL,
                                                `email` VARCHAR(45) NULL,
                                                `language` VARCHAR(15) NOT NULL,
                                                PRIMARY KEY (`id`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;