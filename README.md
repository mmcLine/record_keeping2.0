# record_keeping2.0
记账系统2.0是一个基于Spring Cloud微服务化开发平台，具有统一授权、认证后台管理系统，其中包含具备用户管理、菜单权限、资源权限管理、网关API 管理等多个模块，支持多业务系统并行开发，可以作为后端服务的开发脚手架。代码简洁，架构清晰，适合学习和直接项目中使用。 核心技术采用Spring Boot 2.1.2以及Spring Cloud (Greenwich.RELEASE) 相关核心组件，采用Nacos注册和配置中心，集成流量卫兵Sentinel，前端采用vue-element-admin组件。

## 架构说明

### 服务鉴权
通过JWT的方式来加强服务之间调度的权限验证，保证内部服务的安全性。

### 负载均衡
将服务保留的rest进行代理和网关控制，除了平常经常使用的node.js、nginx外，Spring Cloud系列的zuul和ribbon，可以帮我们进行正常的网关管控和负载均衡。其中扩展和借鉴国外项目的扩展基于JWT的Zuul限流插件，方面进行限流。

### 服务注册和调用
基于Nacos来实现的服务注册与调用，在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。

### 熔断机制
因为采取了服务的分布，为了避免服务之间的调用“雪崩”，采用了Hystrix的作为熔断器，避免了服务之间的“雪崩”。



## 项目启动

### 项目结构

ace-security
    
  ace-modules--------------公共服务模块（基础系统、搜索、OSS）
   
  ace-auth-----------------服务鉴权中心
   
  ace-gate-----------------网关负载中心
   
  ace-common---------------通用脚手架
     
  ace-control--------------运维中心（监控、链路）
  
  ace-sidebar--------------调用第三方语言服务
  
  ace-record-------------- 记账系统
  
  
 ### 环境须知
 - mysql一个，redis一个，sentiel一个，nacos注册中心一个
 - jdk1.8
 - lombok插件

 
 ### 运行步骤
 - 先启动redis、redis、mysql以及nacos注册中心
 - 运行数据库脚本 ：ace-modules/ace-admin/src/db/admin.sql、ace-auth-server/src/db/auth.sql、ace-record/ace-record-server/src/db/record.sql
 - 注意将项目中的数据库密码改掉，或者改你的数据库密码（我设置的是0490218292）
 - 按顺序运行main类 AuthBootstrap，AdminBootstrap,RecordBootstrap,GatewayServerBootstrap
 - 后端启动完毕
 - 前端项目下载我空间record_vue2.0那个启动就行了，普通vue的运行操作
 
 
 ### 运行截图
 ![image](https://github.com/mmcLine/record_keeping2.0/tree/master/images/1.png)
 ![image](https://github.com/mmcLine/record_keeping2.0/tree/master/images/2.png)
 ![image](https://github.com/mmcLine/record_keeping2.0/tree/master/images/3.png)
 ![image](https://github.com/mmcLine/record_keeping2.0/tree/master/images/4.png)
  ### 特别鸣谢
  Spring-Cloud-Admin
  如在启动时遇到问题可联系我QQ：990974807
 
 
 
 
 
