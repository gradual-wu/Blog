/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : gradual_blog

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-09-11 16:52:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_discuss
-- ----------------------------
DROP TABLE IF EXISTS `article_discuss`;
CREATE TABLE `article_discuss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博文ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `content` tinytext COMMENT '评论内容',
  `nikename` varchar(40) DEFAULT NULL COMMENT '评论人昵称',
  `ip_address` varchar(20) DEFAULT NULL COMMENT '评论人IP地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_discuss
-- ----------------------------

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博文ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `type` varchar(60) DEFAULT NULL COMMENT '类型',
  `img_base64` tinytext COMMENT '类型图标Base64',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES ('1', '2018-08-28 12:56:14', '2018-09-06 12:02:12', '1', 'JAVA', 'http://resource.gradual.top//blog/images/type/java.jpeg');
INSERT INTO `article_type` VALUES ('2', '2018-08-28 14:38:11', '2018-09-06 12:02:14', '1', 'Spring Boot', 'http://resource.gradual.top//blog/images/type/spring-boot.jpg');
INSERT INTO `article_type` VALUES ('3', '2018-08-28 16:47:13', '2018-09-06 12:02:21', '1', 'Spring Cloud', 'http://resource.gradual.top//blog/images/type/spring.jpg');
INSERT INTO `article_type` VALUES ('4', '2018-08-28 17:08:03', '2018-09-06 20:21:31', '1', 'Spring', 'http://resource.gradual.top//blog/images/type/spring.jpg');
INSERT INTO `article_type` VALUES ('5', '2018-08-28 17:08:12', '2018-09-06 20:21:35', '1', 'MyBatis', 'http://resource.gradual.top//blog/images/type/mybatis.jpg');

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博文ID',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `html` text NOT NULL COMMENT '博文',
  `praise` bigint(20) NOT NULL DEFAULT '0' COMMENT '点赞数量',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态(0=正常/1=删除)',
  `title` varchar(100) NOT NULL COMMENT '博文标题',
  `txt` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('143', '2018-09-07 17:34:23', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>0', '0', '1', '0', 'Gradual个人博客.测试0', 'Gradual个人博客 测试 TEXT0');
INSERT INTO `blog_article` VALUES ('144', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>1', '0', '1', '0', 'Gradual个人博客.测试1', 'Gradual个人博客 测试 TEXT1');
INSERT INTO `blog_article` VALUES ('145', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>2', '0', '1', '0', 'Gradual个人博客.测试2', 'Gradual个人博客 测试 TEXT2');
INSERT INTO `blog_article` VALUES ('146', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>3', '0', '1', '0', 'Gradual个人博客.测试3', 'Gradual个人博客 测试 TEXT3');
INSERT INTO `blog_article` VALUES ('147', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>4', '0', '1', '0', 'Gradual个人博客.测试4', 'Gradual个人博客 测试 TEXT4');
INSERT INTO `blog_article` VALUES ('148', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>5', '0', '1', '0', 'Gradual个人博客.测试5', 'Gradual个人博客 测试 TEXT5');
INSERT INTO `blog_article` VALUES ('149', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>6', '0', '1', '0', 'Gradual个人博客.测试6', 'Gradual个人博客 测试 TEXT6');
INSERT INTO `blog_article` VALUES ('150', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>7', '0', '1', '0', 'Gradual个人博客.测试7', 'Gradual个人博客 测试 TEXT7');
INSERT INTO `blog_article` VALUES ('151', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>8', '0', '1', '0', 'Gradual个人博客.测试8', 'Gradual个人博客 测试 TEXT8');
INSERT INTO `blog_article` VALUES ('152', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>9', '0', '1', '0', 'Gradual个人博客.测试9', 'Gradual个人博客 测试 TEXT9');
INSERT INTO `blog_article` VALUES ('153', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>10', '0', '1', '0', 'Gradual个人博客.测试10', 'Gradual个人博客 测试 TEXT10');
INSERT INTO `blog_article` VALUES ('154', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>11', '0', '1', '0', 'Gradual个人博客.测试11', 'Gradual个人博客 测试 TEXT11');
INSERT INTO `blog_article` VALUES ('155', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>12', '0', '1', '0', 'Gradual个人博客.测试12', 'Gradual个人博客 测试 TEXT12');
INSERT INTO `blog_article` VALUES ('156', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>13', '0', '1', '0', 'Gradual个人博客.测试13', 'Gradual个人博客 测试 TEXT13');
INSERT INTO `blog_article` VALUES ('157', '2018-09-07 17:34:24', '2018-09-07 17:34:23', 'Gradual个人博客 测试 HTML<br>14', '0', '1', '0', 'Gradual个人博客.测试14', 'Gradual个人博客 测试 TEXT14');
INSERT INTO `blog_article` VALUES ('158', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>15', '0', '1', '0', 'Gradual个人博客.测试15', 'Gradual个人博客 测试 TEXT15');
INSERT INTO `blog_article` VALUES ('159', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>16', '0', '1', '0', 'Gradual个人博客.测试16', 'Gradual个人博客 测试 TEXT16');
INSERT INTO `blog_article` VALUES ('160', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>17', '0', '1', '0', 'Gradual个人博客.测试17', 'Gradual个人博客 测试 TEXT17');
INSERT INTO `blog_article` VALUES ('161', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>18', '0', '1', '0', 'Gradual个人博客.测试18', 'Gradual个人博客 测试 TEXT18');
INSERT INTO `blog_article` VALUES ('162', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>19', '0', '1', '0', 'Gradual个人博客.测试19', 'Gradual个人博客 测试 TEXT19');
INSERT INTO `blog_article` VALUES ('163', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>20', '0', '1', '0', 'Gradual个人博客.测试20', 'Gradual个人博客 测试 TEXT20');
INSERT INTO `blog_article` VALUES ('164', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>21', '0', '1', '0', 'Gradual个人博客.测试21', 'Gradual个人博客 测试 TEXT21');
INSERT INTO `blog_article` VALUES ('165', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>22', '0', '1', '0', 'Gradual个人博客.测试22', 'Gradual个人博客 测试 TEXT22');
INSERT INTO `blog_article` VALUES ('166', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>23', '0', '1', '0', 'Gradual个人博客.测试23', 'Gradual个人博客 测试 TEXT23');
INSERT INTO `blog_article` VALUES ('167', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>24', '0', '1', '0', 'Gradual个人博客.测试24', 'Gradual个人博客 测试 TEXT24');
INSERT INTO `blog_article` VALUES ('168', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>25', '0', '1', '0', 'Gradual个人博客.测试25', 'Gradual个人博客 测试 TEXT25');
INSERT INTO `blog_article` VALUES ('169', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>26', '0', '1', '0', 'Gradual个人博客.测试26', 'Gradual个人博客 测试 TEXT26');
INSERT INTO `blog_article` VALUES ('170', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>27', '0', '1', '0', 'Gradual个人博客.测试27', 'Gradual个人博客 测试 TEXT27');
INSERT INTO `blog_article` VALUES ('171', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>28', '0', '1', '0', 'Gradual个人博客.测试28', 'Gradual个人博客 测试 TEXT28');
INSERT INTO `blog_article` VALUES ('172', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>29', '0', '1', '0', 'Gradual个人博客.测试29', 'Gradual个人博客 测试 TEXT29');
INSERT INTO `blog_article` VALUES ('173', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>30', '0', '1', '0', 'Gradual个人博客.测试30', 'Gradual个人博客 测试 TEXT30');
INSERT INTO `blog_article` VALUES ('174', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>31', '0', '1', '0', 'Gradual个人博客.测试31', 'Gradual个人博客 测试 TEXT31');
INSERT INTO `blog_article` VALUES ('175', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>32', '0', '1', '0', 'Gradual个人博客.测试32', 'Gradual个人博客 测试 TEXT32');
INSERT INTO `blog_article` VALUES ('176', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>33', '0', '1', '0', 'Gradual个人博客.测试33', 'Gradual个人博客 测试 TEXT33');
INSERT INTO `blog_article` VALUES ('177', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>34', '0', '1', '0', 'Gradual个人博客.测试34', 'Gradual个人博客 测试 TEXT34');
INSERT INTO `blog_article` VALUES ('178', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>35', '0', '1', '0', 'Gradual个人博客.测试35', 'Gradual个人博客 测试 TEXT35');
INSERT INTO `blog_article` VALUES ('179', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>36', '0', '1', '0', 'Gradual个人博客.测试36', 'Gradual个人博客 测试 TEXT36');
INSERT INTO `blog_article` VALUES ('180', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>37', '0', '1', '0', 'Gradual个人博客.测试37', 'Gradual个人博客 测试 TEXT37');
INSERT INTO `blog_article` VALUES ('181', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>38', '0', '1', '0', 'Gradual个人博客.测试38', 'Gradual个人博客 测试 TEXT38');
INSERT INTO `blog_article` VALUES ('182', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>39', '0', '1', '0', 'Gradual个人博客.测试39', 'Gradual个人博客 测试 TEXT39');
INSERT INTO `blog_article` VALUES ('183', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>40', '0', '1', '0', 'Gradual个人博客.测试40', 'Gradual个人博客 测试 TEXT40');
INSERT INTO `blog_article` VALUES ('184', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>41', '0', '1', '0', 'Gradual个人博客.测试41', 'Gradual个人博客 测试 TEXT41');
INSERT INTO `blog_article` VALUES ('185', '2018-09-07 17:34:24', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>42', '0', '1', '0', 'Gradual个人博客.测试42', 'Gradual个人博客 测试 TEXT42');
INSERT INTO `blog_article` VALUES ('186', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>43', '0', '1', '0', 'Gradual个人博客.测试43', 'Gradual个人博客 测试 TEXT43');
INSERT INTO `blog_article` VALUES ('187', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>44', '0', '1', '0', 'Gradual个人博客.测试44', 'Gradual个人博客 测试 TEXT44');
INSERT INTO `blog_article` VALUES ('188', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>45', '0', '1', '0', 'Gradual个人博客.测试45', 'Gradual个人博客 测试 TEXT45');
INSERT INTO `blog_article` VALUES ('189', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>46', '0', '1', '0', 'Gradual个人博客.测试46', 'Gradual个人博客 测试 TEXT46');
INSERT INTO `blog_article` VALUES ('190', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>47', '0', '1', '0', 'Gradual个人博客.测试47', 'Gradual个人博客 测试 TEXT47');
INSERT INTO `blog_article` VALUES ('191', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>48', '0', '1', '0', 'Gradual个人博客.测试48', 'Gradual个人博客 测试 TEXT48');
INSERT INTO `blog_article` VALUES ('192', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>49', '0', '1', '0', 'Gradual个人博客.测试49', 'Gradual个人博客 测试 TEXT49');
INSERT INTO `blog_article` VALUES ('193', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>50', '0', '1', '0', 'Gradual个人博客.测试50', 'Gradual个人博客 测试 TEXT50');
INSERT INTO `blog_article` VALUES ('194', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>51', '0', '1', '0', 'Gradual个人博客.测试51', 'Gradual个人博客 测试 TEXT51');
INSERT INTO `blog_article` VALUES ('195', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>52', '0', '1', '0', 'Gradual个人博客.测试52', 'Gradual个人博客 测试 TEXT52');
INSERT INTO `blog_article` VALUES ('196', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>53', '0', '1', '0', 'Gradual个人博客.测试53', 'Gradual个人博客 测试 TEXT53');
INSERT INTO `blog_article` VALUES ('197', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>54', '0', '1', '0', 'Gradual个人博客.测试54', 'Gradual个人博客 测试 TEXT54');
INSERT INTO `blog_article` VALUES ('198', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>55', '0', '1', '0', 'Gradual个人博客.测试55', 'Gradual个人博客 测试 TEXT55');
INSERT INTO `blog_article` VALUES ('199', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>56', '0', '1', '0', 'Gradual个人博客.测试56', 'Gradual个人博客 测试 TEXT56');
INSERT INTO `blog_article` VALUES ('200', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>57', '0', '1', '0', 'Gradual个人博客.测试57', 'Gradual个人博客 测试 TEXT57');
INSERT INTO `blog_article` VALUES ('201', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>58', '0', '1', '0', 'Gradual个人博客.测试58', 'Gradual个人博客 测试 TEXT58');
INSERT INTO `blog_article` VALUES ('202', '2018-09-07 17:34:25', '2018-09-07 17:34:24', 'Gradual个人博客 测试 HTML<br>59', '0', '1', '0', 'Gradual个人博客.测试59', 'Gradual个人博客 测试 TEXT59');

-- ----------------------------
-- Table structure for type_article_nexus
-- ----------------------------
DROP TABLE IF EXISTS `type_article_nexus`;
CREATE TABLE `type_article_nexus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `type_id` bigint(20) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=408 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_article_nexus
-- ----------------------------
INSERT INTO `type_article_nexus` VALUES ('288', '2018-09-07 17:34:23', '2018-09-07 17:34:23', '3', '143');
INSERT INTO `type_article_nexus` VALUES ('289', '2018-09-07 17:34:23', '2018-09-07 17:34:23', '3', '143');
INSERT INTO `type_article_nexus` VALUES ('290', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '4', '144');
INSERT INTO `type_article_nexus` VALUES ('291', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '144');
INSERT INTO `type_article_nexus` VALUES ('292', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '145');
INSERT INTO `type_article_nexus` VALUES ('293', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '145');
INSERT INTO `type_article_nexus` VALUES ('294', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '146');
INSERT INTO `type_article_nexus` VALUES ('295', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '146');
INSERT INTO `type_article_nexus` VALUES ('296', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '147');
INSERT INTO `type_article_nexus` VALUES ('297', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '147');
INSERT INTO `type_article_nexus` VALUES ('298', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '2', '148');
INSERT INTO `type_article_nexus` VALUES ('299', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '148');
INSERT INTO `type_article_nexus` VALUES ('300', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '2', '149');
INSERT INTO `type_article_nexus` VALUES ('301', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '149');
INSERT INTO `type_article_nexus` VALUES ('302', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '3', '150');
INSERT INTO `type_article_nexus` VALUES ('303', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '3', '150');
INSERT INTO `type_article_nexus` VALUES ('304', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '4', '151');
INSERT INTO `type_article_nexus` VALUES ('305', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '2', '151');
INSERT INTO `type_article_nexus` VALUES ('306', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '4', '152');
INSERT INTO `type_article_nexus` VALUES ('307', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '3', '152');
INSERT INTO `type_article_nexus` VALUES ('308', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '4', '153');
INSERT INTO `type_article_nexus` VALUES ('309', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '2', '153');
INSERT INTO `type_article_nexus` VALUES ('310', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '2', '154');
INSERT INTO `type_article_nexus` VALUES ('311', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '154');
INSERT INTO `type_article_nexus` VALUES ('312', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '155');
INSERT INTO `type_article_nexus` VALUES ('313', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '155');
INSERT INTO `type_article_nexus` VALUES ('314', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '5', '156');
INSERT INTO `type_article_nexus` VALUES ('315', '2018-09-07 17:34:24', '2018-09-07 17:34:23', '1', '156');
INSERT INTO `type_article_nexus` VALUES ('316', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '157');
INSERT INTO `type_article_nexus` VALUES ('317', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '157');
INSERT INTO `type_article_nexus` VALUES ('318', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '158');
INSERT INTO `type_article_nexus` VALUES ('319', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '158');
INSERT INTO `type_article_nexus` VALUES ('320', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '159');
INSERT INTO `type_article_nexus` VALUES ('321', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '159');
INSERT INTO `type_article_nexus` VALUES ('322', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '160');
INSERT INTO `type_article_nexus` VALUES ('323', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '160');
INSERT INTO `type_article_nexus` VALUES ('324', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '161');
INSERT INTO `type_article_nexus` VALUES ('325', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '161');
INSERT INTO `type_article_nexus` VALUES ('326', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '162');
INSERT INTO `type_article_nexus` VALUES ('327', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '162');
INSERT INTO `type_article_nexus` VALUES ('328', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '163');
INSERT INTO `type_article_nexus` VALUES ('329', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '163');
INSERT INTO `type_article_nexus` VALUES ('330', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '164');
INSERT INTO `type_article_nexus` VALUES ('331', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '164');
INSERT INTO `type_article_nexus` VALUES ('332', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '165');
INSERT INTO `type_article_nexus` VALUES ('333', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '165');
INSERT INTO `type_article_nexus` VALUES ('334', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '166');
INSERT INTO `type_article_nexus` VALUES ('335', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '166');
INSERT INTO `type_article_nexus` VALUES ('336', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '167');
INSERT INTO `type_article_nexus` VALUES ('337', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '167');
INSERT INTO `type_article_nexus` VALUES ('338', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '168');
INSERT INTO `type_article_nexus` VALUES ('339', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '168');
INSERT INTO `type_article_nexus` VALUES ('340', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '169');
INSERT INTO `type_article_nexus` VALUES ('341', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '169');
INSERT INTO `type_article_nexus` VALUES ('342', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '170');
INSERT INTO `type_article_nexus` VALUES ('343', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '170');
INSERT INTO `type_article_nexus` VALUES ('344', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '171');
INSERT INTO `type_article_nexus` VALUES ('345', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '171');
INSERT INTO `type_article_nexus` VALUES ('346', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '172');
INSERT INTO `type_article_nexus` VALUES ('347', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '172');
INSERT INTO `type_article_nexus` VALUES ('348', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '173');
INSERT INTO `type_article_nexus` VALUES ('349', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '173');
INSERT INTO `type_article_nexus` VALUES ('350', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '174');
INSERT INTO `type_article_nexus` VALUES ('351', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '5', '174');
INSERT INTO `type_article_nexus` VALUES ('352', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '175');
INSERT INTO `type_article_nexus` VALUES ('353', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '175');
INSERT INTO `type_article_nexus` VALUES ('354', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '176');
INSERT INTO `type_article_nexus` VALUES ('355', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '176');
INSERT INTO `type_article_nexus` VALUES ('356', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '177');
INSERT INTO `type_article_nexus` VALUES ('357', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '177');
INSERT INTO `type_article_nexus` VALUES ('358', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '178');
INSERT INTO `type_article_nexus` VALUES ('359', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '178');
INSERT INTO `type_article_nexus` VALUES ('360', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '179');
INSERT INTO `type_article_nexus` VALUES ('361', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '179');
INSERT INTO `type_article_nexus` VALUES ('362', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '180');
INSERT INTO `type_article_nexus` VALUES ('363', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '180');
INSERT INTO `type_article_nexus` VALUES ('364', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '181');
INSERT INTO `type_article_nexus` VALUES ('365', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '181');
INSERT INTO `type_article_nexus` VALUES ('366', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '182');
INSERT INTO `type_article_nexus` VALUES ('367', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '182');
INSERT INTO `type_article_nexus` VALUES ('368', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '183');
INSERT INTO `type_article_nexus` VALUES ('369', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '2', '183');
INSERT INTO `type_article_nexus` VALUES ('370', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '4', '184');
INSERT INTO `type_article_nexus` VALUES ('371', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '184');
INSERT INTO `type_article_nexus` VALUES ('372', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '1', '185');
INSERT INTO `type_article_nexus` VALUES ('373', '2018-09-07 17:34:24', '2018-09-07 17:34:24', '3', '185');
INSERT INTO `type_article_nexus` VALUES ('374', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '186');
INSERT INTO `type_article_nexus` VALUES ('375', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '186');
INSERT INTO `type_article_nexus` VALUES ('376', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '187');
INSERT INTO `type_article_nexus` VALUES ('377', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '187');
INSERT INTO `type_article_nexus` VALUES ('378', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '188');
INSERT INTO `type_article_nexus` VALUES ('379', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '188');
INSERT INTO `type_article_nexus` VALUES ('380', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '189');
INSERT INTO `type_article_nexus` VALUES ('381', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '189');
INSERT INTO `type_article_nexus` VALUES ('382', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '190');
INSERT INTO `type_article_nexus` VALUES ('383', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '190');
INSERT INTO `type_article_nexus` VALUES ('384', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '3', '191');
INSERT INTO `type_article_nexus` VALUES ('385', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '191');
INSERT INTO `type_article_nexus` VALUES ('386', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '192');
INSERT INTO `type_article_nexus` VALUES ('387', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '3', '192');
INSERT INTO `type_article_nexus` VALUES ('388', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '193');
INSERT INTO `type_article_nexus` VALUES ('389', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '1', '193');
INSERT INTO `type_article_nexus` VALUES ('390', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '194');
INSERT INTO `type_article_nexus` VALUES ('391', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '194');
INSERT INTO `type_article_nexus` VALUES ('392', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '195');
INSERT INTO `type_article_nexus` VALUES ('393', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '3', '195');
INSERT INTO `type_article_nexus` VALUES ('394', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '1', '196');
INSERT INTO `type_article_nexus` VALUES ('395', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '196');
INSERT INTO `type_article_nexus` VALUES ('396', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '197');
INSERT INTO `type_article_nexus` VALUES ('397', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '197');
INSERT INTO `type_article_nexus` VALUES ('398', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '198');
INSERT INTO `type_article_nexus` VALUES ('399', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '2', '198');
INSERT INTO `type_article_nexus` VALUES ('400', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '3', '199');
INSERT INTO `type_article_nexus` VALUES ('401', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '5', '199');
INSERT INTO `type_article_nexus` VALUES ('402', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '1', '200');
INSERT INTO `type_article_nexus` VALUES ('403', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '200');
INSERT INTO `type_article_nexus` VALUES ('404', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '201');
INSERT INTO `type_article_nexus` VALUES ('405', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '1', '201');
INSERT INTO `type_article_nexus` VALUES ('406', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '4', '202');
INSERT INTO `type_article_nexus` VALUES ('407', '2018-09-07 17:34:25', '2018-09-07 17:34:24', '1', '202');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `username` varchar(40) DEFAULT NULL COMMENT '用户名',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `status` int(11) DEFAULT '0' COMMENT '用户状态(0=正常/1=封禁)',
  `role` int(11) DEFAULT '0' COMMENT '用户角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '2018-08-28 12:00:30', '2018-08-28 12:00:30', 'gradual', 'I/xAqxzk5N9uDePpTLBpzw==', '0', '0');
