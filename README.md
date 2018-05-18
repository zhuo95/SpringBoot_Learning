# Studying SpringBoot

## Thymeleaf
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