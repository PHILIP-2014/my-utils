CREATE TABLE `agenda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日历ID',
  `uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者ID',
  `title` varchar(2000) DEFAULT '' COMMENT '日历标题',
  `description` text COMMENT '详细日程描述',
  `gmt_start` datetime DEFAULT NULL COMMENT '开始时间',
  `gmt_end` datetime DEFAULT NULL COMMENT '结束时间',
  `all_day` tinyint(1) DEFAULT '0' COMMENT '整天\n默认0：不是整天\n1：整天',
  `is_public` varchar(5) DEFAULT NULL COMMENT '公开\n0：不公开（默认）\n1：公开',
  `color` varchar(45) DEFAULT '' COMMENT '颜色标记',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_cid` (`cid`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户工作日历';

CREATE TABLE `agenda_remember` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程提醒ID',
  `aid` bigint(20) NOT NULL DEFAULT '0' COMMENT '日历ID',
  `uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者ID',
  `notify_type` int(4) NOT NULL DEFAULT '0' COMMENT '提醒方式\n默认0：会话提醒\n1：Email（使用用户认证过的Email提醒）\n2：桌面提醒\n3：SMS',
  `gmt_notify` datetime DEFAULT NULL COMMENT '预设提醒时间',
  `notify_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已经提醒\n0：未提醒（默认）\n1：已提醒',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_aid` (`aid`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日程提醒设置';

CREATE TABLE `agenda_share` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程共享ID',
  `aid` bigint(20) NOT NULL DEFAULT '0' COMMENT '日历ID',   /*这个字段最好没有，这样以用户为单位统一管理共享，至于公开和私密让用户自己把握 @google*/
  `uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '共享者ID',
  `target_type` int(2) NOT NULL DEFAULT '0' COMMENT '被分享者类型\n默认0：团队\n1：群组\n2：用户',
  `target_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '被分享者ID',
  `permission` int(2) NOT NULL DEFAULT '0' COMMENT '权限\n默认0：查看\n1：编辑',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_aid` (`aid`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日程共享信息';


