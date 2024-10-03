CREATE DATABASE  IF NOT EXISTS `overlord` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `overlord`;
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
-- Table structure for table `consola_juegos`
--

DROP TABLE IF EXISTS `consola_juegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consola_juegos` (
  `id_consola` int NOT NULL,
  `id_juego` int NOT NULL,
  PRIMARY KEY (`id_consola`,`id_juego`),
  KEY `FK_CJ_JUE_idx` (`id_juego`),
  CONSTRAINT `FK_CJ_CON` FOREIGN KEY (`id_consola`) REFERENCES `consolas` (`idconsola`),
  CONSTRAINT `FK_CJ_JUE` FOREIGN KEY (`id_juego`) REFERENCES `juegos` (`idjuego`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consola_juegos`
--

LOCK TABLES `consola_juegos` WRITE;
/*!40000 ALTER TABLE `consola_juegos` DISABLE KEYS */;
INSERT INTO `consola_juegos` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),(3,21),(3,22),(3,23),(3,24),(3,25),(3,26),(3,27),(3,28),(3,29),(3,30),(4,31),(4,32),(4,33),(4,34),(4,35),(4,36),(4,37),(4,38),(4,39),(4,40),(5,41),(5,42),(5,43),(5,44),(5,45),(5,46),(5,47),(5,48),(5,49),(5,50),(1,51),(2,51),(3,51),(4,51),(5,51),(1,52),(2,52),(4,52),(5,52),(1,53),(2,53),(4,53),(5,53),(1,54),(2,54),(4,54),(5,54),(1,55),(2,55),(3,55),(4,55),(5,55),(1,56),(2,56),(4,56),(5,56),(1,57),(2,57),(4,57),(5,57),(1,58),(2,58),(4,58),(5,58),(1,59),(2,59),(4,59),(5,59),(1,60),(2,60),(4,60),(5,60),(1,61),(2,61),(3,61),(4,61),(5,61),(1,62),(2,62),(3,62),(4,62),(5,62),(1,63),(2,63),(3,63),(4,63),(5,63),(1,64),(2,64),(3,64),(4,64),(5,64),(1,65),(2,65),(3,65),(4,65),(5,65),(1,66),(2,66),(3,66),(4,66),(5,66),(1,67),(2,67),(3,67),(4,67),(5,67),(1,68),(2,68),(3,68),(4,68),(5,68),(1,69),(2,69),(3,69),(4,69),(5,69),(1,70),(2,70),(3,70),(4,70),(5,70);
/*!40000 ALTER TABLE `consola_juegos` ENABLE KEYS */;
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
  `estanteriaC` int DEFAULT NULL,
  `estanteriaF` int DEFAULT NULL,
  `rentado` tinyint(1) NOT NULL,
  `id_consola` int NOT NULL,
  `id_juego` int NOT NULL,
  PRIMARY KEY (`idejemplar`),
  KEY `FK_EJ_CON_idx` (`id_consola`),
  KEY `FK_EJ_JUE_idx` (`id_juego`),
  CONSTRAINT `FK_EJ_CON` FOREIGN KEY (`id_consola`) REFERENCES `consolas` (`idconsola`),
  CONSTRAINT `FK_EJ_JUE` FOREIGN KEY (`id_juego`) REFERENCES `juegos` (`idjuego`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplares`
--

LOCK TABLES `ejemplares` WRITE;
/*!40000 ALTER TABLE `ejemplares` DISABLE KEYS */;
INSERT INTO `ejemplares` VALUES (1,'OVER-1000001',1,1,0,1,1),(2,'OVER-1000002',2,2,0,1,1),(3,'OVER-1000003',3,3,0,1,2),(4,'OVER-1000004',4,4,0,1,2),(5,'OVER-1000005',5,5,0,1,3),(6,'OVER-1000006',6,6,0,1,3),(7,'OVER-1000007',7,7,0,1,4),(8,'OVER-1000008',8,8,0,1,4),(9,'OVER-1000009',9,9,0,1,5),(10,'OVER-1000010',10,10,0,1,5),(11,'OVER-2000001',1,1,0,2,11),(12,'OVER-2000002',2,2,0,2,11),(13,'OVER-2000003',3,3,0,2,12),(14,'OVER-2000004',4,4,0,2,12),(15,'OVER-2000005',5,5,0,2,13),(16,'OVER-2000006',6,6,0,2,13),(17,'OVER-2000007',7,7,0,2,14),(18,'OVER-2000008',8,8,0,2,14),(19,'OVER-2000009',9,9,0,2,15),(20,'OVER-2000010',10,10,0,2,15),(21,'OVER-3000001',1,1,0,3,21),(22,'OVER-3000002',2,2,0,3,21),(23,'OVER-3000003',3,3,0,3,22),(24,'OVER-3000004',4,4,0,3,22),(25,'OVER-3000005',5,5,0,3,23),(26,'OVER-3000006',6,6,0,3,23),(27,'OVER-3000007',7,7,0,3,24),(28,'OVER-3000008',8,8,0,3,24),(29,'OVER-4000001',1,1,0,4,31),(30,'OVER-4000002',2,2,0,4,31),(31,'OVER-4000003',3,3,0,4,32),(32,'OVER-4000004',4,4,0,4,32),(33,'OVER-4000005',5,5,0,4,33),(34,'OVER-4000006',6,6,0,4,33),(35,'OVER-4000007',7,7,0,4,34),(36,'OVER-4000008',8,8,0,4,34),(37,'OVER-5000001',1,1,0,5,41),(38,'OVER-5000002',2,2,0,5,41),(39,'OVER-5000003',3,3,0,5,42),(40,'OVER-5000004',4,4,0,5,42),(41,'OVER-5000005',5,5,0,5,43),(42,'OVER-5000006',6,6,0,5,43),(43,'OVER-5000007',7,7,0,5,44),(44,'OVER-5000008',8,8,0,5,44);
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
  PRIMARY KEY (`idjuego`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juegos`
--

LOCK TABLES `juegos` WRITE;
/*!40000 ALTER TABLE `juegos` DISABLE KEYS */;
INSERT INTO `juegos` VALUES (1,'Demon\'s Souls','RPG'),(2,'Spider-Man: Miles Morales','Acción'),(3,'Ratchet & Clank: Rift Apart','Acción'),(4,'Returnal','Acción'),(5,'Gran Turismo 7','Carreras'),(6,'Horizon Forbidden West','Aventura'),(7,'Astro\'s Playroom','Plataformas'),(8,'Final Fantasy XVI','RPG'),(9,'Sackboy: A Big Adventure','Plataformas'),(10,'Kena: Bridge of Spirits','Aventura'),(11,'The Last of Us Part II','Acción'),(12,'God of War','Acción'),(13,'Bloodborne','RPG'),(14,'Uncharted 4: A Thief\'s End','Aventura'),(15,'Horizon Zero Dawn','Aventura'),(16,'Ghost of Tsushima','Acción'),(17,'Persona 5','RPG'),(18,'Gran Turismo Sport','Carreras'),(19,'Spider-Man','Acción'),(20,'Red Dead Redemption 2','Aventura'),(21,'The Legend of Zelda: Breath of the Wild','Aventura'),(22,'Super Mario Odyssey','Plataformas'),(23,'Mario Kart 8 Deluxe','Carreras'),(24,'Animal Crossing: New Horizons','Simulación'),(25,'Splatoon 2','Acción'),(26,'Super Smash Bros. Ultimate','Pelea'),(27,'Fire Emblem: Three Houses','Estrategia'),(28,'Pokémon Sword and Shield','RPG'),(29,'Luigi\'s Mansion 3','Aventura'),(30,'Xenoblade Chronicles 2','RPG'),(31,'Halo Infinite','Acción'),(32,'Forza Horizon 5','Carreras'),(33,'Gears 5','Acción'),(34,'Fable','RPG'),(35,'State of Decay 2','Simulación'),(36,'Sea of Thieves','Aventura'),(37,'Ori and the Will of the Wisps','Plataformas'),(38,'Psychonauts 2','Plataformas'),(39,'The Medium','Terror'),(40,'Microsoft Flight Simulator','Simulación'),(41,'Cyberpunk 2077','RPG'),(42,'Valorant','Disparos'),(43,'League of Legends','MOBA'),(44,'Dota 2','MOBA'),(45,'World of Warcraft','RPG'),(46,'The Witcher 3: Wild Hunt','RPG'),(47,'Counter-Strike: Global Offensive','Disparos'),(48,'Among Us','Estrategia'),(49,'Minecraft','Simulación'),(50,'Starcraft II','Estrategia'),(51,'Fortnite','Disparos'),(52,'Apex Legends','Disparos'),(53,'Call of Duty: Warzone','Disparos'),(54,'Assassin\'s Creed Valhalla','Aventura'),(55,'FIFA 23','Deportes'),(56,'Madden NFL 23','Deportes'),(57,'NBA 2K23','Deportes'),(58,'Watch Dogs: Legion','Aventura'),(59,'Rainbow Six Siege','Disparos'),(60,'Far Cry 6','Acción'),(61,'Hades','RPG'),(62,'Celeste','Plataformas'),(63,'Hollow Knight','Aventura'),(64,'Cuphead','Plataformas'),(65,'Stardew Valley','Simulación'),(66,'Dead Cells','Acción'),(67,'The Binding of Isaac','Acción'),(68,'Slay the Spire','Estrategia'),(69,'Undertale','RPG'),(70,'Outer Wilds','Aventura');
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
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'overlord'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-02 13:58:11
