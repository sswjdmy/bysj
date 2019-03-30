-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy_management_system
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `medicineName` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `prescription` tinyint(4) NOT NULL,
  `charge` decimal(10,0) NOT NULL,
  `medicineDescribe` varchar(2500) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `medicineNumber` int(10) NOT NULL,
  `addTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,4,14,'大清药丸',0,998,'好听吗？好听就是好药',0,'2017-12-24 06:30:46'),(4,4,14,'全世界最好的蔡徐坤',0,3,'nmsl',4,'2019-03-29 15:59:18'),(6,4,5,'2222',0,2,'222',2,'2019-03-29 16:18:31'),(7,4,13,'d\'s\'d\'s',0,3,'sa\'d\'f\'d\'g\'f\'h\'g\'j\'h\'g\'fa',8,'2019-03-29 16:21:10'),(10,4,5,'sdfgh',0,2,'dsaf',4,'2019-03-29 16:43:19'),(11,4,5,'asdafa',0,2,'dsadf',2,'2019-03-29 16:43:29'),(12,4,14,'asdfg',0,3,'22334455',7,'2019-03-29 16:47:59'),(17,4,13,'assfgg',0,5,'dsf',3,'2019-03-29 17:58:07'),(18,4,6,'asdgfgjhghg',0,5,'sdgfhgfhh',6,'2019-03-29 18:02:57'),(19,4,14,'qqqqq',0,5,'sfgfdgf',4,'2019-03-29 18:31:14'),(23,4,13,'asdff',0,2,'safdgf',3,'2019-03-29 19:06:48'),(26,4,14,'iiiii',0,1,'iiiiiiillllll',0,'2019-03-29 19:15:42'),(29,4,14,'rrrr',1,1,'adsfdgh',1,'2019-03-29 19:19:13'),(30,4,6,'asdfgh',1,1,'<template>\n  <el-popover\n    placement=\"top-start\"\n    title=\"标题\"\n    width=\"200\"\n    trigger=\"hover\"\n    content=\"这是一段内容,这是一段内容,这是一段内容,这是一段内容。\">\n    <el-button slot=\"reference\">hover 激活</el-button>\n  </el-popover>\n\n  <el-popover\n    placement=\"bottom\"\n    title=\"标题\"\n    width=\"200\"\n    trigger=\"click\"\n    content=\"这是一段内容,这是一段内容,这是一段内容,这是一段内容。\">\n    <el-button slot=\"reference\">click 激活</el-button>\n  </el-popover>\n\n  <el-popover\n    ref=\"popover\"\n    placement=\"right\"\n    title=\"标题\"\n    width=\"200\"\n    trigger=\"focus\"\n    content=\"这是一段内容,这是一段内容,这是一段内容,这是一段内容。\">\n  </el-popover>\n  <el-button v-popover:popover>focus 激活</el-button>\n\n  <el-popover\n    placement=\"bottom\"\n    title=\"标题\"\n    width=\"200\"\n    trigger=\"manual\"\n    content=\"这是一段内容,这是一段内容,这是一段内容,这是一段内容。\"\n    v-model=\"visible\">\n    <el-button slot=\"reference\" @click=\"visible = !visible\">手动激活</el-button>\n  </el-popover>\n</template>\n\n<script>\n  export default {\n    data() {\n      return {\n        visible: false\n      };\n    }\n  };\n</script>',1,'2019-03-29 20:26:06');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine_type`
--

DROP TABLE IF EXISTS `medicine_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cateName` varchar(64) COLLATE utf8_bin NOT NULL,
  `uid` int(11) NOT NULL,
  `subNumber` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine_type`
--

LOCK TABLES `medicine_type` WRITE;
/*!40000 ALTER TABLE `medicine_type` DISABLE KEYS */;
INSERT INTO `medicine_type` VALUES (3,'aaa',2,0),(5,'type1',4,7),(6,'type2',4,4),(13,'123123123',4,4),(14,'awsl',4,13),(22,'asdsggfhh',4,0),(23,'dddddddddd',4,0);
/*!40000 ALTER TABLE `medicine_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_user`
--

DROP TABLE IF EXISTS `roles_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_user`
--

LOCK TABLES `roles_user` WRITE;
/*!40000 ALTER TABLE `roles_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'kirito','admin','18383312123'),(2,'asuna','21232f297a57a5a743894a0e4a801fc3','13112312345'),(3,'asuna1','21232f297a57a5a743894a0e4a801fc3','13112312345'),(4,'alice','21232f297a57a5a743894a0e4a801fc3','18383390123'),(5,'saber','e10adc3949ba59abbe56e057f20f883e','12345678901');
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

-- Dump completed on 2019-03-30 11:11:45
