






<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<h1># meteor</h1>
<p>like the meteor , shooting into the still silent night air , who leads us to future </p>

</head>
<body>

<h3>#####端口信息#####</h3>
<p>eureka-center:8761</p>
<p>crawler-member:8864...</p>
<p>data-member:8865...</p>
<p>consumer-member:8770</p>


<h3>#####2018-08-07#####</h3>
<p>初次建立基本工程</p>
<h3>#####2018-08-08#####</h3>
<p>1.新增爬虫工程</p>
<p>2.新增爬虫的xml加载机制（动态代理+反射），爬虫类在crawler.xml中配置</p>
<p>3.新增爬虫源的reload机制（测试失败）</p>
<p>4.新增mybatis orm组件（增加user表测试成功）</p>
<h3>#####2018-08-09#####</h3>
<p>1.完成sina爬虫开发</p>
<p>2.完成爬虫可配置（url及相关参数配置）</p>
<p>3.仍采用单条insert，以及多条获取后再做insert操作，非常浪费时间</p>
<h3>#####2018-08-10#####</h3>
<p>1.data-provider增加redis支持，目前使用cache</p>
<p>2.爬虫支持去重（查询md5后再插入的方式，效率不高）</p>
<p>3.data-provider创建用户表</p>
<p>4.data-provider正在开发设计train模块</p>
<h3>#####2018-08-12#####</h3>
<p>1.准备加入unique唯一键做去重标志</p>
<p>2.准备考虑更多的分布式组件方向，如更加底层点的dubbo等</p>
<p>3.更新了所有的localhost</p>
<p>4.为爬虫类注入了数据库资源</p>
<p>5.考虑学习下类的加载机制</p>
<h3>#####2018-08-14#####</h3>
<p>1.dubbo初步集成完成，crawler提供getNewsList服务，data消费服务，zookeeper作为注册中心（eureka同时存在）</p>
<p>2.elasticsearch初步集成完成，集成在crawler上，与mybatis共享pojo bean，保证结构一致性</p>
<h3>#####2018-08-16#####</h3>
<p>计划：</p>
<p>1.mybatis使用xml方式管理mapper，不再使用注入方式</p>
<p>2.增加训练代码，至少保证word2vec的builder完成（builder+重载）</p>
<p>3.完成ik分词（或别的分词器）的部署</p>
<p>实施：</p>
<p>1.完成crawler下的mybatis使用xml session管理</p>
<p>2.训练代码完成</p>
<p>3.完成word分词器部署</p>
<p>其它：</p>
<p>1.创建w2vmodels表用于存储模型信息</p>
<p>2.基本完成训练精度计算流程</p>
<p>3.增加了data对用户的service设计</p>
<h3>#####2018-08-17#####</h3>
<p>计划：</p>
<p>1.训练完成后数据持久化到mysql</p>
<p>2.高效地向量重构方案及实施</p>
<p>3.定时取分值最高模型，时机合适时进行向量重构</p>
<p>实施：</p>
<p>1.已持久化</p>
<p>2.完成user向量的批量重构设计及开发，未完成单个用户向量的重构</p>
<p>3.完成启动时取最高分模型，未进行定时任务</p>
<p>其它：</p>
<p>1.正在创建用户登录等模块</p>
<p>2.正在编写用户注册后向量初始化模块</p>
<p>3.正在设计用户即时行为修改向量</p>
<p>4.正在设计根据用户向量返回新闻列表</p>
</body>
</html>