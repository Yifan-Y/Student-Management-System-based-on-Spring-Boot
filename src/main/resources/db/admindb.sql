
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`  (
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `authority` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  UNIQUE INDEX `authorities_idx_1`(`username` ASC, `authority` ASC) USING BTREE,
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('erfan', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('erfan', 'ROLE_MANAGER');
INSERT INTO `authorities` VALUES ('sanfan', 'ROLE_ADMIN');
INSERT INTO `authorities` VALUES ('sanfan', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('yifan', 'ROLE_EMPLOYEE');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` char(68) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('erfan', '{bcrypt}$2a$12$P0eMgxZtQxwNuiFzF4sWFeX1rEYeB5YHtJrwC7hNpyl9zaSgsYQ..', 1);
INSERT INTO `users` VALUES ('sanfan', '{bcrypt}$2a$12$ohF9LVSkDLRgN3l1aMEAwO0WXF0/8pExCnwsVgUYfJRfHjhqRQB6u', 1);
INSERT INTO `users` VALUES ('yifan', '{bcrypt}$2a$12$rzP0/2oZTX.qQ06XLMCEWukxU0qQFyULVeQm/c.7CrWODXGsHn1/G', 1);

SET FOREIGN_KEY_CHECKS = 1;
