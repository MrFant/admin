/*
Navicat MySQL Data Transfer

Source Server         : blog
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : xgwebdb

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-07-11 11:47:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `authority` VALUES ('2', 'ROLE_USER');
INSERT INTO `authority` VALUES ('3', 'ROLE_WAITER');

-- ----------------------------
-- Table structure for `biyesheng`
-- ----------------------------
DROP TABLE IF EXISTS `biyesheng`;
CREATE TABLE `biyesheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs7hj3mgo2ktqfog9yc2cbn46y` (`publisher`),
  KEY `FKsbrifhlb68v4cyk0ivx8nh4ug` (`update_user`),
  CONSTRAINT `FKs7hj3mgo2ktqfog9yc2cbn46y` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`),
  CONSTRAINT `FKsbrifhlb68v4cyk0ivx8nh4ug` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biyesheng
-- ----------------------------

-- ----------------------------
-- Table structure for `dangjian`
-- ----------------------------
DROP TABLE IF EXISTS `dangjian`;
CREATE TABLE `dangjian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs9evqc02j1tvxnwwq3mdoxlc` (`publisher`),
  KEY `FKdhhant0w3oj0ea67t03uad7k5` (`update_user`),
  CONSTRAINT `FKdhhant0w3oj0ea67t03uad7k5` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKs9evqc02j1tvxnwwq3mdoxlc` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dangjian
-- ----------------------------

-- ----------------------------
-- Table structure for `dongtai`
-- ----------------------------
DROP TABLE IF EXISTS `dongtai`;
CREATE TABLE `dongtai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1xuxluk1txxd6bs0rs95tcbng` (`publisher`),
  KEY `FKoxfrnthpr6gdebdxhip15q83v` (`update_user`),
  CONSTRAINT `FK1xuxluk1txxd6bs0rs95tcbng` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`),
  CONSTRAINT `FKoxfrnthpr6gdebdxhip15q83v` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dongtai
-- ----------------------------

-- ----------------------------
-- Table structure for `gaikuang`
-- ----------------------------
DROP TABLE IF EXISTS `gaikuang`;
CREATE TABLE `gaikuang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKksu75ktnx2ark6vgtdj68ttos` (`publisher`),
  KEY `FK2b17wrkgx6sog90m89ncpf88o` (`update_user`),
  CONSTRAINT `FK2b17wrkgx6sog90m89ncpf88o` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKksu75ktnx2ark6vgtdj68ttos` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gaikuang
-- ----------------------------

-- ----------------------------
-- Table structure for `hezuo`
-- ----------------------------
DROP TABLE IF EXISTS `hezuo`;
CREATE TABLE `hezuo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKro2coh26xfh3nuurrrutqrhwd` (`publisher`),
  KEY `FKktcdbj4fy936xluud1h6c9nfl` (`update_user`),
  CONSTRAINT `FKktcdbj4fy936xluud1h6c9nfl` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKro2coh26xfh3nuurrrutqrhwd` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hezuo
-- ----------------------------

-- ----------------------------
-- Table structure for `jiaoyan`
-- ----------------------------
DROP TABLE IF EXISTS `jiaoyan`;
CREATE TABLE `jiaoyan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoaoymbftbi352k427mk43q9hs` (`publisher`),
  KEY `FKj5mo8ocoiy4dl1e2i5k9sfkpe` (`update_user`),
  CONSTRAINT `FKj5mo8ocoiy4dl1e2i5k9sfkpe` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKoaoymbftbi352k427mk43q9hs` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jiaoyan
-- ----------------------------
INSERT INTO `jiaoyan` VALUES ('1', '<h1>\r\n	哈哈哈哈哈哈哈哈哈哈哈哈\r\n</h1>\r\n<div id=\"SL_balloon_obj\" alt=\"0\" style=\"display:block;\">\r\n	<div id=\"SL_button\" class=\"SL_ImTranslatorLogo\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/imtranslator-s.png&quot;display:none;opacity:1;\">\r\n	</div>\r\n	<div id=\"SL_shadow_translation_result2\" style=\"display:none;\">\r\n	</div>\r\n	<div id=\"SL_shadow_translator\" style=\"display:none;\">\r\n		<div id=\"SL_planshet\">\r\n			<div id=\"SL_arrow_up\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/up.png&quot;\">\r\n			</div>\r\n			<div id=\"SL_Bproviders\">\r\n				<div class=\"SL_BL_LABLE_ON\" title=\"Google\" id=\"SL_P0\">\r\n					G\r\n				</div>\r\n				<div class=\"SL_BL_LABLE_ON\" title=\"Microsoft\" id=\"SL_P1\">\r\n					M\r\n				</div>\r\n				<div class=\"SL_BL_LABLE_ON\" title=\"Translator\" id=\"SL_P2\">\r\n					T\r\n				</div>\r\n			</div>\r\n			<div id=\"SL_alert_bbl\" style=\"display:none;\">\r\n				<div id=\"SLHKclose\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/delete.png&quot;\">\r\n				</div>\r\n				<div id=\"SL_alert_cont\">\r\n				</div>\r\n			</div>\r\n			<div id=\"SL_TB\">\r\n				<table id=\"SL_tables\" cellspacing=\"1\">\r\n					<tr>\r\n						<td class=\"SL_td\" width=\"10%\" align=\"right\">\r\n							<input id=\"SL_locer\" type=\"checkbox\" title=\"锁定语言\" />\r\n						</td>\r\n						<td class=\"SL_td\" width=\"20%\" align=\"left\">\r\n							<select id=\"SL_lng_from\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/select.png&quot;\"><option value=\"auto\">检测语言</option><option value=\"eo\">世界语</option><option value=\"zh-CN\">中文简体</option><option value=\"zh-TW\">中文繁体</option><option value=\"da\">丹麦语</option><option value=\"uk\">乌克兰语</option><option value=\"uz\">乌兹别克语</option><option value=\"ur\">乌尔都语</option><option value=\"hy\">亚美尼亚语</option><option value=\"ig\">伊博语</option><option value=\"ru\">俄语</option><option value=\"bg\">保加利亚语</option><option value=\"si\">僧伽罗语</option><option value=\"hr\">克罗地亚语</option><option value=\"is\">冰岛语</option><option value=\"gl\">加利西亚语</option><option value=\"ca\">加泰罗尼亚语</option><option value=\"hu\">匈牙利语</option><option value=\"zu\">南非祖鲁语</option><option value=\"kn\">卡纳达语</option><option value=\"hi\">印地语</option><option value=\"su\">印尼巽他语</option><option value=\"jw\">印尼爪哇语</option><option value=\"id\">印尼语</option><option value=\"gu\">古吉拉特语</option><option value=\"kk\">哈萨克语</option><option value=\"tr\">土耳其语</option><option value=\"tg\">塔吉克语</option><option value=\"sr\">塞尔维亚语</option><option value=\"st\">塞索托语</option><option value=\"cy\">威尔士语</option><option value=\"bn\">孟加拉语</option><option value=\"ceb\">宿务语</option><option value=\"ne\">尼泊尔语</option><option value=\"eu\">巴斯克语</option><option value=\"af\">布尔语(南非荷兰语)</option><option value=\"iw\">希伯来语</option><option value=\"el\">希腊语</option><option value=\"de\">德语</option><option value=\"it\">意大利语</option><option value=\"yi\">意第绪语</option><option value=\"la\">拉丁语</option><option value=\"lv\">拉脱维亚语</option><option value=\"no\">挪威语</option><option value=\"cs\">捷克语</option><option value=\"sk\">斯洛伐克语</option><option value=\"sl\">斯洛文尼亚语</option><option value=\"sw\">斯瓦希里语</option><option value=\"pa\">旁遮普语</option><option value=\"ja\">日语</option><option value=\"ka\">格鲁吉亚语</option><option value=\"mi\">毛利语</option><option value=\"fr\">法语</option><option value=\"pl\">波兰语</option><option value=\"bs\">波斯尼亚语</option><option value=\"fa\">波斯语</option><option value=\"te\">泰卢固语</option><option value=\"ta\">泰米尔语</option><option value=\"th\">泰语</option><option value=\"ht\">海地克里奥尔语</option><option value=\"ga\">爱尔兰语</option><option value=\"et\">爱沙尼亚语</option><option value=\"sv\">瑞典语</option><option value=\"be\">白俄罗斯语</option><option value=\"lt\">立陶宛语</option><option value=\"so\">索马里语</option><option value=\"yo\">约鲁巴语</option><option value=\"my\">缅甸语</option><option value=\"ro\">罗马尼亚语</option><option value=\"lo\">老挝语</option><option value=\"fi\">芬兰语</option><option value=\"hmn\">苗语</option><option value=\"en\">英语</option><option value=\"nl\">荷兰语</option><option value=\"tl\">菲律宾语</option><option value=\"pt\">葡萄牙语</option><option value=\"mn\">蒙古语</option><option value=\"es\">西班牙语</option><option value=\"ha\">豪萨语</option><option value=\"vi\">越南语</option><option value=\"az\">阿塞拜疆语</option><option value=\"sq\">阿尔巴尼亚语</option><option value=\"ar\">阿拉伯语</option><option value=\"ko\">韩语</option><option value=\"mk\">马其顿语</option><option value=\"mg\">马尔加什语</option><option value=\"mr\">马拉地语</option><option value=\"ml\">马拉雅拉姆语</option><option value=\"ms\">马来语</option><option value=\"mt\">马耳他语</option><option value=\"km\">高棉语</option><option value=\"ny\">齐切瓦语</option></select>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"3\" align=\"center\">\r\n							<div id=\"SL_switch_b\" title=\"切换语言\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/switchb.png&quot;\">\r\n							</div>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"20%\" align=\"left\">\r\n							<select id=\"SL_lng_to\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/select.png&quot;\"><option value=\"eo\">世界语</option><option selected=\"selected\" value=\"zh-CN\">中文简体</option><option value=\"zh-TW\">中文繁体</option><option value=\"da\">丹麦语</option><option value=\"uk\">乌克兰语</option><option value=\"uz\">乌兹别克语</option><option value=\"ur\">乌尔都语</option><option value=\"hy\">亚美尼亚语</option><option value=\"ig\">伊博语</option><option value=\"ru\">俄语</option><option value=\"bg\">保加利亚语</option><option value=\"si\">僧伽罗语</option><option value=\"hr\">克罗地亚语</option><option value=\"is\">冰岛语</option><option value=\"gl\">加利西亚语</option><option value=\"ca\">加泰罗尼亚语</option><option value=\"hu\">匈牙利语</option><option value=\"zu\">南非祖鲁语</option><option value=\"kn\">卡纳达语</option><option value=\"hi\">印地语</option><option value=\"su\">印尼巽他语</option><option value=\"jw\">印尼爪哇语</option><option value=\"id\">印尼语</option><option value=\"gu\">古吉拉特语</option><option value=\"kk\">哈萨克语</option><option value=\"tr\">土耳其语</option><option value=\"tg\">塔吉克语</option><option value=\"sr\">塞尔维亚语</option><option value=\"st\">塞索托语</option><option value=\"cy\">威尔士语</option><option value=\"bn\">孟加拉语</option><option value=\"ceb\">宿务语</option><option value=\"ne\">尼泊尔语</option><option value=\"eu\">巴斯克语</option><option value=\"af\">布尔语(南非荷兰语)</option><option value=\"iw\">希伯来语</option><option value=\"el\">希腊语</option><option value=\"de\">德语</option><option value=\"it\">意大利语</option><option value=\"yi\">意第绪语</option><option value=\"la\">拉丁语</option><option value=\"lv\">拉脱维亚语</option><option value=\"no\">挪威语</option><option value=\"cs\">捷克语</option><option value=\"sk\">斯洛伐克语</option><option value=\"sl\">斯洛文尼亚语</option><option value=\"sw\">斯瓦希里语</option><option value=\"pa\">旁遮普语</option><option value=\"ja\">日语</option><option value=\"ka\">格鲁吉亚语</option><option value=\"mi\">毛利语</option><option value=\"fr\">法语</option><option value=\"pl\">波兰语</option><option value=\"bs\">波斯尼亚语</option><option value=\"fa\">波斯语</option><option value=\"te\">泰卢固语</option><option value=\"ta\">泰米尔语</option><option value=\"th\">泰语</option><option value=\"ht\">海地克里奥尔语</option><option value=\"ga\">爱尔兰语</option><option value=\"et\">爱沙尼亚语</option><option value=\"sv\">瑞典语</option><option value=\"be\">白俄罗斯语</option><option value=\"lt\">立陶宛语</option><option value=\"so\">索马里语</option><option value=\"yo\">约鲁巴语</option><option value=\"my\">缅甸语</option><option value=\"ro\">罗马尼亚语</option><option value=\"lo\">老挝语</option><option value=\"fi\">芬兰语</option><option value=\"hmn\">苗语</option><option value=\"en\">英语</option><option value=\"nl\">荷兰语</option><option value=\"tl\">菲律宾语</option><option value=\"pt\">葡萄牙语</option><option value=\"mn\">蒙古语</option><option value=\"es\">西班牙语</option><option value=\"ha\">豪萨语</option><option value=\"vi\">越南语</option><option value=\"az\">阿塞拜疆语</option><option value=\"sq\">阿尔巴尼亚语</option><option value=\"ar\">阿拉伯语</option><option value=\"ko\">韩语</option><option value=\"mk\">马其顿语</option><option value=\"mg\">马尔加什语</option><option value=\"mr\">马拉地语</option><option value=\"ml\">马拉雅拉姆语</option><option value=\"ms\">马来语</option><option value=\"mt\">马耳他语</option><option value=\"km\">高棉语</option><option value=\"ny\">齐切瓦语</option></select>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"5%\" align=\"center\">\r\n						</td>\r\n						<td class=\"SL_td\" width=\"8%\" align=\"center\">\r\n							<div id=\"SL_TTS_voice\" title=\"undefined\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/ttsvoice.png&quot;\">\r\n							</div>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"8%\" align=\"center\">\r\n							<div id=\"SL_copy\" title=\"复制译文\" class=\"SL_copy\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/copy.png&quot;\">\r\n							</div>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"8%\" align=\"center\">\r\n							<div id=\"SL_bbl_font_patch\">\r\n							</div>\r\n							<div id=\"SL_bbl_font\" title=\"字体大小\" class=\"SL_bbl_font\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/font.png&quot;\">\r\n							</div>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"8%\" align=\"center\">\r\n							<div id=\"SL_bbl_help\" title=\"帮助\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/bhelp.png&quot;\">\r\n							</div>\r\n						</td>\r\n						<td class=\"SL_td\" width=\"15%\" align=\"right\">\r\n							<div id=\"SL_pin\" class=\"SL_pin_off\" title=\"固定弹出窗口\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/pin-on.png&quot;\">\r\n							</div>\r\n						</td>\r\n					</tr>\r\n				</table>\r\n			</div>\r\n		</div>\r\n		<div id=\"SL_shadow_translation_result\" style=\"visibility:visible;\">\r\n		</div>\r\n		<div id=\"SL_loading\" class=\"SL_loading\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/loading.gif&quot;\">\r\n		</div>\r\n		<div id=\"SL_player2\">\r\n		</div>\r\n		<div id=\"SL_alert100\">\r\n			文本转语音功能仅限200个字符\r\n		</div>\r\n		<div id=\"SL_Balloon_options\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/bg3.png&quot;\">\r\n			<div id=\"SL_arrow_down\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/down.png&quot;\">\r\n			</div>\r\n			<table id=\"SL_tbl_opt\" width=\"100%\">\r\n				<tr>\r\n					<td width=\"5%\" align=\"center\">\r\n						<input id=\"SL_BBL_locer\" type=\"checkbox\" checked=\"checked\" title=\"显示翻译器的按钮 3 秒\" />\r\n					</td>\r\n					<td width=\"5%\" align=\"left\">\r\n						<div id=\"SL_BBL_IMG\" title=\"显示翻译器的按钮 3 秒\" style=\"background:url(&quot;chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/img/util/bbl-logo.png&quot;\">\r\n						</div>\r\n					</td>\r\n					<td width=\"70%\" align=\"center\">\r\n						<a href=\"chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/html/options/options.html?bbl\" target=\"_blank\" class=\"SL_options\" title=\"显示选项\">选项</a> : <a href=\"chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/html/options/options.html?hist\" target=\"_blank\" class=\"SL_options\" title=\"翻译历史记录\">历史</a> : <a href=\"chrome-extension://noaijdpnepcgjemiklgfkcfbkokogabh/content/html/options/options.html?feed\" target=\"_blank\" class=\"SL_options\" title=\"反馈\">反馈</a> : <a href=\"https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&amp;hosted_button_id=GD9D8CPW8HFA2\" target=\"_blank\" class=\"SL_options\" title=\"作出一点点贡献\">Donate</a>\r\n					</td>\r\n					<td width=\"15%\" align=\"right\">\r\n						<span id=\"SL_Balloon_Close\" title=\"关闭\">关闭</span>\r\n					</td>\r\n				</tr>\r\n			</table>\r\n		</div>\r\n	</div>\r\n</div>', '31', '2018-07-11', '就要放假了', 'jiaoxue', '2018-07-11', '1', '1');

-- ----------------------------
-- Table structure for `jiuye`
-- ----------------------------
DROP TABLE IF EXISTS `jiuye`;
CREATE TABLE `jiuye` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsn4wamsgbl3ap96aqn2qs0gc7` (`publisher`),
  KEY `FKdmtxvrjat147k3qbp1k0kdd8r` (`update_user`),
  CONSTRAINT `FKdmtxvrjat147k3qbp1k0kdd8r` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKsn4wamsgbl3ap96aqn2qs0gc7` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jiuye
-- ----------------------------

-- ----------------------------
-- Table structure for `lianjie`
-- ----------------------------
DROP TABLE IF EXISTS `lianjie`;
CREATE TABLE `lianjie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3nbdoase2wok247cd6oldwv8w` (`publisher`),
  KEY `FKbj4l5o0hfugqet8rmcj6lecth` (`update_user`),
  CONSTRAINT `FK3nbdoase2wok247cd6oldwv8w` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`),
  CONSTRAINT `FKbj4l5o0hfugqet8rmcj6lecth` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lianjie
-- ----------------------------

-- ----------------------------
-- Table structure for `search`
-- ----------------------------
DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of search
-- ----------------------------

-- ----------------------------
-- Table structure for `tongzhi`
-- ----------------------------
DROP TABLE IF EXISTS `tongzhi`;
CREATE TABLE `tongzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9d51ws1w70x4t85hcd71q3ho2` (`publisher`),
  KEY `FKp8lj5at13vllainqvnmqtv5pf` (`update_user`),
  CONSTRAINT `FK9d51ws1w70x4t85hcd71q3ho2` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`),
  CONSTRAINT `FKp8lj5at13vllainqvnmqtv5pf` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tongzhi
-- ----------------------------

-- ----------------------------
-- Table structure for `tuanxue`
-- ----------------------------
DROP TABLE IF EXISTS `tuanxue`;
CREATE TABLE `tuanxue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq1gfuf8ubkr1qnuqwsvvn1j69` (`publisher`),
  KEY `FK5cahesbrm76upeub5p7s1gqnh` (`update_user`),
  CONSTRAINT `FK5cahesbrm76upeub5p7s1gqnh` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKq1gfuf8ubkr1qnuqwsvvn1j69` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuanxue
-- ----------------------------

-- ----------------------------
-- Table structure for `tupian`
-- ----------------------------
DROP TABLE IF EXISTS `tupian`;
CREATE TABLE `tupian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `hit` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `update_time` date DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmqbbwikjy6yl3gff9y9plvjy5` (`publisher`),
  KEY `FK8k9ok6lvjcp41t8vjr2ljrcb5` (`update_user`),
  CONSTRAINT `FK8k9ok6lvjcp41t8vjr2ljrcb5` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKmqbbwikjy6yl3gff9y9plvjy5` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tupian
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ygtq@haibusiness.com', '羽过天晴', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '12345678', 'admin');
INSERT INTO `user` VALUES ('2', 'zhangsan@haibusiness.com', '张三', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '87654321', 'test');

-- ----------------------------
-- Table structure for `user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  KEY `FKpqlsjpkybgos9w2svcri7j8xy` (`user_id`),
  CONSTRAINT `FKgvxjs381k6f48d5d2yi11uh89` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKpqlsjpkybgos9w2svcri7j8xy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('1', '1');
INSERT INTO `user_authority` VALUES ('2', '2');

-- ----------------------------
-- Table structure for `xiazai`
-- ----------------------------
DROP TABLE IF EXISTS `xiazai`;
CREATE TABLE `xiazai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `publish_time` date DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `update_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkhoiqf310dh3re1mvyh3ioej6` (`publisher`),
  KEY `FKtovauwsdqbp01h60ufbs1076f` (`update_user`),
  CONSTRAINT `FKkhoiqf310dh3re1mvyh3ioej6` FOREIGN KEY (`publisher`) REFERENCES `user` (`id`),
  CONSTRAINT `FKtovauwsdqbp01h60ufbs1076f` FOREIGN KEY (`update_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xiazai
-- ----------------------------
