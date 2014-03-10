# MySQL-Front 5.1  (Build 4.13)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: outletmanager
# ------------------------------------------------------
# Server version 5.0.67-community-nt

CREATE DATABASE `outletmanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `outletmanager`;

#
# Source for table employee
#

CREATE TABLE `employee` (
  `employeeId` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  `storeId` varchar(45) NOT NULL,
  PRIMARY KEY  (`employeeId`),
  KEY `fk_employee_Store1` (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table employee
#

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('employee1','admin','admin','admin','store1');
INSERT INTO `employee` VALUES ('employee2','user','user','user','store1');
INSERT INTO `employee` VALUES ('employee3','admin','admin','admin','store2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table majorcategory
#

CREATE TABLE `majorcategory` (
  `majorCategoryId` varchar(45) NOT NULL,
  `categoryName` varchar(45) default NULL,
  PRIMARY KEY  (`majorCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table majorcategory
#

LOCK TABLES `majorcategory` WRITE;
/*!40000 ALTER TABLE `majorcategory` DISABLE KEYS */;
INSERT INTO `majorcategory` VALUES ('ELEP','ElectionicProducts');
INSERT INTO `majorcategory` VALUES ('SPS','Sports');
/*!40000 ALTER TABLE `majorcategory` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table product
#

CREATE TABLE `product` (
  `barcode` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `subCategoryId` varchar(45) NOT NULL,
  `price` mediumtext NOT NULL,
  `cost` mediumtext NOT NULL,
  `place` varchar(45) NOT NULL,
  `others` varchar(45) default NULL,
  `model` varchar(45) NOT NULL,
  PRIMARY KEY  (`barcode`),
  KEY `fk_Product_Sub_category1` (`subCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table product
#

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('barcode1','iPod Nano','subcate2','800.00','300.00','China',NULL,'MODEL1');
INSERT INTO `product` VALUES ('barcode10','iPad','subcate2','3999.00','1000.00','China',NULL,'MODEL10');
INSERT INTO `product` VALUES ('barcode11','iMac','subcate2','12300','3950','China',NULL,'MODEL11');
INSERT INTO `product` VALUES ('barcode12','Mac mini','subcate2','4688','1400','China',NULL,'MODEL12');
INSERT INTO `product` VALUES ('barcode13','iPhone','subcate2','4999\n','1999','China',NULL,'MODEL13');
INSERT INTO `product` VALUES ('barcode14','iPod Shuffle','subcate2','950\t','320','China',NULL,'MODEL14');
INSERT INTO `product` VALUES ('barcode15','Ronaldo','subcate1','1008','200','China',NULL,'MODEL15');
INSERT INTO `product` VALUES ('barcode16','football','subcate1','45','10','China',NULL,'MODEL16');
INSERT INTO `product` VALUES ('barcode17','basketball','subcate1','40','10','China',NULL,'MODEL17');
INSERT INTO `product` VALUES ('barcode18','trophy','subcate1','10000','400','China',NULL,'MODEL18');
INSERT INTO `product` VALUES ('barcode19','golf ball','subcate1','60','20','China',NULL,'MODEL19');
INSERT INTO `product` VALUES ('barcode2','iPod Touch','subcate2','1000.00','400.00','China',NULL,'MODEL2');
INSERT INTO `product` VALUES ('barcode20','tennis ball','subcate1','10','2','China',NULL,'MODEL20');
INSERT INTO `product` VALUES ('barcode21','boxing gloves','subcate1','200','40','China',NULL,'MODEL21');
INSERT INTO `product` VALUES ('barcode22','volleyball','subcate1','50','10','China',NULL,'MODEL22');
INSERT INTO `product` VALUES ('barcode23','bracket','subcate1','400','50','China',NULL,'MODEL23');
INSERT INTO `product` VALUES ('barcode24','goggle','subcate1','200','45','China',NULL,'MODEL24');
INSERT INTO `product` VALUES ('barcode3','Kobe','subcate1','1000.00','300.00','China',NULL,'MODEL3');
INSERT INTO `product` VALUES ('barcode4','James','subcate1','1000.00','300.00','China',NULL,'MODEL4');
INSERT INTO `product` VALUES ('barcode5','Rose','subcate1','1000.00','300.00','China',NULL,'MODEL5');
INSERT INTO `product` VALUES ('barcode6','Kaka','subcate1','1000.00','300.00','China',NULL,'MODEL6');
INSERT INTO `product` VALUES ('barcode7','iPhone4s','subcate2','4999.00','1000.00','China',NULL,'MODEL7');
INSERT INTO `product` VALUES ('barcode8','Macbook Air','subcate2','8399.00','4000.00','China',NULL,'MODEL8');
INSERT INTO `product` VALUES ('barcode9','Macbook Pro','subcate2','9399.00','4000.00','China',NULL,'MODEL9');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table salesorder
#

CREATE TABLE `salesorder` (
  `orderId` bigint(20) unsigned zerofill NOT NULL auto_increment,
  `barcode` varchar(45) NOT NULL,
  `storeId` varchar(45) NOT NULL,
  `orderDate` datetime NOT NULL,
  `amount` int(11) NOT NULL,
  `total` mediumtext,
  PRIMARY KEY  (`orderId`),
  KEY `fk_Order_Product1` (`barcode`),
  KEY `fk_Order_Store1` (`storeId`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1;

#
# Dumping data for table salesorder
#

LOCK TABLES `salesorder` WRITE;
/*!40000 ALTER TABLE `salesorder` DISABLE KEYS */;
INSERT INTO `salesorder` VALUES (1,'barcode1','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (2,'barcode2','store1','2012-01-21',41,NULL);
INSERT INTO `salesorder` VALUES (3,'barcode3','store1','2012-04-01',2,NULL);
INSERT INTO `salesorder` VALUES (4,'barcode4','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (5,'barcode5','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (6,'barcode6','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (7,'barcode7','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (8,'barcode8','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (9,'barcode9','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (10,'barcode10','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (11,'barcode4','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (12,'barcode5','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (13,'barcode6','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (14,'barcode7','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (15,'barcode8','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (16,'barcode9','store1','2012-05-01',17,NULL);
INSERT INTO `salesorder` VALUES (17,'barcode10','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (18,'barcode1','store1','2012-04-01',2,NULL);
INSERT INTO `salesorder` VALUES (19,'barcode2','store1','2012-04-01',2,NULL);
INSERT INTO `salesorder` VALUES (20,'barcode3','store1','2012-04-01',1,NULL);
INSERT INTO `salesorder` VALUES (21,'barcode1','store1','2012-04-02',2,NULL);
INSERT INTO `salesorder` VALUES (22,'barcode2','store1','2012-04-02',1,NULL);
INSERT INTO `salesorder` VALUES (23,'barcode1','store1','2012-04-17',27,NULL);
INSERT INTO `salesorder` VALUES (24,'barcode2','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (25,'barcode3','store1','2012-04-17',24,NULL);
INSERT INTO `salesorder` VALUES (26,'barcode4','store1','2012-04-17',3,NULL);
INSERT INTO `salesorder` VALUES (27,'barcode5','store1','2012-04-17',4,NULL);
INSERT INTO `salesorder` VALUES (28,'barcode6','store1','2012-04-17',5,NULL);
INSERT INTO `salesorder` VALUES (29,'barcode7','store1','2012-02-17',66,NULL);
INSERT INTO `salesorder` VALUES (30,'barcode8','store1','2012-03-17',89,NULL);
INSERT INTO `salesorder` VALUES (31,'barcode9','store1','2012-04-17',24,NULL);
INSERT INTO `salesorder` VALUES (32,'barcode10','store1','2012-06-17',81,NULL);
INSERT INTO `salesorder` VALUES (33,'barcode1','store1','2012-04-17',4,NULL);
INSERT INTO `salesorder` VALUES (34,'barcode2','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (35,'barcode3','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (36,'barcode4','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (37,'barcode5','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (38,'barcode6','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (39,'barcode7','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (40,'barcode8','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (41,'barcode9','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (42,'barcode10','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (43,'barcode2','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (44,'barcode3','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (45,'barcode4','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (46,'barcode5','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (47,'barcode6','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (48,'barcode7','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (49,'barcode8','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (50,'barcode9','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (51,'barcode10','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (52,'barcode1','store1','2012-04-17',3,NULL);
INSERT INTO `salesorder` VALUES (53,'barcode2','store1','2012-08-17',123,NULL);
INSERT INTO `salesorder` VALUES (54,'barcode3','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (55,'barcode4','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (56,'barcode5','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (57,'barcode6','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (58,'barcode1','store1','2012-04-17',3,NULL);
INSERT INTO `salesorder` VALUES (59,'barcode7','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (60,'barcode2','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (61,'barcode8','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (62,'barcode3','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (63,'barcode9','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (64,'barcode4','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (65,'barcode10','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (66,'barcode1','store1','2012-04-17',5,NULL);
INSERT INTO `salesorder` VALUES (67,'barcode6','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (68,'barcode2','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (69,'barcode7','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (70,'barcode3','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (71,'barcode8','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (72,'barcode4','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (73,'barcode9','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (74,'barcode5','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (75,'barcode10','store1','2012-04-17',9,NULL);
INSERT INTO `salesorder` VALUES (76,'barcode6','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (77,'barcode10','store1','2012-04-17',22,NULL);
INSERT INTO `salesorder` VALUES (78,'barcode7','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (79,'barcode8','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (80,'barcode1','store1','2012-04-17',2,NULL);
INSERT INTO `salesorder` VALUES (81,'barcode9','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (82,'barcode2','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (83,'barcode10','store1','2012-04-17',23,NULL);
INSERT INTO `salesorder` VALUES (84,'barcode3','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (85,'barcode4','store1','2012-04-17',1,NULL);
INSERT INTO `salesorder` VALUES (86,'barcode1','store1','2012-04-19',4,NULL);
INSERT INTO `salesorder` VALUES (88,'barcode10','store2','2012-12-29',2,NULL);
INSERT INTO `salesorder` VALUES (89,'barcode1','store2','2012-07-01',58,NULL);
INSERT INTO `salesorder` VALUES (90,'barcode1','store2','2012-04-19',4,NULL);
INSERT INTO `salesorder` VALUES (91,'barcode1','store2','2012-04-19',2,NULL);
INSERT INTO `salesorder` VALUES (92,'barcode1','store2','2012-04-19',92,NULL);
INSERT INTO `salesorder` VALUES (93,'barcode10','store2','2012-04-19',1,NULL);
INSERT INTO `salesorder` VALUES (94,'barcode1','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (95,'barcode2','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (96,'barcode3','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (97,'barcode14','store1','2012-04-20',3,NULL);
INSERT INTO `salesorder` VALUES (98,'barcode4','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (99,'barcode5','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (100,'barcode6','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (101,'barcode7','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (102,'barcode8','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (103,'barcode9','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (104,'barcode10','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (105,'barcode11','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (106,'barcode12','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (107,'barcode13','store1','2012-04-20',3,NULL);
INSERT INTO `salesorder` VALUES (108,'barcode3','store1','2012-04-20',4,NULL);
INSERT INTO `salesorder` VALUES (109,'barcode1','store1','2012-04-20',1,NULL);
INSERT INTO `salesorder` VALUES (110,'barcode2','store1','2012-04-20',3,NULL);
INSERT INTO `salesorder` VALUES (111,'barcode4','store1','2012-04-20',3,NULL);
INSERT INTO `salesorder` VALUES (112,'barcode15','store1','2012-04-20',4,NULL);
INSERT INTO `salesorder` VALUES (113,'barcode5','store1','2012-04-20',1,NULL);
INSERT INTO `salesorder` VALUES (114,'barcode1','store1','2012-04-20',6,NULL);
INSERT INTO `salesorder` VALUES (115,'barcode2','store1','2012-04-20',6,NULL);
INSERT INTO `salesorder` VALUES (116,'barcode3','store1','2012-04-20',6,NULL);
INSERT INTO `salesorder` VALUES (117,'barcode24','store1','2012-04-20',1,NULL);
INSERT INTO `salesorder` VALUES (118,'barcode4','store1','2012-04-20',4,NULL);
INSERT INTO `salesorder` VALUES (119,'barcode5','store1','2012-04-20',4,NULL);
INSERT INTO `salesorder` VALUES (120,'barcode6','store1','2012-04-20',3,NULL);
INSERT INTO `salesorder` VALUES (121,'barcode23','store1','2012-04-20',1,NULL);
INSERT INTO `salesorder` VALUES (122,'barcode7','store1','2012-04-20',1,NULL);
INSERT INTO `salesorder` VALUES (123,'barcode6','store1','2012-04-20',1,NULL);
INSERT INTO `salesorder` VALUES (124,'barcode7','store1','2012-04-20',2,NULL);
INSERT INTO `salesorder` VALUES (125,'barcode4','store1','2012-04-20',1,NULL);
/*!40000 ALTER TABLE `salesorder` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table storage
#

CREATE TABLE `storage` (
  `barcode` varchar(45) NOT NULL,
  `storeId` varchar(45) NOT NULL,
  `storage` int(11) NOT NULL,
  PRIMARY KEY  (`barcode`,`storeId`),
  KEY `fk_Storage_Store1` (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table storage
#

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES ('barcode1','store1',176);
INSERT INTO `storage` VALUES ('barcode1','store2',202);
INSERT INTO `storage` VALUES ('barcode10','store1',298);
INSERT INTO `storage` VALUES ('barcode10','store2',399);
INSERT INTO `storage` VALUES ('barcode11','store1',319);
INSERT INTO `storage` VALUES ('barcode12','store1',210);
INSERT INTO `storage` VALUES ('barcode13','store1',148);
INSERT INTO `storage` VALUES ('barcode14','store1',48);
INSERT INTO `storage` VALUES ('barcode15','store1',17);
INSERT INTO `storage` VALUES ('barcode15','store2',210);
INSERT INTO `storage` VALUES ('barcode16','store1',21);
INSERT INTO `storage` VALUES ('barcode17','store1',51);
INSERT INTO `storage` VALUES ('barcode18','store1',78);
INSERT INTO `storage` VALUES ('barcode19','store1',15);
INSERT INTO `storage` VALUES ('barcode2','store1',488);
INSERT INTO `storage` VALUES ('barcode2','store2',515);
INSERT INTO `storage` VALUES ('barcode20','store1',90);
INSERT INTO `storage` VALUES ('barcode21','store1',195);
INSERT INTO `storage` VALUES ('barcode22','store1',61);
INSERT INTO `storage` VALUES ('barcode23','store1',150);
INSERT INTO `storage` VALUES ('barcode24','store1',266);
INSERT INTO `storage` VALUES ('barcode3','store1',183);
INSERT INTO `storage` VALUES ('barcode4','store1',185);
INSERT INTO `storage` VALUES ('barcode5','store1',189);
INSERT INTO `storage` VALUES ('barcode5','store2',236);
INSERT INTO `storage` VALUES ('barcode6','store1',190);
INSERT INTO `storage` VALUES ('barcode7','store1',191);
INSERT INTO `storage` VALUES ('barcode8','store1',194);
INSERT INTO `storage` VALUES ('barcode9','store1',194);
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table store
#

CREATE TABLE `store` (
  `storeId` varchar(45) NOT NULL,
  `address` varchar(45) default NULL,
  `storeOwner` varchar(45) NOT NULL,
  `storeName` varchar(45) default NULL,
  PRIMARY KEY  (`storeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table store
#

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES ('store1',NULL,'Pig','OnePiece');
INSERT INTO `store` VALUES ('store2',NULL,'Ball','Gintama');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table subcategory
#

CREATE TABLE `subcategory` (
  `subCategoryId` varchar(45) NOT NULL,
  `subCategoryName` varchar(45) default NULL,
  `majorCategoryId` varchar(45) NOT NULL,
  PRIMARY KEY  (`subCategoryId`),
  KEY `fk_Sub_category_Major_category1` (`majorCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table subcategory
#

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES ('subcate1','Nike','SPS');
INSERT INTO `subcategory` VALUES ('subcate2','Apple','ELEP');
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table employee
#

ALTER TABLE `employee`
ADD CONSTRAINT `fk_employee_Store1` FOREIGN KEY (`storeId`) REFERENCES `store` (`storeId`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table product
#

ALTER TABLE `product`
ADD CONSTRAINT `fk_Product_Sub_category1` FOREIGN KEY (`subCategoryId`) REFERENCES `subcategory` (`subCategoryId`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table salesorder
#

ALTER TABLE `salesorder`
ADD CONSTRAINT `fk_Order_Product1` FOREIGN KEY (`barcode`) REFERENCES `product` (`barcode`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Order_Store1` FOREIGN KEY (`storeId`) REFERENCES `store` (`storeId`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table storage
#

ALTER TABLE `storage`
ADD CONSTRAINT `fk_Storage_Product1` FOREIGN KEY (`barcode`) REFERENCES `product` (`barcode`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Storage_Store1` FOREIGN KEY (`storeId`) REFERENCES `store` (`storeId`) ON DELETE CASCADE ON UPDATE CASCADE;

#
#  Foreign keys for table subcategory
#

ALTER TABLE `subcategory`
ADD CONSTRAINT `fk_Sub_category_Major_category1` FOREIGN KEY (`majorCategoryId`) REFERENCES `majorcategory` (`majorCategoryId`) ON DELETE CASCADE ON UPDATE CASCADE;


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
