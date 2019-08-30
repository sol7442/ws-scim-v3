-- --------------------------------------------------------
-- 호스트:                          wession.com
-- 서버 버전:                        5.5.38-0ubuntu0.12.04.1 - (Ubuntu)
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- ws_scim_v3 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `ws_scim_v3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ws_scim_v3`;


-- 테이블 ws_scim_v3.SCIM_ATTRIBUTE 구조 내보내기
DROP TABLE IF EXISTS `SCIM_ATTRIBUTE`;
CREATE TABLE IF NOT EXISTS `SCIM_ATTRIBUTE` (
  `id` varchar(255) NOT NULL,
  `job_id` varchar(64) DEFAULT NULL,
  `org_id` varchar(64) DEFAULT NULL,
  `pos_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd9hjgi9dbwt0w87hu1nemmh6b` (`job_id`),
  KEY `FKf3juxkjjchcgxnyidy81y4r4m` (`org_id`),
  KEY `FKe3kv1oaysl0fhtcuc5qui7odv` (`pos_id`),
  CONSTRAINT `FKe3kv1oaysl0fhtcuc5qui7odv` FOREIGN KEY (`pos_id`) REFERENCES `SCIM_POS` (`id`),
  CONSTRAINT `FKd9hjgi9dbwt0w87hu1nemmh6b` FOREIGN KEY (`job_id`) REFERENCES `SCIM_JOB` (`id`),
  CONSTRAINT `FKf3juxkjjchcgxnyidy81y4r4m` FOREIGN KEY (`org_id`) REFERENCES `SCIM_ORG` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 ws_scim_v3.SCIM_GROUP 구조 내보내기
DROP TABLE IF EXISTS `SCIM_GROUP`;
CREATE TABLE IF NOT EXISTS `SCIM_GROUP` (
  `type` varchar(31) NOT NULL,
  `id` varchar(64) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 ws_scim_v3.SCIM_JOB 구조 내보내기
DROP TABLE IF EXISTS `SCIM_JOB`;
CREATE TABLE IF NOT EXISTS `SCIM_JOB` (
  `id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKs43eogd4xx1ol5nnwd3xmbjec` FOREIGN KEY (`id`) REFERENCES `SCIM_GROUP` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 ws_scim_v3.SCIM_ORG 구조 내보내기
DROP TABLE IF EXISTS `SCIM_ORG`;
CREATE TABLE IF NOT EXISTS `SCIM_ORG` (
  `path` varchar(255) DEFAULT NULL,
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PARENT` (`parent_id`),
  CONSTRAINT `FKs293eegc488esbyeeok0mnvfl` FOREIGN KEY (`id`) REFERENCES `SCIM_GROUP` (`id`),
  CONSTRAINT `FK_PARENT` FOREIGN KEY (`parent_id`) REFERENCES `SCIM_ORG` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 ws_scim_v3.SCIM_POS 구조 내보내기
DROP TABLE IF EXISTS `SCIM_POS`;
CREATE TABLE IF NOT EXISTS `SCIM_POS` (
  `id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKagt8wgm4cx88he9s0vuk0qb4q` FOREIGN KEY (`id`) REFERENCES `SCIM_GROUP` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 ws_scim_v3.SCIM_USER 구조 내보내기
DROP TABLE IF EXISTS `SCIM_USER`;
CREATE TABLE IF NOT EXISTS `SCIM_USER` (
  `id` varchar(64) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 ws_scim_v3.SCIM_USER_ATTRIBUTE 구조 내보내기
DROP TABLE IF EXISTS `SCIM_USER_ATTRIBUTE`;
CREATE TABLE IF NOT EXISTS `SCIM_USER_ATTRIBUTE` (
  `user_id` varchar(64) NOT NULL,
  `attr_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`attr_id`),
  KEY `FKjjhk6dfv68t78fsnvql5wxiu2` (`attr_id`),
  CONSTRAINT `FK_USER_ATTRIBUTE` FOREIGN KEY (`user_id`) REFERENCES `SCIM_USER` (`id`),
  CONSTRAINT `FKjjhk6dfv68t78fsnvql5wxiu2` FOREIGN KEY (`attr_id`) REFERENCES `SCIM_ATTRIBUTE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
