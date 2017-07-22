DROP TABLE `sys_user`;
DROP TABLE `sys_user_info`;
DROP TABLE `sys_user_role`;
DROP TABLE `sys_role`;
DROP TABLE `sys_menu`;
DROP TABLE `sys_role_privilege`;
DROP TABLE `sys_operation_logs`;

CREATE TABLE `sys_user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_name` varchar(255) NULL COMMENT '用户名',
`password` varchar(255) NULL COMMENT '密码',
`status` int(11) NULL COMMENT '0无效，1正常，2冻结',
`source` int(11) NULL COMMENT '用户组织，0后台用户，1blog用户',
PRIMARY KEY (`id`) 
);

CREATE TABLE `sys_user_info` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NULL COMMENT '用户id',
`address` varchar(255) NULL COMMENT '地址',
`email` varchar(255) NULL COMMENT '邮件',
`sex` int(255) NULL COMMENT '0男，1女',
`mobile` bigint(11) NULL COMMENT '手机号',
`created_time` datetime NULL COMMENT '创建时间',
`created_by` varchar(255) NULL COMMENT '创建人',
`modified_time` datetime NULL COMMENT '修改时间',
`modified_by` varchar(255) NULL COMMENT '修改人',
PRIMARY KEY (`id`) 
);

CREATE TABLE `sys_user_role` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NULL,
`role_id` int(11) NULL,
`created_time` datetime NULL,
`created_by` varchar(255) NULL,
`status` int(255) NULL COMMENT '状态：1-正常；2-锁定；3-删除',
PRIMARY KEY (`id`) 
);

CREATE TABLE `sys_role` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`code` varchar(255) NULL COMMENT '角色编码',
`value` varchar(255) NULL COMMENT '角色值',
`order_index` int(11) NULL COMMENT '排序',
`status` int(11) NULL COMMENT '状态：1-正常；2-锁定；3-删除',
`created_time` datetime NULL,
`created_by` varchar(255) NULL,
`modified_time` datetime NULL,
`modified_by` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `sys_menu` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`parent_id` int(11) NULL,
`title` varchar(255) NULL COMMENT '菜单标题',
`url` varchar(255) NULL COMMENT '菜单链接',
`icon` varchar(255) NULL COMMENT '图标',
`order_index` int(255) NULL COMMENT '排序',
`comment` varchar(255) NULL COMMENT '菜单描述',
`status` int(11) NULL COMMENT '状态：1-正常；2-锁定；3-删除',
`created_time` datetime NULL,
`created_by` varchar(255) NULL,
`modified_time` datetime NULL,
`modified_by` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `sys_role_privilege` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`role_id` int(11) NULL,
`privilege_id` int(11) NULL,
`created_by` varchar(255) NULL,
`created_time` datetime NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `sys_operation_logs` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`operation_id` int(11) NULL COMMENT '操作人id',
`operation_name` varchar(255) NULL COMMENT '操作人name',
`created_time` datetime NULL,
`operation_url` varchar(255) NULL COMMENT '操作资源',
PRIMARY KEY (`id`) 
);

