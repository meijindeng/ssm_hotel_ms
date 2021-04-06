### SQL语句
#### sys_menu菜单表
```mysql
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `pid` int(11) DEFAULT NULL COMMENT '所属父级菜单',
  `title` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `href` varchar(255) DEFAULT NULL COMMENT '打开链接地址',
  `spread` int(11) DEFAULT NULL COMMENT '是否展开（0-否，1-是）',
  `target` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8
```

#### sys_employee员工表
```mysql
CREATE TABLE `sys_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `loginname` varchar(50) DEFAULT NULL COMMENT '登录账号',
  `loginpwd` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `name` varchar(50) DEFAULT NULL COMMENT '真实名字',
  `sex` int(11) DEFAULT NULL COMMENT '性别（0-男，1-女）',
  `deptId` int(11) DEFAULT NULL COMMENT '部门编号',
  `hiredate` datetime DEFAULT NULL COMMENT '入职日期',
  `salt` varchar(100) DEFAULT NULL COMMENT '密码加密盐值',
  `createdBy` int(11) DEFAULT NULL COMMENT '创建人',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` int(11) DEFAULT NULL COMMENT '修改人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8
```

#### sys_dept部门表
```mysql
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `deptname` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `address` varchar(255) DEFAULT NULL COMMENT '部门地址',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8
```
#### sys_role角色表
```mysql
CREATE TABLE `sys_role` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `rolename` varchar(255) DEFAULT NULL COMMENT '角色姓名',
  `roledesc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
```

#### t_user用户表
```mysql
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `loginName` varchar(50) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `realName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `idCard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createDate` datetime DEFAULT NULL COMMENT '注册时间',
  `salt` varchar(100) NOT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8
```
#### t_floor楼层表
```mysql
CREATE TABLE `t_floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '楼层编号',
  `name` varchar(255) DEFAULT NULL COMMENT '楼层名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
```
#### t_room_type房型表
```mysql
CREATE TABLE `t_room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房型编号',
  `typename` varchar(50) DEFAULT NULL COMMENT '房型名称',
  `photo` varchar(255) DEFAULT NULL COMMENT '房型图片',
  `price` decimal(8,2) DEFAULT NULL COMMENT '参考价格',
  `livenum` int(11) DEFAULT NULL COMMENT '可入住人数',
  `bednum` int(11) DEFAULT NULL COMMENT '床位数',
  `roomnum` int(11) DEFAULT NULL COMMENT '房间数',
  `avilablenum` int(11) DEFAULT NULL COMMENT '可住房间数',
  `reservednum` int(11) DEFAULT NULL COMMENT '已预定房间数',
  `livednum` int(11) DEFAULT NULL COMMENT '已入住房间数',
  `status` varchar(255) DEFAULT NULL COMMENT '房型状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
```
#### t_room房间表
```mysql
CREATE TABLE `t_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `photo` varchar(255) DEFAULT NULL COMMENT '房间图片',
  `roomNum` int(20) DEFAULT NULL COMMENT '房间编号',
  `roomTypeId` int(11) DEFAULT NULL COMMENT '房间类型',
  `floorId` int(11) DEFAULT NULL COMMENT '所属楼层',
  `status` int(11) DEFAULT NULL COMMENT '房间状态',
  `roomDesc` text COMMENT '房间描述',
  `roomRequirement` varchar(255) DEFAULT NULL COMMENT '要求',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8
```
#### t_orders订单表
```mysql
CREATE TABLE `t_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '预定编号',
  `ordersNo` varchar(100) DEFAULT NULL COMMENT '预定单号',
  `accountId` bigint(20) DEFAULT NULL COMMENT '预定人账号编号',
  `roomTypeId` int(11) DEFAULT NULL COMMENT '房型编号',
  `roomId` bigint(20) DEFAULT NULL COMMENT '房间id',
  `reservationName` varchar(100) DEFAULT NULL COMMENT '预定人姓名',
  `idCard` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话号码',
  `status` int(11) DEFAULT NULL COMMENT '状态(1-待确认2-已确认)',
  `reserveDate` datetime DEFAULT NULL COMMENT '预定时间',
  `arriveDate` datetime DEFAULT NULL COMMENT '到店时间',
  `leaveDate` datetime DEFAULT NULL COMMENT '离店时间',
  `reservePrice` decimal(10,2) DEFAULT NULL COMMENT '预定价格',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
```
#### t_checkin入住表
```mysql
CREATE TABLE `t_checkin` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '入住编号',
  `roomTypeId` bigint(50) DEFAULT NULL COMMENT '房型编号',
  `roomId` bigint(50) DEFAULT NULL COMMENT '房间号',
  `customerName` varchar(50) DEFAULT NULL COMMENT '顾客姓名',
  `idCard` varchar(100) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `arriveDate` datetime DEFAULT NULL COMMENT '到店时间',
  `leaveDate` datetime DEFAULT NULL COMMENT '离店时间',
  `payPrice` decimal(10,2) DEFAULT NULL COMMENT '实付金额',
  `ordersId` bigint(20) DEFAULT NULL COMMENT '关联预定订单编号',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` int(11) DEFAULT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` int(11) DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
```
#### t_checkout退房表
```mysql
CREATE TABLE `t_checkout` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `checkOutNumber` varchar(50) DEFAULT NULL COMMENT '退房编号',
  `checkInId` int(11) DEFAULT NULL COMMENT '入住编号',
  `consumePrice` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` varchar(50) DEFAULT NULL COMMENT '创建人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
```