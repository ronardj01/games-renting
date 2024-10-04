-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: overlord
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquileres` (
  `idalquiler` int NOT NULL AUTO_INCREMENT,
  `fecha_renta` date NOT NULL,
  `fecha_devolucion` date NOT NULL,
  `fecha_retorno` date DEFAULT NULL,
  `id_ejemplar` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`idalquiler`),
  KEY `FK_ALQ_EJ_idx` (`id_ejemplar`),
  KEY `FK_ALQ_USUARIO_idx` (`id_usuario`),
  CONSTRAINT `FK_ALQ_EJ` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplares` (`idejemplar`),
  CONSTRAINT `FK_ALQ_USUARIO` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquileres`
--

LOCK TABLES `alquileres` WRITE;
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consolas`
--

DROP TABLE IF EXISTS `consolas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consolas` (
  `idconsola` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idconsola`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consolas`
--

LOCK TABLES `consolas` WRITE;
/*!40000 ALTER TABLE `consolas` DISABLE KEYS */;
INSERT INTO `consolas` VALUES (1,'Play Station 5'),(2,'Play Station 4'),(3,'Nintendo Switch'),(4,'Xbox Serie X'),(5,'PC');
/*!40000 ALTER TABLE `consolas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplares`
--

DROP TABLE IF EXISTS `ejemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejemplares` (
  `idejemplar` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(12) NOT NULL,
  `rentado` tinyint(1) NOT NULL,
  `id_consola` int NOT NULL,
  `id_juego` int NOT NULL,
  PRIMARY KEY (`idejemplar`),
  KEY `FK_EJ_CON_idx` (`id_consola`),
  KEY `FK_EJ_JUE_idx` (`id_juego`),
  CONSTRAINT `FK_EJ_CON` FOREIGN KEY (`id_consola`) REFERENCES `consolas` (`idconsola`),
  CONSTRAINT `FK_EJ_JUE` FOREIGN KEY (`id_juego`) REFERENCES `juegos` (`idjuego`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplares`
--

LOCK TABLES `ejemplares` WRITE;
/*!40000 ALTER TABLE `ejemplares` DISABLE KEYS */;
INSERT INTO `ejemplares` VALUES (1,'OVER-10001',0,1,1),(2,'OVER-10002',0,1,1),(3,'OVER-10003',0,1,2),(4,'OVER-10004',0,1,2),(5,'OVER-10005',0,1,8),(6,'OVER-10006',0,1,8),(7,'OVER-10007',0,1,9),(8,'OVER-10008',0,1,9),(9,'OVER-10009',0,1,10),(10,'OVER-10010',0,1,10),(11,'OVER-20001',0,2,1),(12,'OVER-20002',0,2,1),(13,'OVER-20003',0,2,1),(14,'OVER-20004',0,2,2),(15,'OVER-20005',0,2,2),(16,'OVER-20006',0,2,2),(17,'OVER-20007',0,2,8),(18,'OVER-20008',0,2,8),(19,'OVER-20009',0,2,8),(20,'OVER-20010',0,2,9),(21,'OVER-20011',0,2,9),(22,'OVER-20012',0,2,9),(23,'OVER-20013',0,2,10),(24,'OVER-20014',0,2,10),(25,'OVER-20015',0,2,10),(26,'OVER-30001',0,3,4),(27,'OVER-30002',0,3,4),(28,'OVER-30003',0,3,5),(29,'OVER-30004',0,3,5),(30,'OVER-30005',0,3,12),(31,'OVER-30006',0,3,12),(32,'OVER-40001',0,4,3),(33,'OVER-40002',0,4,3),(34,'OVER-40003',0,4,3),(35,'OVER-40004',0,4,7),(36,'OVER-40005',0,4,7),(37,'OVER-40006',0,4,7),(38,'OVER-40007',0,4,14),(39,'OVER-40008',0,4,14),(40,'OVER-40009',0,4,14),(41,'OVER-50001',0,5,6),(42,'OVER-50002',0,5,6),(43,'OVER-50003',0,5,6),(44,'OVER-50004',0,5,13),(45,'OVER-50005',0,5,13),(46,'OVER-50006',0,5,13),(47,'OVER-50007',0,5,15),(48,'OVER-50008',0,5,15),(49,'OVER-50009',0,5,15);
/*!40000 ALTER TABLE `ejemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juegos`
--

DROP TABLE IF EXISTS `juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juegos` (
  `idjuego` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) NOT NULL,
  `genero` varchar(15) DEFAULT NULL,
  `estanteria` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`idjuego`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES (1,'The Last of Us Part II','Acción','001-001'),(2,'Spider-Man: Miles Morales','Aventura','001-002'),(3,'Halo Infinite','FPS','001-003'),(4,'Animal Crossing: New Horizons','Simulación','001-004'),(5,'The Legend of Zelda: Breath of the Wild','Aventura','001-005'),(6,'Cyberpunk 2077','RPG','001-006'),(7,'Forza Horizon 5','Carreras','001-007'),(8,'Ghost of Tsushima','Acción','001-008'),(9,'Resident Evil Village','Terror','001-009'),(10,'God of War Ragnarök','Aventura','001-010'),(11,'FIFA 24','Deportes','001-011'),(12,'Super Mario Odyssey','Plataformas','001-012'),(13,'Elden Ring','RPG','001-013'),(14,'Gears 5','Acción','001-014'),(15,'Hades','Roguelike','001-015');
/*!40000 ALTER TABLE `juegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuario` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `direccion` varchar(90) DEFAULT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Francisco','Gonzalez','franciscog@ejemplo.com',NULL,'641524411','12345'),(2,'Alberto','Santos','alberto@ejemplo.com',NULL,'659886622','12345');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-04 19:49:28
