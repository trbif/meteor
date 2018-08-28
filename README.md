# meteor
> like the meteor , shooting into the still silent night air , who leads us to future.
## 项目介绍
>爬取配置好的新闻网站的资源，利用新闻数据、使用word2vec对词组进行向量化，形成用户与新闻（类型）之间的关系映射，依此进行新闻推荐（实时、离线）。
>采用springboot+springcloud作为主要的分布式框架，euraka作为调度中心，对外暴露rest接口访问。内部各模块之间用dubbo作为RPC，实现各自间的接口调用。
### hubble：
哈勃，meteor的控制中心（eureka），监控整体状态
#### 端口:8761
### galaxy：
星系，meteor的资源中心，对外（用户）暴露rest访问接口
#### 端口:8770
### spacecraft：
战舰，meteor的数据资源发现者，多台飞船同时挖掘指定地域的消息资源（挖矿），对alpha-centauri暴露数据拉取接口（dubbo+zookeeper），对galaxy暴露rest接口
#### 端口:8864等
### alpha-centauri：
半人马座alpha，meteor的数据加工厂（模型生成），所有spacecraft卸载的货在这里加工，对galaxy暴露rest接口
#### 端口:8865
## 示例
用户点赞“电影”相关新闻：
http://localhost:8770/like?userID=3&newsCategory=电影

用户取消点赞或不喜欢“电影”相关新闻：
http://localhost:8770/dislike?userID=3&newsCategory=电影

返回用户推荐列表（基于即时、倾向、固定兴趣）：
http://localhost:8770/refresh?userID=3
