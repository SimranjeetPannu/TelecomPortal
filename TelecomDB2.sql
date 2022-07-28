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
  `customerid` int DEFAULT NULL,
  PRIMARY KEY (`deviceid`),
  KEY `cid_idx` (`customerid`),
  CONSTRAINT `cid` FOREIGN KEY (`customerid`) REFERENCES `useraccounts` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devices`
--

LOCK TABLES `devices` WRITE;
/*!40000 ALTER TABLE `devices` DISABLE KEYS */;
INSERT INTO `devices` VALUES (0,'iPhone 10',199.99,NULL),(1,'Google 5',169.99,31),(2,'iPhone 10',199.99,7),(3,'Pickle 8080',299.99,13),(4,'Samsung Note',219.99,7),(5,'SkillStorm 12x',259.99,31),(6,'Google 5',169.99,23),(7,'iPhone 10',199.99,23),(8,'Pickle 8080',299.99,199),(9,'Samsung Note',219.99,23),(10,'SkillStorm 12x',259.99,NULL),(11,'Google 5',169.99,NULL),(12,'iPhone 10',199.99,NULL),(13,'Pickle 8080',299.99,23),(14,'Samsung Note',219.99,31),(15,'SkillStorm 12x',259.99,NULL),(16,'Google 5',169.99,22),(17,'iPhone 10',199.99,NULL),(18,'Pickle 8080',299.99,22),(19,'Samsung Note',219.99,22),(20,'SkillStorm 12x',259.99,NULL),(21,'Google 5',169.99,NULL),(22,'iPhone 10',199.99,NULL),(23,'Pickle 8080',299.99,NULL),(24,'Samsung Note',219.99,NULL),(25,'SkillStorm 12x',259.99,NULL),(26,'Google 5',169.99,NULL),(27,'iPhone 10',199.99,NULL),(28,'Pickle 8080',299.99,NULL),(29,'Samsung Note',219.99,NULL),(30,'SkillStorm 12x',259.99,NULL);
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
INSERT INTO `phonenumber` VALUES (1078680522,NULL),(1307746508,NULL),(1407528513,NULL),(1603726013,NULL),(1628784895,NULL),(1631847161,NULL),(1757843038,NULL),(2592078485,NULL),(2704440170,NULL),(3188681447,NULL),(3705881840,NULL),(3913948881,NULL),(4294571825,NULL),(4399289220,NULL),(4797880469,NULL),(4909454772,NULL),(5157213005,NULL),(5223843584,NULL),(5909040469,NULL),(5965727686,NULL),(6155617539,NULL),(6298051217,NULL),(6311199854,NULL),(7487823004,NULL),(7487934632,NULL),(7744502646,NULL),(7874036093,NULL),(7956753386,NULL),(8114868849,NULL),(8224699345,NULL),(8318836367,NULL),(8601062124,NULL),(8651972617,NULL),(8708604853,NULL),(8859170697,NULL),(8958435085,NULL),(8961312981,NULL),(9115338702,NULL),(9479822640,NULL),(9563607363,NULL),(9762864152,NULL),(9995682192,NULL),(2873133420,1),(4201735107,2),(4803296064,3),(5372992390,4),(5946722350,5),(6395251044,6),(5864668705,7),(5112367911,8),(4528978165,9),(4116032694,10),(2935776050,11),(2029327702,12),(5987257636,13),(7259432282,14),(7568284509,15),(6988092179,16),(9618883863,18),(5675567199,19);
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
INSERT INTO `phoneplan` VALUES (1,'Single Plan',14.18,1),(2,'Couples Plan',22.56,2),(3,'Spring Plan',30.52,3),(4,'Fall Plan',38.44,4),(5,'Bean Plan',44.64,5),(6,'Loose Coupling',50.74,6);
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
  `customerId` int NOT NULL,
  `monthlyBill` decimal(8,2) GENERATED ALWAYS AS (concat(((((((((((((((`phonePlan1cost` + `phonePlan2cost`) + `phonePlan3cost`) + `phonePlan4cost`) + `phonePlan5cost`) + (`device1cost` / 12)) + (`device2cost` / 12)) + (`device3cost` / 12)) + (`device4cost` / 12)) + (`device5cost` / 12)) + (`device6cost` / 12)) + (`device7cost` / 12)) + (`device8cost` / 12)) + (`device9cost` / 12)) + (`device10cost` / 12)))) STORED,
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
  `device1id` int DEFAULT NULL,
  `device1number` bigint DEFAULT NULL,
  `device2` varchar(45) DEFAULT NULL,
  `device2cost` double DEFAULT NULL,
  `device2id` int DEFAULT NULL,
  `device2number` bigint DEFAULT NULL,
  `device3` varchar(45) DEFAULT NULL,
  `device3cost` double DEFAULT NULL,
  `device3id` int DEFAULT NULL,
  `device3number` bigint DEFAULT NULL,
  `device4` varchar(45) DEFAULT NULL,
  `device4cost` double DEFAULT NULL,
  `device4id` int DEFAULT NULL,
  `device4number` bigint DEFAULT NULL,
  `device5` varchar(45) DEFAULT NULL,
  `device5cost` double DEFAULT NULL,
  `device5id` int DEFAULT NULL,
  `device5number` bigint DEFAULT NULL,
  `device6` varchar(45) DEFAULT NULL,
  `device6cost` double DEFAULT NULL,
  `device6id` int DEFAULT NULL,
  `device6number` bigint DEFAULT NULL,
  `device7` varchar(45) DEFAULT NULL,
  `device7cost` double DEFAULT NULL,
  `device7id` int DEFAULT NULL,
  `device7number` bigint DEFAULT NULL,
  `device8` varchar(45) DEFAULT NULL,
  `device8cost` double DEFAULT NULL,
  `device8id` int DEFAULT NULL,
  `device8number` bigint DEFAULT NULL,
  `device9` varchar(45) DEFAULT NULL,
  `device9cost` double DEFAULT NULL,
  `device9id` int DEFAULT NULL,
  `device9number` bigint DEFAULT NULL,
  `device10` varchar(45) DEFAULT NULL,
  `device10cost` double DEFAULT NULL,
  `device10id` int DEFAULT NULL,
  `device10number` bigint DEFAULT NULL,
  PRIMARY KEY (`username`,`customerId`),
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
INSERT INTO `useraccounts` (`username`, `customerId`, `phonePlan1`, `phonePlan1cost`, `phonePlan2`, `phonePlan2cost`, `phonePlan3`, `phonePlan3cost`, `phonePlan4`, `phonePlan4cost`, `phonePlan5`, `phonePlan5cost`, `device1`, `device1cost`, `device1id`, `device1number`, `device2`, `device2cost`, `device2id`, `device2number`, `device3`, `device3cost`, `device3id`, `device3number`, `device4`, `device4cost`, `device4id`, `device4number`, `device5`, `device5cost`, `device5id`, `device5number`, `device6`, `device6cost`, `device6id`, `device6number`, `device7`, `device7cost`, `device7id`, `device7number`, `device8`, `device8cost`, `device8id`, `device8number`, `device9`, `device9cost`, `device9id`, `device9number`, `device10`, `device10cost`, `device10id`, `device10number`) VALUES ('BondJames',7,'Couples Plan',22.56,NULL,0,NULL,0,NULL,0,NULL,0,'iPhone 10',199.99,2,5864668705,'Samsung Note',219.99,4,5372992390,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL),('dpickles1',13,'Fall Plan',38.54,'Single Plan',14.18,NULL,0,NULL,0,NULL,0,'Pickle 8080',299.99,3,4803296064,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL),('Fast1',199,'Spring Plan',30.52,NULL,0,NULL,0,NULL,0,NULL,0,'Pickle 8080',299.99,8,5112367911,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL),('Goat23',23,'Couples Plan',22.56,'Spring Plan',30.52,'Single Plan',14.18,NULL,0,NULL,0,'Google 5',169.99,6,6395251044,'iPhone 10',199.99,7,5864668705,'Samsung Note',219.99,9,4528978165,'Pickle 8080',299.99,13,5987257636,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL),('saltysally',31,'Loose Coupling',50.74,'Couples Plan',22.56,NULL,0,NULL,0,NULL,0,'Skillstorm 12x',259.99,5,5946722350,'Google 5',169.99,1,2873133420,'Samsung Note',219.99,14,7259432282,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL),('sparklergrl',22,'Bean Plan',44.64,NULL,0,NULL,0,NULL,0,NULL,0,'Pickle 8080',299.99,18,9618883863,'Google 5',169.99,16,6988092179,'Samsung Note',219.99,19,5675567199,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL);
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
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
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

-- Dump completed on 2022-07-28 15:42:48
