# Gradual 个人博客系统

## 简介

Gradual个人博客系统是个采用Spring Boot框架自动配置， Spring MVC，Spring, MyBatis等框架构建而成。 

严格按照阿里巴巴Java开发规范进行代码约束

采用三层架构及MVC模式。

数据库采用MySQL， 连接池使用阿里巴巴druid数据库连接池

使用Redis进行缓存

定时任务刷新分类、友链、点赞排行等信息

富文本编辑器使用了wangEditor富文本编辑器，异步将博文图片上传到后台，后台将图片上传到七牛云并返回url地址回显图片。



## 功能

- 发表文章
- 查看文章

- 编辑文章
- 删除文章
- 文章评论
- 用户登录
- 权限拦截

