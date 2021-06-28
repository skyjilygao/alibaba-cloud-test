
#### 问题
1. `server is DOWN now, please try again later!`

**解决：** [nacos-home]\data\protocol删除文件夹即可。这里记录了ip相关信息
2. 正确配置
```yaml
spring:
  profiles:
    active: test
---
server:
  port: 8001
spring:
  application:
    name: sky-cloud-engine
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
        namespace: 6b4efd3b-6700-4e97-aa06-6c5d21e2a829
      config:
        server-addr: 127.0.0.1:8848
        namespace: 6b4efd3b-6700-4e97-aa06-6c5d21e2a829
        group: sky-cloud-test-group
        file-extension: yml
  config:
    activate:
      on-profile: test
mybatis:
  mapper-locations: classpath:mapper/*.xml
```
3. `Inactive property source 'Config resource 'class path resource [bootstrap.yml]' via location 'optional:classpath:/'' imported from location 'class path resource [bootstrap.yml]' cannot contain property 'spring.profiles.active' [origin: class path resource [bootstrap.yml] - 7:13]`

因为同时存在`spring.profiles.active` 和 `spring.config.activate.on-profile`

**解决：**删除 `spring.config.activate.on-profile` 或 将`spring.profiles.active`单独提出来，如下：
```yaml
spring:
  profiles:
    active: test
---
spring:
  cloud:
    ...其他配置...
  config:
    activate:
      on-profile: test
```
4. `Could not resolve placeholder 'spring.application.name' in value "${spring.application.name}"`

原因：缺少 `spring.profiles.active`

解决: 配置`spring.profiles.active`即可，或者没有依赖`spring-cloud-starter-bootstrap`
   
5. `503 Service Unavailable`

    解决: 
   1. 检查各个版本是否对应。版本对应见：[版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98
      %8E) 
   2. 2020.0以上版本需要依赖`spring-cloud-starter-loadbalancer` [见issue 2011](https://github.com/alibaba/spring-cloud-alibaba/issues/2011)
   
   
###### 文献
微服务 Spring Cloud Alibaba 项目搭建 https://www.jianshu.com/p/b77d23a53098

https://www.jianshu.com/p/1f57f3b7e719