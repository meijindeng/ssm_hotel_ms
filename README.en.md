# SSM-Graduation design

#### 一、System is introduced
This is my graduation design in 2021 (a hotel management system developed based on SSM+ Layui framework). Layuimini framework is used as the front-end template for the background management of the system. The front-end functions of the system include employee registration, login, home page display, room classification, viewing room details and booking room functions. Background management, including the four level directory, respectively is, guest room management system management, report management and order management, system management of the secondary directory menu management, department management, role management, staff management, guest room management level 2 directory a floor under management, room management, room management, report management under the secondary directory on a turnover report, quarterly reports, annual turnover turnover report, secondary directory have a reservation under the order management management, hotel management.

#### 二、The system structure
The system structure diagram is as follows：
![The system structure](https://images.gitee.com/uploads/images/2021/0404/185951_5b48b36a_8133301.png "系统结构图.png")

#### 三、Related tools and technology stacks

1.  IntelliJ IDEA2019.3+MySQL5.7+Maven3.6+Tomcat8.5+java 8
2.  Spring+Spring MVC+MyBatis The three framework
3.  layuimini Front End Frame Template

#### 四、Front and back stage display

1.  The front desk to show：
![Home page at the front desk](https://images.gitee.com/uploads/images/2021/0404/192632_a5d992d4_8133301.png "首页-前台.png")
2.  Background management：
![The background page](https://images.gitee.com/uploads/images/2021/0404/192229_c9e278c7_8133301.png "首页-后台.png")
3.   **Description: the function of the system function diagram has been implemented, the picture is not much。** 

#### 五、Database design

1.  Database name：db_hotel
2.  Database tables：sys_employee，sys_menu，sys_dept，sys_role，sys_role_emloyee，sys_role_menu，t_user，t_floor，t_room_type，t_room，t_orders，t_checkin，t_checkout。
3.  Database detail

![Database detail](https://images.gitee.com/uploads/images/2021/0404/193050_ab19b69a_8133301.png "数据库图.png")


#### 六、System directory interpretation

![System directory interpretation](https://images.gitee.com/uploads/images/2021/0404/220605_f03f28d7_8133301.png "代码.png")
1. Controller is the control layer. The controller in the admin is the backstage controller, and the controller in the controller directory is the front-stage controller.

2. DAO is the data access layer, encapsulating the access to the database: add, delete, change and check, without involving business logic.

3. Entity is an entity class.

4. Interceptor is the folder for interceptors.

5. Service is the business layer, encapsulating the common business logic and operations. Interacts with the data access layer.

6. ServiceImpl implements the Service interface for the Service implementation class to perform specific business operations.

7. Utils is the utility class.

8. The VO class in VO inherits the entity class in Entity.

9. There are five SSM integrated configuration files and Mapper folder under Resources, which mainly place mapping files of MyBatis.

10. The Statics folder under WebApp mainly places some static front-end codes and front-end JSP codes, while the Admin folder under WEB-INF mainly places the JSP codes of various function modules in the background.
