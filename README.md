# meteor
> like the meteor , shooting into the still silent night air , who leads us to future.
## 项目介绍
>爬取crawler.xml中配置过的新闻网站的资源，使用word2vec对新闻（单词）进行向量化，计算后形成用户与新闻（类型）之间的关系映射，依此进行新闻推荐（实时、离线）。
```xml
    <!--crawler配置源-->
    <crawler id = "SinaCrawler" class = "cn.meteor.spacecraft.crawler.impl.SinaCrawler" >
        <urlTemplate url="url">
            <param pageid="204" lid="22" category="IT"></param>
            <param pageid="236" lid="24" category="Internet"></param>
            <param pageid="123" lid="1367" category="社会"></param>
            <param pageid="51" lid="740" category="电影"></param>
            <param pageid="207" lid="1795" category="探索"></param>
        </urlTemplate>
    </crawler>
```

>采用springboot+springcloud作为主要的分布式框架，euraka作为调度中心，对外暴露rest接口访问。内部各模块之间用dubbo作为RPC，实现各自间的接口调用。

>alpha-centauri项目中，采用redis作为消息队列缓冲用户消息；使用redis缓存部分用户数据信息。
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
