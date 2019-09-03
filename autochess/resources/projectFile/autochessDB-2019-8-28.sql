CREATE DATABASE  IF NOT EXISTS `autochess` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `autochess`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: autochess
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chess`
--

DROP TABLE IF EXISTS `chess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chess` (
  `chess_id` int(11) NOT NULL AUTO_INCREMENT,
  `chess_name` varchar(45) NOT NULL,
  `chess_price` int(11) NOT NULL,
  `chess_level` int(11) NOT NULL,
  `chess_hp` int(11) NOT NULL,
  `chess_attack` int(11) NOT NULL,
  `chess_type` int(11) NOT NULL,
  `chess_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`chess_id`),
  UNIQUE KEY `chess_id_UNIQUE` (`chess_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chess`
--

LOCK TABLES `chess` WRITE;
/*!40000 ALTER TABLE `chess` DISABLE KEYS */;
INSERT INTO `chess` VALUES (1,'bage',3,1,50,65,3,NULL),(2,'banma',3,1,70,75,1,NULL),(3,'baozi',4,1,85,85,1,NULL),(4,'mifeng',3,1,45,55,3,NULL),(5,'bianfu',4,1,65,75,3,NULL),(6,'daxiang',6,1,100,85,1,NULL),(7,'gou',4,1,75,70,1,NULL),(8,'eyu',6,1,100,80,1,NULL),(9,'gezi',4,1,60,55,3,NULL),(10,'haibao',5,1,70,55,2,NULL),(11,'haima',4,1,65,30,2,NULL),(12,'haitun',5,1,75,80,2,NULL),(13,'hema',7,1,95,80,1,NULL),(14,'jingyu',8,1,105,90,2,NULL),(15,'konglong',9,1,110,90,1,NULL),(16,'long',9,1,120,100,3,NULL),(17,'longxia',4,1,60,65,3,NULL),(18,'maotouying',4,1,65,55,3,NULL),(19,'pangxie',5,1,85,55,2,NULL),(20,'zhu',5,1,70,55,1,NULL),(21,'qingting',3,1,35,30,3,NULL),(22,'shanyang',4,1,60,55,1,NULL),(23,'shayu',6,1,80,75,2,NULL),(24,'lang',5,1,70,70,1,NULL),(25,'haigui',6,1,80,55,2,NULL),(26,'yanzi',4,1,45,40,3,NULL),(27,'yingwu',6,1,50,35,3,NULL),(28,'yu',5,1,60,55,2,NULL),(29,'zhangyu',5,1,70,60,2,NULL),(30,'laohu',8,1,100,85,1,NULL),(31,'laoying',6,1,80,75,3,NULL);
/*!40000 ALTER TABLE `chess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `other_user_id` int(11) DEFAULT NULL,
  `winner_id` int(11) DEFAULT NULL,
  `game_status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`game_id`),
  UNIQUE KEY `game_id_UNIQUE` (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (3,1,2,0,0);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_avatar` varchar(100) DEFAULT NULL,
  `user_nickname` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uid_UNIQUE` (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'root','root',NULL,'root'),(2,'test','test',NULL,'test');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-28 20:09:35
