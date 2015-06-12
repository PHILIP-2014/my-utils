CREATE TABLE `agenda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程ID',
  `uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者ID',
  `title` varchar(2000) DEFAULT '' COMMENT '日程标题',
  `description` text COMMENT '详细日程描述',
  `gmt_start` datetime DEFAULT NULL COMMENT '开始时间',
  `gmt_end` datetime DEFAULT NULL COMMENT '结束时间',
  `all_day` tinyint(1) DEFAULT '0' COMMENT '整天\n默认0：不是整天\n1：整天',
  `address` varchar(100) DEFAULT '' COMMENT '地点',
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
  `agenda_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '日程ID',
  `uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者ID',
  `notify_type` int(4) NOT NULL DEFAULT '0' COMMENT '提醒方式\n默认0：会话提醒\n1：Email（使用用户认证过的Email提醒）\n2：桌面提醒\n3：SMS',
  `gmt_notify` datetime DEFAULT NULL COMMENT '预设提醒时间',
  `notify_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已经提醒\n0：未提醒（默认）\n1：已提醒',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_agenda_id` (`agenda_id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日程提醒设置';

CREATE TABLE `agenda_conversation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程会话ID',
  `agenda_id` bigint(20) NOT NULL COMMENT '日程ID',
  `uid_shared` bigint(20) NOT NULL COMMENT '谁分享到该会话',
  `uid_target` bigint(20) DEFAULT '0' COMMENT '分享给谁',
  `conversation_id` varchar(45) NOT NULL COMMENT '会话ID\nid_a-id_b 或者 teamId',
  `conversation_type` tinyint(4) NOT NULL COMMENT '会话类型\n0：个聊\n1：群聊',
  `uid_small` bigint(20) DEFAULT '0' COMMENT 'uid较小的',
  `uid_large` bigint(20) DEFAULT '0' COMMENT 'uid较大的',
  `team_id` bigint(20) DEFAULT '0' COMMENT '群组ID',
  `msg_id` bigint(20) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_agenda_id` (`agenda_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日程会话分享';


