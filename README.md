# SSM-Graduation design（SSM-毕业设计）

#### 一、系统介绍
这是本人2021年的毕业设计（基于SSM+layui框架开发的酒店管理系统），该系统的后台管理的前端模板是采用Layuimini框架模板，系统前台功能有员工注册、登录、首页展示、房间分类、查看房间详情以及预定房间的功能。后台管理包括了四个一级目录，分别是系统管理、客房管理、报表管理以及订单管理，系统管理下的二级目录有菜单管理、部门管理、角色管理、员工管理，客房管理下的二级目录有楼层管理、房型管理、房间管理，报表管理下的二级目录有月营业额报表、季度营业额报表、年度营业额报表，订单管理下的二级目录有预定管理、入住管理。

#### 二、系统结构
系统结构图如下：
![系统结构](https://images.gitee.com/uploads/images/2021/0404/185951_5b48b36a_8133301.png "系统结构图.png")

#### 三、相关工具与技术栈

1.  IntelliJ IDEA2019.3+MySQL5.7+Maven3.6+Tomcat8.5+java 8
2.  Spring+Spring MVC+MyBatis三大框架
3.  layuimini前端框架模板

#### 四、前台与后台展示

1.  前台展示：
![首页前台](https://images.gitee.com/uploads/images/2021/0404/192632_a5d992d4_8133301.png "首页-前台.png")
2.  后台管理：
![后台首页](https://images.gitee.com/uploads/images/2021/0404/192229_c9e278c7_8133301.png "首页-后台.png")
3.   **说明：系统功能图中的功能基本已经实现，图片就不多放了。** 

#### 五、数据库设计

1.  数据库名：db_hotel
2.  数据库表：sys_employee（员工）表，sys_menu（菜单）表，sys_dept（部门）表，sys_role（角色）表，sys_role_emloyee（员工与角色关联）表，sys_role_menu（菜单与角色关联）表，t_user（用户）表，t_floor（楼层）表，t_room_type（房型）表，t_room（房间）表，t_orders（订单）表，t_checkin（入住）表，t_checkout（退房）表。
3.  数据库详图

![数据库详图](https://images.gitee.com/uploads/images/2021/0404/193050_ab19b69a_8133301.png "数据库图.png")


#### 六、系统目录解释

![目录](https://images.gitee.com/uploads/images/2021/0404/220605_f03f28d7_8133301.png "代码.png")
1.  controller为控制层，admin中的是后台的controller，controller目录下的是前台的控制器。
2.  dao为数据访问层，封装对数据库的访问：增删改查，不涉及业务逻辑。
3.  entity为实体类。
4.  interceptor为拦截器文件夹。
5.  service为业务层，封装通用的业务逻辑，操作。与数据访问层的进行交互。
6.  serviceImpl为service实现类实现了service接口，进行具体的业务操作。
7.  utils为工具类。
8.  vo中的vo类继承entity中的实体类。
9.  resources下有五个SSM整合的配置文件以及mapper文件夹，主要放置MyBatis的映射文件。
10. webapp下的statics文件夹主要是放置一些静态前端代码和前台jsp代码，WEB-INF下面的admin文件夹主要放后台各个功能模块的jsp代码。
