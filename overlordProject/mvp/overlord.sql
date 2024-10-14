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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplares`
--

LOCK TABLES `ejemplares` WRITE;
/*!40000 ALTER TABLE `ejemplares` DISABLE KEYS */;
INSERT INTO `ejemplares` VALUES (1,'OVER-1000001',0,1,1),(2,'OVER-1000002',0,2,1),(3,'OVER-1000003',0,1,2),(4,'OVER-1000004',0,1,2),(5,'OVER-1000005',0,1,3),(6,'OVER-1000006',0,1,3),(7,'OVER-1000007',0,1,4),(8,'OVER-1000008',0,1,4),(9,'OVER-1000009',0,1,5),(10,'OVER-1000010',0,1,5),(11,'OVER-2000001',0,2,11),(12,'OVER-2000002',0,2,11),(13,'OVER-2000003',0,2,12),(14,'OVER-2000004',0,2,12),(15,'OVER-2000005',0,2,13),(16,'OVER-2000006',0,2,13),(17,'OVER-2000007',0,2,14),(18,'OVER-2000008',0,2,14),(19,'OVER-2000009',0,2,15),(20,'OVER-2000010',0,2,15),(21,'OVER-3000001',0,3,21),(22,'OVER-3000002',0,3,21),(23,'OVER-3000003',0,3,22),(24,'OVER-3000004',0,3,22),(25,'OVER-3000005',0,3,23),(26,'OVER-3000006',0,3,23),(27,'OVER-3000007',0,3,24),(28,'OVER-3000008',0,3,24),(29,'OVER-4000001',0,4,31),(30,'OVER-4000002',0,4,31),(31,'OVER-4000003',0,4,32),(32,'OVER-4000004',0,4,32),(33,'OVER-4000005',0,4,33),(34,'OVER-4000006',0,4,33),(35,'OVER-4000007',0,4,34),(36,'OVER-4000008',0,4,34),(37,'OVER-5000001',0,5,41),(38,'OVER-5000002',0,5,41),(39,'OVER-5000003',0,5,42),(40,'OVER-5000004',0,5,42),(41,'OVER-5000005',0,5,43),(42,'OVER-5000006',0,5,43),(43,'OVER-5000007',0,5,44),(44,'OVER-5000008',0,5,44),(45,'OVER-5000009',0,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES (1,'Demon\'s Souls','RPG',NULL),(2,'Spider-Man: Miles Morales','Acción',NULL),(3,'Ratchet & Clank: Rift Apart','Acción',NULL),(4,'Returnal','Acción',NULL),(5,'Gran Turismo 7','Carreras',NULL),(6,'Horizon Forbidden West','Aventura',NULL),(7,'Astro\'s Playroom','Plataformas',NULL),(8,'Final Fantasy XVI','RPG',NULL),(9,'Sackboy: A Big Adventure','Plataformas',NULL),(10,'Kena: Bridge of Spirits','Aventura',NULL),(11,'The Last of Us Part II','Acción',NULL),(12,'God of War','Acción',NULL),(13,'Bloodborne','RPG',NULL),(14,'Uncharted 4: A Thief\'s End','Aventura',NULL),(15,'Horizon Zero Dawn','Aventura',NULL),(16,'Ghost of Tsushima','Acción',NULL),(17,'Persona 5','RPG',NULL),(18,'Gran Turismo Sport','Carreras',NULL),(19,'Spider-Man','Acción',NULL),(20,'Red Dead Redemption 2','Aventura',NULL),(21,'The Legend of Zelda: Breath of the Wild','Aventura',NULL),(22,'Super Mario Odyssey','Plataformas',NULL),(23,'Mario Kart 8 Deluxe','Carreras',NULL),(24,'Animal Crossing: New Horizons','Simulación',NULL),(25,'Splatoon 2','Acción',NULL),(26,'Super Smash Bros. Ultimate','Pelea',NULL),(27,'Fire Emblem: Three Houses','Estrategia',NULL),(28,'Pokémon Sword and Shield','RPG',NULL),(29,'Luigi\'s Mansion 3','Aventura',NULL),(30,'Xenoblade Chronicles 2','RPG',NULL),(31,'Halo Infinite','Acción',NULL),(32,'Forza Horizon 5','Carreras',NULL),(33,'Gears 5','Acción',NULL),(34,'Fable','RPG',NULL),(35,'State of Decay 2','Simulación',NULL),(36,'Sea of Thieves','Aventura',NULL),(37,'Ori and the Will of the Wisps','Plataformas',NULL),(38,'Psychonauts 2','Plataformas',NULL),(39,'The Medium','Terror',NULL),(40,'Microsoft Flight Simulator','Simulación',NULL),(41,'Cyberpunk 2077','RPG',NULL),(42,'Valorant','Disparos',NULL),(43,'League of Legends','MOBA',NULL),(44,'Dota 2','MOBA',NULL),(45,'World of Warcraft','RPG',NULL),(46,'The Witcher 3: Wild Hunt','RPG',NULL),(47,'Counter-Strike: Global Offensive','Disparos',NULL),(48,'Among Us','Estrategia',NULL),(49,'Minecraft','Simulación',NULL),(50,'Starcraft II','Estrategia',NULL),(51,'Fortnite','Disparos',NULL),(52,'Apex Legends','Disparos',NULL),(53,'Call of Duty: Warzone','Disparos',NULL),(54,'Assassin\'s Creed Valhalla','Aventura',NULL),(55,'FIFA 23','Deportes',NULL),(56,'Madden NFL 23','Deportes',NULL),(57,'NBA 2K23','Deportes',NULL),(58,'Watch Dogs: Legion','Aventura',NULL),(59,'Rainbow Six Siege','Disparos',NULL),(60,'Far Cry 6','Acción',NULL),(61,'Hades','RPG',NULL),(62,'Celeste','Plataformas',NULL),(63,'Hollow Knight','Aventura',NULL),(64,'Cuphead','Plataformas',NULL),(65,'Stardew Valley','Simulación',NULL),(66,'Dead Cells','Acción',NULL),(67,'The Binding of Isaac','Acción',NULL),(68,'Slay the Spire','Estrategia',NULL),(69,'Undertale','RPG',NULL),(70,'Outer Wilds','Aventura',NULL);
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

-- Dump completed on 2024-10-04 19:11:57
