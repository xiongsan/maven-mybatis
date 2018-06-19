/*
Navicat MySQL Data Transfer

Source Server         : 47.98.187.131
Source Server Version : 50718
Source Host           : 47.98.187.131:3306
Source Database       : hairuide

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-06-13 12:58:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `filelist`
-- ----------------------------
DROP TABLE IF EXISTS `filelist`;
CREATE TABLE `filelist` (
`id`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`fileName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`fileUrl`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`createTime`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='文件相关'

;

-- ----------------------------
-- Records of filelist
-- ----------------------------
BEGIN;
INSERT INTO `filelist` VALUES ('06e80549-14c7-4762-9953-19419cfbf958', '微信图片_20180328124548.jpg', '59a3c6bc-78b1-4d99-9d78-f31137796e1f', '2018-04-25 09:08:14'), ('21aa731b-94ac-48a6-8fbf-83e584980365', '微信图片_20180328124611.jpg', '08b5ea55-e1a3-40d9-a99c-9687e84a5386', '2018-04-25 09:09:06'), ('3b9f02b2-3aef-466e-a294-af7c218170ac', 'IMG_4837.JPG', 'ee50d693-b0d1-4e15-8cb4-9a67bb84ffb3', '2018-04-25 14:24:53'), ('500bea6e-1390-4d21-aa08-1037ed8d0396', '微信图片_20180328124616.jpg', '25923d95-8524-4c52-a6fb-07e7e6795791', '2018-04-25 09:09:00'), ('56deddb8-c449-4dfc-94e6-61b232b8f0b0', '微信图片_20180328124541.jpg', '8f5eb717-e352-4a10-9a7d-cb7e484421dd', '2018-04-25 09:06:44'), ('58351ac1-3924-4baa-b70a-d6c4337acbcf', '微信图片_20180328124651.jpg', 'bb94912f-006d-4527-89a3-9ab0571a0306', '2018-04-25 09:08:06'), ('6a29b765-7baa-4569-9e7a-b428e466311a', '微信图片_20180331094800.jpg', '97378245-afb0-456b-b6a2-178446072cb0', '2018-04-25 09:09:19'), ('6d51e803-7b3d-4a78-87c5-ad14b7bbce7b', '微信图片_20180331094817.jpg', '9e042b22-2b5f-4d00-b080-538fe419c01c', '2018-04-25 09:07:54'), ('70bb13aa-0f95-4415-9c54-9c0863407fbc', 'IMG_4879.JPG', 'cc82c1b2-c4b4-4a1a-9a65-113579e51c23', '2018-04-25 14:24:22'), ('89e0f875-92f4-451b-9f77-f407909b42d6', 'trim.6C9E85F5-A153-4C40-9180-CBF217FC2F0D.MOV', '5f5e1a6e-8769-4547-88bf-04349cae72ee', '2018-04-25 14:23:24'), ('8b295883-c5c6-4b06-bbc9-91a91498fc21', 'IMG_4918.JPG', '75283056-90a8-431a-bcc4-871a76a36372', '2018-04-25 14:22:54');
COMMIT;

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pageUrl`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`description`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  int(11) NOT NULL DEFAULT 1 ,
PRIMARY KEY (`id`),
UNIQUE INDEX `menu_id_uindex` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='菜单表'

;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('1', '查看数据', '/hehe', '查看', null, '1'), ('10', '删除todo', '/haha', null, null, '1'), ('2', '添加数据', '/haha', null, null, '1'), ('3', '上传文件', '/haha', null, null, '1'), ('4', '下载文件', '/haha', null, null, '1'), ('5', '删除文件', '/haha', null, null, '1'), ('6', 'hanoi', '/haha', null, null, '1'), ('7', 'todolist', '/haha', null, null, '1'), ('8', 'picture', '/haha', null, null, '1'), ('9', 'filelist', '/liveApproval', null, null, '1');
COMMIT;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`remark`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  int(11) NULL DEFAULT 1 ,
PRIMARY KEY (`id`),
UNIQUE INDEX `role_id_uindex` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色信息表'

;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'sysadmin', '系统管理员', '1'), ('2', 'admin', '普通管理员', '1'), ('3', 'guest', '一般用户', '1');
COMMIT;

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`roleId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`menuId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`menuId`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `role_menu_id_uindex` (`id`) USING BTREE ,
INDEX `role_menu_role_id_fk` (`roleId`) USING BTREE ,
INDEX `role_menu_menu_id_fk` (`menuId`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色菜单表'

;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `todolist`
-- ----------------------------
DROP TABLE IF EXISTS `todolist`;
CREATE TABLE `todolist` (
`ID`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`TITLE`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`CHECKED`  int(11) NOT NULL DEFAULT 0 ,
`SEX`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`ID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of todolist
-- ----------------------------
BEGIN;
INSERT INTO `todolist` VALUES ('098dd35c-f7fa-443d-99a2-66397637b6ba', '傻根', '1', '女'), ('0bf5fb83-d2ec-431a-ab4b-4db747bbfcce', '来福', '0', '女'), ('0ff5a478-bc3c-4650-862f-3611bcd96b33', '傻根', '1', '女'), ('1013e63e-77ae-4125-9ae5-dfd563c9cd86', '赵六', '0', '女'), ('2956ac2d-243b-4135-b91d-3fcf9ca25680', '李四', '1', '女'), ('315f0c56-918c-497e-b31f-e74cec81c064', '王二麻', '0', '女'), ('332ce013-07f7-4d2d-a767-a53de9174eaa', '李四', '0', '女'), ('36ae5879-1a79-4692-aa46-a2bc0a6b53e8', '小花', '1', '女'), ('37708dbf-2d8e-4c68-8dbc-95bfa3afcaaf', '张三', '0', '女'), ('39897175-49e0-4a63-b10f-432ee565e61e', '二狗子', '0', '女'), ('3b0a4fd1-fddc-4458-912d-2a7b4a3f3d27', '小花', '0', '女'), ('43377bf7-a4aa-4be9-bedc-a5830c2735b6', '李四', '0', '女'), ('542d2844-7821-461d-b213-151c11ab5d32', '来福', '1', '女'), ('556504be-cacd-4b4e-945c-805bfc5985e6', '傻根', '1', '女'), ('576345e1-5aa6-487f-93bf-d7296777fb6e', '王二麻', '1', '女'), ('5d03733a-aae4-4413-a81f-05a093bebab4', '傻根', '0', '女'), ('5d1291b3-28e2-4f51-9edd-507e7a48a0e1', '张三', '1', '女'), ('63683a39-c6ab-4328-8b77-c2dcbcd83ee3', '王二麻', '1', '女'), ('6573abf3-be49-4557-ab2f-a861f470c5ad', '来福', '1', '女'), ('6919aa82-6a7c-49fa-8618-2a334a4a2f5d', '张三', '0', '女'), ('7cd20aec-a31e-4c4a-b812-61768b1ae6e4', '二狗子', '1', '女'), ('80e880c2-fe0c-4bf5-ac08-5520e3db4dc1', '李四', '1', '女'), ('8bcbf878-f6a9-41dd-adcc-8cded38b7ea1', '赵六', '0', '女'), ('8eb35479-67d5-4a44-84e4-9a2f7fb9f9aa', '王二麻', '1', '女'), ('93bd5b94-7ec1-4a33-9864-10cc26f64bb5', '赵六', '0', '女'), ('9a139000-8aa3-4997-8006-414df69f41aa', '王二麻', '0', '女'), ('a6751c2e-dfb1-4741-afb8-95a12cd9fe77', '二狗子', '1', '女'), ('a8fa74f6-4885-43a9-9e89-7808eea4d5e4', '来福', '0', '女'), ('adce4dfc-986a-4e3a-a3bc-c4d2ff3680c5', '二狗子', '1', '女'), ('bb7b77a8-6c15-43d2-abaa-2d00050737ce', '张三', '1', '女'), ('bc9e8a18-7c6a-4275-a3f0-91aa0507a5df', '赵六', '1', '女'), ('bd67a3b5-e4e1-4fcb-b575-147814fa6f93', '来福', '1', '女'), ('bee2d0cc-4e21-4353-b565-3c082ab9bded', '来福', '0', '女'), ('bf6753d6-2ce4-4a40-aad6-278938e21d00', '赵六', '0', '女'), ('c31ae2ad-294b-43d9-8799-5af4bb2bdd95', '王二麻', '0', '女'), ('d476fb1c-2548-4347-8a8b-853e56db2125', '来福', '1', '女'), ('db0a586d-aae1-469b-98c3-618af202ccc8', '傻根', '0', '女'), ('dbcd4038-4845-4d6a-aa62-08b2a4672780', '李四', '0', '女'), ('de402e9f-e724-4712-aa0c-50c7ccb506c1', '来福', '1', '女'), ('e1a642ae-874a-4fc1-91e4-baa69ee19b24', '二狗子', '0', '女'), ('e60e169b-3be7-490d-8ec9-7359fed5675e', '张三', '0', '女'), ('ec838563-8d78-4f9c-a9ad-c364896d8b8f', '张三', '0', '女'), ('ecfc5c77-6c4d-498f-bda7-044275091dac', '王二麻', '1', '女');
COMMIT;

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`loginName`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`createTime`  datetime NOT NULL ,
`locked`  int(11) NOT NULL DEFAULT 0 ,
`salt`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '散列盐' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `user_id_uindex` (`id`) USING BTREE ,
UNIQUE INDEX `user_loginName_uindex` (`loginName`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户信息表'

;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', 'biling', '4220f605c5dd9f7848fb9101d0a25c88', '毕玲玲', '2018-03-30 00:00:00', '0', '9413e8a066ed72acc7da48d9813fae23'), ('2', 'wanghr', '1a6662fda0b983e863c4ca6d083df9c6', '王海瑞', '2018-03-30 00:00:00', '0', 'ecc04543b6e3a68eaba58a7e1007102a'), ('3', 'guest', '184308e1e05e84ac42c83e88c3a5c511', '游客', '2018-03-30 00:00:00', '0', '0afc0067b1f8276375778dd822a5bb3a');
COMMIT;

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
`id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`userId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`roleId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`userId`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `user_role_id_uindex` (`id`) USING BTREE ,
INDEX `user_role_user_id_fk` (`userId`) USING BTREE ,
INDEX `user_role_role_id_fk` (`roleId`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户角色关系表'

;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES ('1', '1', '1'), ('2', '2', '1'), ('3', '3', '3');
COMMIT;
