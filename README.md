
# springboot-jpa 学生导师互选系统
* 2020.3.12
* springboot:2.2.5 
* lombok 
* spring-data-jpa 
* mysql:8.x
---
## 关系描述
* Course&Student ManyToMany
* Teacher&Student OneToMany
* Student&Hobby ManyToMany
* Teacher&Course OneToMany
## 经验总结
* 使用BaseRepositoryImpl类实现BaseRepository接口时，要记得在Application入口处添加注解
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)，表示需要经过自己的实现
* 尽量不要使用基本数据类型，而是使用他们对应的包装类

