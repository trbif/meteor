<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<h1># meteor</h1>
<p>like the meteor , shooting into the still silent night air , who leads us to future </p>

</head>
<body>
<h3>hubble：</h3>
哈勃，meteor的控制中心（eureka），监控整体状态
<h4>端口:</h4><p>8761</p>
<h3>galaxy：</h3>
星系，meteor的资源中心，对外（用户）暴露rest访问接口
<h4>端口:</h4><p>8770</p>
<h3>spacecraft：</h3>
战舰，meteor的数据资源发现者，多台飞船同时挖掘指定地域的消息资源（挖矿），对alpha-centauri暴露数据拉取接口（dubbo+zookeeper），对galaxy暴露rest接口
<h4>端口:</h4><p>8864等</p>
<h3>alpha-centauri：</h3>
半人马座alpha，meteor的数据加工厂，所有spacecraft卸载的货在这里加工，对galaxy暴露rest接口
<h4>端口:</h4><p>8865</p>
</body>
</html>