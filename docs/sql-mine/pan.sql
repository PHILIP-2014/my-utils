CREATE TABLE `pan_folder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(60) NOT NULL COMMENT '文件夹名',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父文件夹id',
  `path` varchar(300) DEFAULT NULL COMMENT '全路径',
  `uid` bigint(20) DEFAULT NULL COMMENT '拥有者',
  `doc_num` int(11) DEFAULT NULL COMMENT '文件数',
  `total_size` bigint(20) DEFAULT NULL COMMENT '总大小',
  `folder_status` int(1) DEFAULT NULL COMMENT '文件夹状态：0删除；1正常',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘文件夹';


CREATE TABLE `pan_document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fc_id` bigint(20) NOT NULL COMMENT '对应文件云的文件id',
  `doc_name` varchar(200) NOT NULL COMMENT '文件名',
  `folder_id` bigint(20) DEFAULT NULL COMMENT '父文件夹id',
  `uid` bigint(20) DEFAULT NULL COMMENT '拥有者',
  `cover` varchar(100) DEFAULT NULL COMMENT '封面图片',
  `doc_type` tinyint(4) DEFAULT NULL COMMENT '文件类型',
  `suffix` varchar(45) DEFAULT NULL COMMENT '文档后缀',
  `size` bigint(20) NOT NULL,
  `md5` varchar(45) NOT NULL,
  `doc_status` int(11) DEFAULT NULL COMMENT '文件状态：1正常；2删除回收；3永久删除',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘文档';


CREATE TABLE `pan_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_type` tinyint(4) DEFAULT NULL COMMENT '链接类型:1公开;2私密',
  `code` varchar(100) DEFAULT NULL COMMENT '链接码',
  `link_time` datetime DEFAULT NULL COMMENT '有效截止时间',
  `password` varchar(30) DEFAULT NULL COMMENT '私密访问密码',
  `is_closed` tinyint(1) DEFAULT NULL COMMENT '链接是否关闭:0正常;1关闭',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘链接';


CREATE TABLE `pan_link_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_id` bigint(20) NOT NULL,
  `link_type` tinyint(1) NOT NULL COMMENT '文件or文件夹',
  `folder_id` bigint(20) DEFAULT NULL COMMENT '文件夹id',
  `doc_id` bigint(20) DEFAULT NULL COMMENT '文档id',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_link_id` (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘链接信息';


