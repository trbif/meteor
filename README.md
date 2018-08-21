# meteor
> like the meteor , shooting into the still silent night air , who leads us to future.
## 项目介绍
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
半人马座alpha，meteor的数据加工厂，所有spacecraft卸载的货在这里加工，对galaxy暴露rest接口
#### 端口:8865