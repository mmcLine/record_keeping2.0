/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.13 : Database - ag_auth_v1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ag_auth_v1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `ag_auth_v1`;

/*Table structure for table `auth_client` */

DROP TABLE IF EXISTS `auth_client`;

CREATE TABLE `auth_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '服务编码',
  `secret` varchar(255) DEFAULT NULL COMMENT '服务密钥',
  `name` varchar(255) DEFAULT NULL COMMENT '服务名',
  `locked` char(1) DEFAULT NULL COMMENT '是否锁定',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '创建人姓名',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '创建主机',
  `upd_time` datetime DEFAULT NULL COMMENT '更新时间',
  `upd_user` varchar(255) DEFAULT NULL COMMENT '更新人',
  `upd_name` varchar(255) DEFAULT NULL COMMENT '更新姓名',
  `upd_host` varchar(255) DEFAULT NULL COMMENT '更新主机',
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `auth_client` */

insert  into `auth_client`(`id`,`code`,`secret`,`name`,`locked`,`description`,`crt_time`,`crt_user`,`crt_name`,`crt_host`,`upd_time`,`upd_user`,`upd_name`,`upd_host`,`attr1`,`attr2`,`attr3`,`attr4`,`attr5`,`attr6`,`attr7`,`attr8`) values (1,'ace-gate','123456','ace-gate','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'ace-admin','123456','ace-admin','0','',NULL,NULL,NULL,NULL,'2017-07-06 21:42:17','1','管理员','0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'ace-auth','123456','ace-auth','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'ace-config','fXHsssa2','ace-config','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'ace-template','bZf8yvj8','ace-template','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'ace-trace','wKTl6GGE','ace-trace','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'ace-monitor','eEQBUcnW','ace-monitor','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'ace-record','123456','ace-record','0','记账服务','2019-06-20 22:43:11','1','admin','169.254.19.230','2019-06-20 22:43:11','1','admin','169.254.19.230',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `auth_client_service` */

DROP TABLE IF EXISTS `auth_client_service`;

CREATE TABLE `auth_client_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `auth_client_service` */

insert  into `auth_client_service`(`id`,`service_id`,`client_id`,`description`,`crt_time`,`crt_user`,`crt_name`,`crt_host`,`attr1`,`attr2`,`attr3`,`attr4`,`attr5`,`attr6`,`attr7`,`attr8`) values (21,'4','5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'3','6',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'3','1',NULL,'2017-12-31 08:58:03','null','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,'6','1',NULL,'2017-12-31 08:58:03','null','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'16','1',NULL,'2019-06-22 09:25:29',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
