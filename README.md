# meteor
like the meteor , shooting into the still silent night air , who leads us to future 


eureka-center:8761
crawler-member:8864...
data-member:8865...
consumer-member:8770


#####2018-08-07#####
初次建立基本工程
#####2018-08-08#####
1.新增爬虫工程
2.新增爬虫的xml加载机制（动态代理+反射），爬虫类在crawler.xml中配置
3.新增爬虫源的reload机制（测试失败）
4.新增mybatis orm组件（增加user表测试成功）
#####2018-08-09#####
1.完成sina爬虫开发
2.完成爬虫可配置（url及相关参数配置）
3.仍采用单条insert，以及多条获取后再做insert操作，非常浪费时间
#####2018-08-10#####
1.data-provider增加redis支持，目前使用cache
2.爬虫支持去重（查询md5后再插入的方式，效率不高）
3.data-provider创建用户表
4.data-provider正在开发设计train模块
#####2018-08-12#####
1.准备加入unique唯一键做去重标志
2.准备考虑更多的分布式组件方向，如更加底层点的dubbo等
3.更新了所有的localhost
4.为爬虫类注入了数据库资源
5.考虑学习下类的加载机制
#####2018-08-14#####
1.dubbo初步集成完成，crawler提供getNewsList服务，data消费服务，zookeeper作为注册中心（eureka同时存在）
2.elasticsearch初步集成完成，集成在crawler上，与mybatis共享pojo bean，保证结构一致性