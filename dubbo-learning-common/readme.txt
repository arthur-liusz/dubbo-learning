**********以zookeeper为注册中心的dubbo集群搭建与测试备忘**********
1.注册中心的安装与配置：
	注册中心：使用zookeeper3.3.6；
	安装路径：在/home/arthur/installedprogrames/zookeeper336下通过解压.tar.gz包安装3个zookeeper节点；
	关于配置：在./conf/路径下，通过复制zoo_sample.cfg得到一个zoo.cfg，在zoo.cfg中配置dataDir、dataLogDir、clientPort；
	集群配置：在zoo.cfg中配置多个server.x=127.0.0.1:11111:11112，在dataDir路径下创建myid文件并填写x（自身server编号）；
	集群启动：在./bin/路径下使用./zkServer.sh start启动节点，使用./zkServer.sh status查看节点角色；
2.服务提供者的开发与部署：
	保存dubbo.xsd文件：从github上下载一份dubbo.xml文件，保存在src/main/resources路径下，供spring IOC配置文件引用；
	引入依赖：在common模块的pom.xml文件中引入spring-context、dubbo、zkclient的依赖；
	剔除杂项：在provider模块的pom.xml文件中通过<transformer>剔除META-INF/spring.handlers与META-INF/spring.schemas；
	配置容器：编辑配置spring IOC容器的配置文件，配置dubboo的各元素，导出服务接口；
	程序部署：编译和打包provider，将可执行jar包复制到/home/arthur/experiments/dubbo-learning/provider下，java -jar 运行；
3.服务消费者的开发与部署：
	基本上与“2.服务提供者的开发与部署”相同；
4.安装dubbo-admin：
	源码下载：从github上下载dubbo项目源码（如果master分支下没有admin模块，则选2.5.x分支）；
	编译部署：在本地编译dubbo-admin模块，打包成.war包，部署在tomcat的webapps路径下；
	启动运行：启动tomcat后，会自动解压，解压后可以修改dubbo-admin的META-INF/下的dubbo.properties文件，重启tomcat；
	访问页面：浏览器访问http://localhost:8080/dubbo-admin-2.5.9即可操作dubbo-admin管理系统；登录密码在dubbo.properties；
5.安装dubbo-monitor：
	源码下载：基本上与“4.安装dubbo-admin”相同；
	编译部署：在本地编译dubbo-monitor模块，打包成可执行.jar包，复制到/home/arthur/experiments/dubbo-learning/monitor下；
	解压运行：在/home/arthur/experiments/dubbo-learning/monitor下解压.jar包，修改dubbo.properties文件，./bin/下运行；
	访问页面：浏览器访问http://localhost:9090/，即可操作dubbo-monitor管理系统；