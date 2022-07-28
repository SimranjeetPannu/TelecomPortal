CREATE DATABASE  IF NOT EXISTS `telecomproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `telecomproject`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: telecomproject
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `devices`
--

DROP TABLE IF EXISTS `devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devices` (
  `deviceid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`deviceid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devices`
--

LOCK TABLES `devices` WRITE;
/*!40000 ALTER TABLE `devices` DISABLE KEYS */;
INSERT INTO `devices` VALUES (0,'iPhone 10',199.99),(1,'Google 5',169.99),(2,'iPhone 10',199.99),(3,'Pickle 8080',299.99),(4,'Samsung Note',219.99),(5,'SkillStorm 12x',259.99),(6,'Google 5',169.99),(7,'iPhone 10',199.99),(8,'Pickle 8080',299.99),(9,'Samsung Note',219.99),(10,'SkillStorm 12x',259.99),(11,'Google 5',169.99),(12,'iPhone 10',199.99),(13,'Pickle 8080',299.99),(14,'Samsung Note',219.99),(15,'SkillStorm 12x',259.99),(16,'Google 5',169.99),(17,'iPhone 10',199.99),(18,'Pickle 8080',299.99),(19,'Samsung Note',219.99),(20,'SkillStorm 12x',259.99),(21,'Google 5',169.99),(22,'iPhone 10',199.99),(23,'Pickle 8080',299.99),(24,'Samsung Note',219.99),(25,'SkillStorm 12x',259.99),(26,'Google 5',169.99),(27,'iPhone 10',199.99),(28,'Pickle 8080',299.99),(29,'Samsung Note',219.99),(30,'SkillStorm 12x',259.99);
/*!40000 ALTER TABLE `devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonenumber`
--

DROP TABLE IF EXISTS `phonenumber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonenumber` (
  `phonenumber` bigint NOT NULL,
  `deviceid` int DEFAULT NULL,
  PRIMARY KEY (`phonenumber`),
  UNIQUE KEY `deviceid_UNIQUE` (`deviceid`),
  KEY `phoneid_idx` (`deviceid`),
  CONSTRAINT `phoneid` FOREIGN KEY (`deviceid`) REFERENCES `devices` (`deviceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonenumber`
--

LOCK TABLES `phonenumber` WRITE;
/*!40000 ALTER TABLE `phonenumber` DISABLE KEYS */;
INSERT INTO `phonenumber` VALUES (1078680522,NULL),(1307746508,NULL),(1407528513,NULL),(1603726013,NULL),(1628784895,NULL),(1631847161,NULL),(1757843038,NULL),(2592078485,NULL),(2704440170,NULL),(3188681447,NULL),(3705881840,NULL),(3913948881,NULL),(4294571825,NULL),(4399289220,NULL),(4797880469,NULL),(4909454772,NULL),(5157213005,NULL),(5223843584,NULL),(5675567199,NULL),(5909040469,NULL),(5965727686,NULL),(6155617539,NULL),(6298051217,NULL),(6311199854,NULL),(6988092179,NULL),(7487823004,NULL),(7487934632,NULL),(7744502646,NULL),(7874036093,NULL),(7956753386,NULL),(8114868849,NULL),(8224699345,NULL),(8318836367,NULL),(8601062124,NULL),(8651972617,NULL),(8708604853,NULL),(8859170697,NULL),(8958435085,NULL),(8961312981,NULL),(9115338702,NULL),(9479822640,NULL),(9563607363,NULL),(9618883863,NULL),(9762864152,NULL),(9995682192,NULL),(2873133420,1),(4201735107,2),(4803296064,3),(5372992390,4),(5946722350,5),(6395251044,6),(5864668705,7),(5112367911,8),(4528978165,9),(4116032694,10),(2935776050,11),(2029327702,12),(5987257636,13),(7259432282,14),(7568284509,15);
/*!40000 ALTER TABLE `phonenumber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phoneplan`
--

DROP TABLE IF EXISTS `phoneplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phoneplan` (
  `planid` int NOT NULL,
  `planname` varchar(45) DEFAULT NULL,
  `plancost` double DEFAULT NULL,
  `devicelimit` int DEFAULT NULL,
  PRIMARY KEY (`planid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phoneplan`
--

LOCK TABLES `phoneplan` WRITE;
/*!40000 ALTER TABLE `phoneplan` DISABLE KEYS */;
INSERT INTO `phoneplan` VALUES (1,'Solo',14.18,1),(2,'Dos Pickles',22.56,2),(3,'Treyarch',30.52,3),(4,'Zulmak',38.44,4),(5,'Five in the Sky',44.64,5),(6,'Loose Coupling',50.74,6),(7,'Cloudy Heaven',57.41,7),(8,'The Ocho',63.42,8),(9,'K8s Plus One',70.12,9),(10,'Lucky',77.77,10);
/*!40000 ALTER TABLE `phoneplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccounts`
--

DROP TABLE IF EXISTS `useraccounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useraccounts` (
  `username` varchar(50) NOT NULL,
  `customerId` int DEFAULT NULL,
  `monthlyBill` decimal(8,2) DEFAULT NULL,
  `phonePlan1` varchar(45) DEFAULT NULL,
  `phonePlan1cost` double DEFAULT NULL,
  `phonePlan2` varchar(45) DEFAULT NULL,
  `phonePlan2cost` double DEFAULT NULL,
  `phonePlan3` varchar(45) DEFAULT NULL,
  `phonePlan3cost` double DEFAULT NULL,
  `phonePlan4` varchar(45) DEFAULT NULL,
  `phonePlan4cost` double DEFAULT NULL,
  `phonePlan5` varchar(45) DEFAULT NULL,
  `phonePlan5cost` double DEFAULT NULL,
  `device1` varchar(45) DEFAULT NULL,
  `device1cost` double DEFAULT NULL,
  `device2` varchar(45) DEFAULT NULL,
  `device2cost` double DEFAULT NULL,
  `device3` varchar(45) DEFAULT NULL,
  `device3cost` double DEFAULT NULL,
  `device4` varchar(45) DEFAULT NULL,
  `device4cost` double DEFAULT NULL,
  `device5` varchar(45) DEFAULT NULL,
  `device5cost` double DEFAULT NULL,
  `device6` varchar(45) DEFAULT NULL,
  `device6cost` double DEFAULT NULL,
  `device7` varchar(45) DEFAULT NULL,
  `device7cost` double DEFAULT NULL,
  `device8` varchar(45) DEFAULT NULL,
  `device8cost` double DEFAULT NULL,
  `device9` varchar(45) DEFAULT NULL,
  `device9cost` double DEFAULT NULL,
  `device10` varchar(45) DEFAULT NULL,
  `device10cost` double DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  CONSTRAINT `customerid` FOREIGN KEY (`customerId`) REFERENCES `users` (`customerId`),
  CONSTRAINT `user` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccounts`
--

LOCK TABLES `useraccounts` WRITE;
/*!40000 ALTER TABLE `useraccounts` DISABLE KEYS */;
INSERT INTO `useraccounts` VALUES ('BondJames',7,63.32,'Loose Coupling Plan',28.32,NULL,0,NULL,0,NULL,0,NULL,0,'iPhone 10',199.99,'Samsung Note',219.99,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0),('dpickles1',13,79.67,'Pickles Plan',38.68,'Zulmak Plan',15.99,NULL,0,NULL,0,NULL,0,'Pickle 8080',299.99,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0),('Fast1',199,40.99,'Zulmak Plan',15.99,NULL,0,NULL,0,NULL,0,NULL,0,'Pickle 8080',299.99,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0),('Goat23',23,232.82,'Bean Plan',69.99,'Boot Plan',49.99,'Pickles Plan',38.68,NULL,0,NULL,0,'Google 5',169.99,'iPhone 10',199.99,'Samsung Note',219.99,'Pickle 8080',299.99,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0),('saltysally',31,174.14,'Bean Plan',69.99,'Boot Plan',49.99,NULL,0,NULL,0,NULL,0,'Skillstorm 12x',259.99,'Google 5',169.99,'Samsung Note',219.99,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0),('sparklergrl',22,96.18,'Pickles Plan',38.68,NULL,0,NULL,0,NULL,0,NULL,0,'Pickle 8080',299.99,'Google 5',169.99,'Samsung Note',219.99,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0,NULL,0);
/*!40000 ALTER TABLE `useraccounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `Username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (7,'James','Bond','BondJames','Bond007'),(13,'Dan','Pickles','dpickles1','pickleman'),(22,'Meghan','Sparkles','sparklergrl','meg123'),(23,'Michael','Jordan','Goat23','Iamthegreatest'),(31,'Sally','Struthers','saltysally','struth1'),(199,'Ricky','Bobby','Fast1','Iliketogofast!');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-27 22:50:42
