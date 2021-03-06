# Studying SpringBoot

# Thymeleaf-studying
该项目，我们用 Thymeleaf 来实现一个最简单的“用户管理”功能。

## 修改application.properties

增加下面两项配置：

```
spring.thymeleaf.encoding=UTF-8
# 热部署静态文件
spring.thymeleaf.cache=false
# 使用HTML5标准
spring.thymeleaf.mode=HTML5
```

## 后台编码

### 修改 User.java

```java
private long id; // 用户的唯一标识
 
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
```

### 创建资源库
建立用户资源库的接口 ：

```java
public interface UserRepository {
	/**
	 * 新增或者修改用户
	 * @param user
	 * @return
	 */
	User saveOrUpateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Long id);
	
	/**
	 * 根据用户id获取用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 获取所有用户的列表
	 * @return
	 */
	List<User> listUser();
}
```

UserRepositoryImpl 作为该类的实现类。

### 创建控制器

整体的API设计如下：

* GET /users/list ： 返回用于展现用户列表的 list.html 页面；
* GET /users/form ： 返回用于新增或者修改用户的 form.html 页面；
* POST /users ： 新增或者修改用户；
* GET /users/delete/{id} ： 根据id删除相应的用户数据；
* GET /users/modify/{id} ： 根据id删除相应的用户数据。

### 编写前台页面

* list.html：用于展现用户列表；
* form.html：用于新增或者修改用户的资料；
* view.html：用户查看某个用户的资料。

# Spring Data JPA

## 修改application.properties

```
#datasource
spring.datasource.url=jdbc:mysql://localhost/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=zz199529
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#jpa
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto= create-drop //每次都重新创建表格
```

## User 实体类

```
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//唯一标识
    private String name;
    private Integer age;

    //设置protected 防止直接使用
    protected User(){
    }
 ```

## UserRepository
```
public interface UserRepository extends CrudRepository<User,Long>{
}
```

# ElasticSearch

## 分布式
elasticsearch 可分为很多clusters，每个clusters上可以有很多nodes，由一个master node 控制读写
每个node中可存放多个分片（shard），shard 分为primary shard 和 replica shard，后者用于备份。
shard里存放着文档

一个文档不只有数据。它还包含了元数据(metadata)——关于文档的信息。三个必须的元数据节点是：
* _index : 文档存储的地方
* _type : 文档的对象类
* -id ：文档的唯一标识



如何路由文档到分片？
当你索引一个文档，它被存储在单独一个主分片上。Elasticsearch是如何知道文档属于哪个分片的呢？当你创建一个新文档，它是如何知道是应该存储在分片1还是分片2上的呢？
进程不能是随机的，因为我们将来要检索文档。事实上，它根据一个简单的算法决定：
```
shard = hash(routing) % number_of_primary_shards
```



## build.gradle
```
	//spring data elasticsearch
	compile('org.springframework.boot:spring-boot-starter-data-elasticsearch')
	//jna
	compile('net.java.dev.jna:jna:4.3.0')
```

## application.properties

```
# 服务地址
spring.data.elasticsearch.cluster-nodes=localhost:9300
#设置连接超时时间
spring.data.elasticsearch.properties.transport.tcp.connect_timeout=120s
```

