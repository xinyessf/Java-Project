### 主从安装

**请查看linux文件下mysql安装**

>注意:mysql请安装到默认路径

### mycat使用

[官网](http://www.mycat.io/)

>1.多台服务器中mysql安装
>2.mycat安装,修改配置
>3.项目搭建测试

```
  MyCAT是一款由阿里Cobar演变而来的用于支持数据库，读写分离、分表分库的分布式中间件。MyCAT支持Oracle、MSSQL、MYSQL、PG、DB2关系型数据库，同时也支持MongoDB等非关系型数据库。
 MyCAT原理MyCAT主要是通过对SQL的拦截，然后经过一定规则的分片解析、路由分析、读写分离分析、缓存分析等，然后将SQL发给后端真实的数据块，并将返回的结果做适当处理返回给客户端。
 
 基于MyCat实现读写分离
 读写分离，简单地说是把对数据库的读和写操作分开，以对应不同的数据库服务器。主数据库提供写操作，从数据库提供读操作，这样能有效地减轻单台数据库的压力。主数据库进行写操作后，数据及时同步到所读的数据库，尽可能保证读、写数据库的数据一致，比如MySQL的主从复制、Oracle的data guard、SQL Server的复制订阅等。
```

### 实操

```
Linux环境安装MyCat实现读写分离
1、上传安装Mycat-server-1.6.5-release-20180122220033-linux.tar
2、解压安装包tar –zxvf  
3、配置schema.xml 和server.xml
4、客户端连接端口号: 8066
#启动
Linux环境安装MyCat实现读写分离
1、进入bin目录 
  启动MyCat ./mycat start 
  停止MyCat ./mycat stop
2、查看/usr/local/mycat/logs wrapper.log日志 如果是为successfully 则启动成功

关闭防火墙:systemctl stop firewalld.service
只可读的账号      user  user  端口号8066
可读可写的账号    root  123456  端口号8066

```

| server.xml | Mycat的配置文件，设置账号、参数等     |
| ---------- | ------------------------------------- |
| schema.xml | Mycat对应的物理数据库和数据库表的配置 |
| rule.xml   | Mycat分片（分库分表）规则             |

### 动态数据源

```

1.配置多个数据源，根据业务需求访问不同的数据，指定对应的策略：增加，删除，修改操作访问对应数据，查询访问对应数据，不同数据库做好的数据一致性的处理。由于此方法相对易懂，简单，不做过多介绍。 
2. 动态切换数据源，根据配置的文件，业务动态切换访问的数据库:此方案通过Spring的AOP，AspactJ来实现动态织入，通过编程继承实现Spring中的AbstractRoutingDataSource,来实现数据库访问的动态切换，不仅可以方便扩展，不影响现有程序，而且对于此功能的增删也比较容易。 
3. 通过mycat来实现读写分离:使用mycat提供的读写分离功能，mycat连接多个数据库，数据源只需要连接mycat，对于开发人员而言他还是连接了一个数据库(实际是mysql的mycat中间件)，而且也不需要根据不同 业务来选择不同的库，这样就不会有多余的代码产生。

动态数据源核心配置
在Spring 2.0.1中引入了AbstractRoutingDataSource, 该类充当了DataSource的路由中介, 能有在运行时, 根据某种key值来动态切换到真正的DataSource上。
1.项目中需要集成多个数据源分别为读和写的数据源，绑定不同的key。
2.采用AOP技术进行拦截业务逻辑层方法，判断方法的前缀是否需要写或者读的操作
3.如果方法的前缀是写的操作的时候，直接切换为写的数据源，反之切换为读的数据源
也可以自己定义注解进行封装

```

