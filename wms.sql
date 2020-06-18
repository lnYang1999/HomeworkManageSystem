CREATE DATABASE  IF NOT EXISTS `wms` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wms`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: wms
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `checkwork`
--

DROP TABLE IF EXISTS `checkwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkwork` (
  `ch_id` int(11) NOT NULL AUTO_INCREMENT,
  `ch_s_account` varchar(10) DEFAULT NULL,
  `ch_c_id` varchar(10) DEFAULT NULL,
  `ch_w_id` int(11) DEFAULT NULL,
  `ch_score` int(11) DEFAULT NULL,
  `ch_mark` varchar(100) DEFAULT NULL,
  `ch_checkTime` datetime DEFAULT NULL,
  `ch_upTime` datetime DEFAULT NULL,
  `ch_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkwork`
--

LOCK TABLES `checkwork` WRITE;
/*!40000 ALTER TABLE `checkwork` DISABLE KEYS */;
INSERT INTO `checkwork` VALUES (1,'17301053','1702',4,0,'怎么没写作业？',NULL,'2019-12-06 00:00:00','D:\\BackUp'),(2,'17301000','1701',2,100,'good,很好，不错','2019-12-06 00:00:00','2019-12-06 00:00:00','D:\\BackUp'),(3,'17301001','1701',1,87,'完成的还是不错的哦','2019-12-06 19:56:06','2019-12-06 19:55:00','F:\\');
/*!40000 ALTER TABLE `checkwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` varchar(10) DEFAULT NULL,
  `c_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'1701',15),(2,'1702',15),(3,'1703',15);
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `c_credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'软件工程',4),(2,'数据结构',2),(3,'JavaEE',2),(4,'软件测试',2),(5,'操作系统',2);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `m_account` varchar(10) DEFAULT NULL,
  `m_name` varchar(20) DEFAULT NULL,
  `m_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'admin','admin','admin'),(2,'ysp','杨烁平','ysp');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `nt_id` int(11) NOT NULL AUTO_INCREMENT,
  `nt_title` varchar(20) DEFAULT NULL,
  `nt_content` varchar(500) DEFAULT NULL,
  `nt_time` datetime DEFAULT NULL,
  `nt_t_account` varchar(10) DEFAULT NULL,
  `nt_c_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'调课通知','明天的课星期六补','2099-12-06 00:00:00','99999','1701'),(2,'调课通知','明天的课星期八补','2099-12-06 00:00:00','99999','1702'),(3,'调课通知','明天的课星期日补','2020-12-06 00:00:00','123','1701'),(4,'放假通知','明天开始不用上课了','2020-12-06 00:00:00','5555','1701'),(5,'课程停开','课程停开了','2020-12-06 00:00:00','777','1702'),(8,'考试','咱们课程结课了，考试也即将进行，请大家做好准备','2020-06-18 00:00:00','99999','1701');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_account` varchar(10) DEFAULT NULL,
  `s_name` varchar(20) DEFAULT NULL,
  `s_sex` varchar(2) DEFAULT NULL,
  `s_c_id` varchar(10) DEFAULT NULL,
  `s_password` varchar(20) DEFAULT NULL,
  `s_dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'17301000','张三','男','1701','17301000','软件学院'),(2,'17301001','李四','女','1701','17301001','软件学院'),(3,'17301002','王五','女','1701','17301002','软件学院'),(4,'17301053','杨烁平','男','1702','17301053','软件学院'),(5,'17301111','王二','女','1703','17301111','软件学院');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_account` varchar(10) DEFAULT NULL,
  `t_name` varchar(20) DEFAULT NULL,
  `t_sex` varchar(2) DEFAULT NULL,
  `t_dept` varchar(20) DEFAULT NULL,
  `t_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'99999','杨烁平','男','软件学院','999'),(2,'123','金牌讲师','男','软件学院','111'),(3,'5555','伍兹','男','计算机学院','5555'),(4,'777','7酱','男','软件学院','777');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work` (
  `w_id` int(11) NOT NULL AUTO_INCREMENT,
  `w_title` varchar(50) DEFAULT NULL,
  `w_content` varchar(500) DEFAULT NULL,
  `w_deadline` varchar(30) DEFAULT NULL,
  `w_course` varchar(20) DEFAULT NULL,
  `w_t_account` varchar(10) DEFAULT NULL,
  `w_c_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`w_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,'操作系统课后作业','把书抄十遍！！！！！！！！！','2099-12-31','操作系统','5555','1701'),(2,'软件工程课后作业','没作业！！！！！！！！！','2099-12-31','软件工程','99999','1701'),(3,'课后作业','把书抄五十遍！！！','2099-12-31','数据结构','123','1701'),(4,'操作系统课后作业','把书抄十遍！！！！！！！！！','2099-12-31','操作系统','5555','1702'),(6,'作业','请大家早点点一次外卖','2099-12-31','软件测试','777','1702'),(8,'结课大作业','编写一个作业管理系统','2020-06-18','JavaEE','99999','1701');
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 21:24:29
