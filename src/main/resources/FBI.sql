SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS `FBI`;
CREATE DATABASE `FBI`;
USE `FBI`;
-- ----------------------------
-- Table structure for DELITOS
-- ----------------------------
DROP TABLE IF EXISTS `DELITOS`;
CREATE TABLE `DELITOS`  (
  `FICHA` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `DELITO` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `FECHA` datetime(0) NULL DEFAULT NULL,
  `OBSERVACIONES` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `TOKEN` varchar(125) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`TOKEN`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ESTADOS
-- ----------------------------
DROP TABLE IF EXISTS `ESTADOS`;
CREATE TABLE `ESTADOS`  (
  `ESTADO` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `NOMBRE` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ESTADO`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for SOSPECHOSOS
-- ----------------------------
DROP TABLE IF EXISTS `SOSPECHOSOS`;
CREATE TABLE `SOSPECHOSOS`  (
  `FICHA` varchar(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ESTADO` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `NOMBRE` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `SEXO` enum('V','M','I') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `ALTURA` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `PESO` tinyint(0) NULL DEFAULT NULL,
  `FECHANACIMIENTO` date NULL DEFAULT NULL,
  `FOTO` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  PRIMARY KEY (`FICHA`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
