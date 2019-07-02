/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.13 : Database - ag_record_v1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ag_record_v1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ag_record_v1`;

/*Table structure for table `menstruation` */

DROP TABLE IF EXISTS `menstruation`;

CREATE TABLE `menstruation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mens_date` date DEFAULT NULL COMMENT '来大姨妈日期',
  `cycle` int(11) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` int(11) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `menstruation` */

/*Table structure for table `study` */

DROP TABLE IF EXISTS `study`;

CREATE TABLE `study` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crt_time` datetime DEFAULT NULL,
  `family` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `achieve_date` date DEFAULT NULL,
  `aim` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `study_content` varchar(255) DEFAULT NULL,
  `crt_user` int(11) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `study` */

/*Table structure for table `trade_order` */

DROP TABLE IF EXISTS `trade_order`;

CREATE TABLE `trade_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crt_user` int(11) DEFAULT NULL,
  `upd_user` int(11) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `amt` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `trade_date` date DEFAULT NULL,
  `trade_type` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1597 DEFAULT CHARSET=utf8;

/*Data for the table `trade_order` */

/*Table structure for table `trade_type` */

DROP TABLE IF EXISTS `trade_type`;

CREATE TABLE `trade_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crt_time` datetime DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `crt_user` int(11) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `org_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `trade_type` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
