-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: CarRepairShop
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Janek','Kowal-ski','1989-12-30','j.ki@wp.pl'),(14,'Franciszek','Nowakowski','1987-12-12','franek@wp.pl'),(15,'Zdzislaw','Frankowski','1956-05-25','zdzichu18@wp.pl'),(16,'Anna','Kaszuba','1990-09-08','anna.m.kaszuba@gmail.com'),(17,'Jan','Nowakowski','1980-01-01','jan.nowakowski@wp.pl');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `costOfWorkHour` double(4,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Franek','Dolasss','ul.Blotna 5, 32-800 Szczeb','123 123 12333','super',50.00),(2,'Dawid ','Kaszuba','ul.Biesiadna, 5','723 491 083','super elegancko',40.00),(4,'Władek','Kaszuba','ul.Biesiadna, 5','723491083','super',50.00),(14,'Mariusz','Czekaj','adres','582369741','brak uwag',60.00);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateOfAcceptanceForRepair` date DEFAULT NULL,
  `plannedRepairDate` date DEFAULT NULL,
  `startedDateOfRepair` date DEFAULT NULL,
  `idOfEmployee` int(11) DEFAULT NULL,
  `descriptionOfProblem` varchar(250) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `idOfVehicle` int(11) DEFAULT NULL,
  `costOfWork` double(5,2) DEFAULT NULL,
  `costOfAutoParts` double(6,2) DEFAULT NULL,
  `costOfWorkHour` double(4,2) DEFAULT NULL,
  `quantityOfWorkHour` int(11) DEFAULT NULL,
  `idOfCustomer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idOfEmployee` (`idOfEmployee`),
  KEY `idOfVehicle` (`idOfVehicle`),
  KEY `idOfCustomer` (`idOfCustomer`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`idOfEmployee`) REFERENCES `employees` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`idOfVehicle`) REFERENCES `vehicles` (`id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`idOfCustomer`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (30,'2018-01-01','2018-01-01','2018-01-01',1,'naprawa hamulca ręcznego','przyjety',1,350.00,200.00,40.00,2,1),(31,'2019-01-02','2019-01-02','2019-02-03',4,'wymiana oleju oraz filtrów oleju i paliwa','w naprawie',10,500.00,300.00,50.00,1,15),(32,'2019-01-01','2019-01-01','2019-01-01',4,'naprawa hamulca ręcznego','zatwierdzone koszty naprawy',11,375.00,200.00,50.00,2,16),(33,'2019-01-01','2019-01-01','2019-01-02',1,'yyyyyyyyyyyy','zatwierdzone koszty naprawy',12,375.00,200.00,50.00,2,17),(34,'2019-02-01','2019-02-02','2020-01-02',2,'yyyyyyyyyyyyeeeeeeeeeeeee','zatwierdzone koszty naprawy',12,466.67,300.00,40.00,3,17);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'przyjety'),(2,'zatwierdzone koszty naprawy'),(3,'w naprawie'),(4,'gotowy do odbioru'),(5,'rezygnacja');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(15) DEFAULT NULL,
  `brand` varchar(15) DEFAULT NULL,
  `yearOfProduction` int(11) DEFAULT NULL,
  `registrationNumber` varchar(15) DEFAULT NULL,
  `nextTechnicalReview` date DEFAULT NULL,
  `idOfOwner` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idOfOwner` (`idOfOwner`),
  CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`idOfOwner`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,'Lagunaaaa','Reno',2001,'KCH 2222','2020-07-23',1),(8,'Clio','Renault',2008,'KCH 12345','2019-09-19',1),(9,'Talizman ','Renault',2017,'KCH 8756','2019-12-12',14),(10,'Polo','WolksVagen',2016,'KRA 5236','2019-06-25',15),(11,'Talizman','Renault',2019,'KCH AD2012','2020-01-01',16),(12,'Mondeo','Ford',2000,'KRA 2589','2019-02-02',17),(14,'Fusion','Ford',2015,'KCH 2223','2020-02-02',16);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-16 23:06:37
