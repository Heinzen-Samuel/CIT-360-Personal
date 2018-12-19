-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: scabs_webapp
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `captured`
--

DROP TABLE IF EXISTS `captured`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `captured` (
  `captured_id` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(45) NOT NULL,
  `scab` varchar(45) NOT NULL,
  `captured_str` int(11) NOT NULL,
  `captured_luck` int(11) NOT NULL,
  PRIMARY KEY (`captured_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `captured`
--

LOCK TABLES `captured` WRITE;
/*!40000 ALTER TABLE `captured` DISABLE KEYS */;
INSERT INTO `captured` VALUES (1,'Sam','Rad',90,40),(2,'Sam','Rambi',92,8),(3,'Sam','Rad',60,10),(4,'Sam','Rambi',105,25),(5,'Sam','Rambi',105,25),(6,'Sam','Rambi',105,25),(7,'Sam','Rambi',105,25),(8,'Sam','Rad',90,40),(9,'Sam','Rad',90,40),(10,'Sam','Rambi',92,8),(11,'Sam','Rad',60,10),(12,'Sam','Rambi',92,8),(13,'Sam','Rad',77,23),(14,'Sam','Lonli',25,35),(15,'Sam','Rambi',105,25);
/*!40000 ALTER TABLE `captured` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-19  2:18:36