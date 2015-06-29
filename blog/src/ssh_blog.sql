/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : ssh_blog

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2015-06-01 14:06:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `native_place` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `decription` text,
  PRIMARY KEY (`info_id`),
  KEY `admin_id` (`admin_id`),
  CONSTRAINT `admininfo_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('5', '1', '佐咛', '浙江宁波', '学院路899号', '<p style=\"font-family: Hiragino Sans GB, 微软雅黑, 黑体, Arial, sans-serif;\">  </p><div><span style=\"color: rgb(34, 34, 34); font-family: Consolas, \'Lucida Console\', monospace; font-size: 12px; white-space: pre-wrap; background-color: rgb(255, 255, 255);\">答案<br></span><span style=\"color: rgb(34, 34, 34); font-family: Consolas, \'Lucida Console\', monospace; font-size: 12px; white-space: pre-wrap; background-color: rgb(255, 255, 255);\">   <br>   人生中有很多答案都在自己的心里，而我们总是向他人索取。——佐咛</span></div><div><span style=\"color: rgb(34, 34, 34); font-family: Consolas, \'Lucida Console\', monospace; font-size: 12px; white-space: pre-wrap; background-color: rgb(255, 255, 255);\">&nbsp;\r\n放<br> <br>   人需要真正静下心来做一件事情，用心去做、与灵魂接触。也许当时的天崩地裂，仅是当下淡淡的一笔。——佐咛\r\n&nbsp;\r\n成长\r\n   <br>   人，要想改变，只有自己才能改变自己。如果你不想因承受痛苦而成长，那么你就要学会自己成长。——佐咛\r\n        </span><br></div>');

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `album_id` int(11) NOT NULL AUTO_INCREMENT,
  `album_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', '建筑');
INSERT INTO `album` VALUES ('2', '生活');
INSERT INTO `album` VALUES ('3', '校园');
INSERT INTO `album` VALUES ('4', '电影');
INSERT INTO `album` VALUES ('5', 'zzz');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `cate_id` int(11) DEFAULT NULL,
  `publish_time` varchar(255) DEFAULT NULL,
  `has_read` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'GitHub上整理的一些工具', '<ul style=\"box-sizing: border-box; margin: 0px 0px 24px 6px; padding-left: 16px; list-style-type: square; color: rgb(68, 68, 67); font-family: Georgia, \'Xin Gothic\', \'Hiragino Sans GB\', \'Droid Sans Fallback\', \'Microsoft YaHei\', sans-serif; font-size: 18px; line-height: 29.1599998474121px; background-color: rgb(255, 255, 255);\"><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>Hacker News：非常棒的针对编程的链接聚合网站</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>Programming reddit：同上</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>MSDN：微软相关的官方技术集中地，主要是文档类</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>infoq：企业级应用，关注软件开发领域</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>OSChina：开源技术社区，开源方面做的不错哦</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>cnblogs，51cto，csdn：常见的技术社区，各有专长</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>stackoverflow：IT技术问答网站</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>GitHub：全球最大的源代码管理平台，很多知名开源项目都在上面，如Linux内核，</sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>OpenStack等免费的it电子书：<a href=\"http://it-ebooks.info/\" target=\"_blank\" style=\"box-sizing: border-box; color: rgb(17, 17, 17); text-decoration: none; word-wrap: break-word; background: transparent;\">http://it-ebooks.info/</a></sup></li><li style=\"box-sizing: border-box; margin-bottom: 0.2em;\"><sup>DevStore:开发者服务商店</sup></li></ul><p style=\"font-family: Hiragino Sans GB, 微软雅黑, 黑体, Arial, sans-serif;\">  </p>', '1', '2015-05-18 20:17:08', null);
INSERT INTO `article` VALUES ('2', '指尖滑过的伤感', '<p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">还记得，那时候的好时光，清晨<span lang=\"EN-US\">5</span>点的冬天，冻的发红的脸颊，在烟雾中晨跑的我们，曾无数次的幻想过程，结果，有无数次的结局，唯独没有现在的离别。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">总是在惋惜中，感叹一句，可惜不是你。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">街道两边的桂花依然一到秋天满街溢香，却没有在树下傻笑的你。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">房子是盖了拆，拆了再新建，一年一度光景。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">花，一到春天，依然娇艳。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">而我，却在这风景中渐渐淡忘了。曾经有过吗<span lang=\"EN-US\">?</span>有那样美好的回忆吗<span lang=\"EN-US\">?</span>或者是美化了吗<span lang=\"EN-US\">?</span>是否真的如此<span lang=\"EN-US\">?<o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">在渐渐退色的记忆中寻找，推敲答案。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">终于，我老了。已经想不起来了。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">或者你在街上，匆匆而过，能想起年轻的我吗<span lang=\"EN-US\">?<o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">如同我曾经的刻骨铭心。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">白发苍苍的你，步履蹒跚的我。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">在世界的不同角落，也许会偶尔在同一时间抬头欣赏头顶的圆月吧。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"font-family:&quot;微软雅黑&quot;,sans-serif\">老了……老了，只念叨这一句。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p class=\"MsoNormal\" style=\"text-indent:21.0pt\">\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<span style=\"font-size:10.5pt;mso-bidi-font-size:11.0pt;font-family:&quot;微软雅黑&quot;,sans-serif;\r\nmso-bidi-font-family:&quot;Times New Roman&quot;;mso-bidi-theme-font:minor-bidi;\r\nmso-ansi-language:EN-US;mso-fareast-language:ZH-CN;mso-bidi-language:AR-SA\">可惜不是你。</span><br></p>', '2', '2015-05-18 20:20:02', null);
INSERT INTO `article` VALUES ('3', '流年的风、吹痛眼角的伤', '<p class=\"MsoNormal\" style=\"text-indent:21.0pt\"><span style=\"mso-bidi-font-size:\r\n10.5pt;font-family:&quot;微软雅黑&quot;,sans-serif;mso-bidi-font-family:Consolas;color:#222222;\r\nbackground:white\">岁月如风，匆忙却千回百转，说不清的世事微澜，看流年终还是那眼角抹不去的潮湿，柔了梦，碎了心，回首处，在岁月静好的那一刻搁浅着希望的缺口，寻觅着一个一个多彩的因子，汇聚成红尘中独守的围城，倚却在年华的深处，徜徉着一片空旷的真实，懂了风月，懂了风尘，直到最后归咎在静谧处的思绪随风而逝，或许青春太短，短到月华下，只剩下孤单的身影，独倚栏杆，或许岁月太长，长到寂静夜，惆怅着所有无法抹去的记忆。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"font-family: Hiragino Sans GB, 微软雅黑, 黑体, Arial, sans-serif;\">  </p>', '2', '2015-05-18 21:12:29', null);

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('9', '第一次拜访', '2015-05-18 20:26:57', '梦里梦外', '111@qq.com');
INSERT INTO `board` VALUES ('10', '晚上好，这里有我的足迹！', '2015-05-18 20:27:21', '佐咛', '111@qq.com');
INSERT INTO `board` VALUES ('11', '哈哈，我是过路人', '2015-05-18 20:27:47', 'Mr.童', '123@qq.com');
INSERT INTO `board` VALUES ('12', '非常不错哦，希望多交流', '2015-05-18 20:28:17', '悦听有声', '111@qq.com');
INSERT INTO `board` VALUES ('13', '网站的模板不错。', '2015-05-20 09:29:47', '奈何', '123@qq.com');
INSERT INTO `board` VALUES ('15', 'fff', '2015-05-20 10:07:29', 'fff', 'ffff');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cate_Id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cate_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '技术');
INSERT INTO `category` VALUES ('2', '情感');
INSERT INTO `category` VALUES ('3', '文学');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `comment_time` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2', '奋斗的青春', '2015-05-18 20:22:21', '木木', '111@qq.com');
INSERT INTO `comment` VALUES ('2', '1', '第一次拜访', '2015-05-18 20:23:29', 'SAM', '123@qq.com');

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `photo_name` varchar(255) DEFAULT NULL,
  `album_id` int(11) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `album_id` (`album_id`),
  CONSTRAINT `photo_ibfk_1` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('1', '39815941_17.jpg', '2', '2015-05-18 20:36:54');
INSERT INTO `photo` VALUES ('2', 'home.jpg', '1', '2015-05-18 20:37:27');
INSERT INTO `photo` VALUES ('4', '39815941_18.jpg', '2', '2015-05-18 21:34:14');
INSERT INTO `photo` VALUES ('5', 'p1674244233.jpg', '2', '2015-05-18 21:34:36');
INSERT INTO `photo` VALUES ('6', '1.jpg', '1', '2015-05-18 21:41:00');
