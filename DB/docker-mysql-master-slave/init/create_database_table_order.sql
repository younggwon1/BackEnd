CREATE DATABASE `order` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use order;

CREATE TABLE `order` (
  `orderId` bigint(11) unsigned NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_delivery` (
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) NOT NULL,
  `address` varchar(200) NOT NULL DEFAULT '',
  `phone` varchar(20) NOT NULL DEFAULT '',
  `deliveryMessage` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_items` (
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) NOT NULL,
  `productId` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_member` (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) NOT NULL,
  `memberId` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `productId` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT '',
  `price` int(11) NOT NULL DEFAULT '0',
  `inventory` int(11) NOT NULL DEFAULT '0',
  `imagePath` varchar(1000) NOT NULL,
  `description` text,
  `created` datetime NOT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

CREATE TABLE `raw_event` (
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `identifier` varchar(8) NOT NULL DEFAULT '',
  `type` varchar(200) NOT NULL DEFAULT '',
  `version` bigint(20) NOT NULL,
  `payload` text NOT NULL,
  `created` datetime NOT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;



CREATE TABLE `sequence` (
  `orderId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sequence` (orderId) VALUES (0);
