sentinel:高可用的服务控制组件
seata:究极无敌屎码坑人,看了源码才知道,alibaba2021用的seata版本是 1.3,压根没到1.4,根本用不了nacos里面的dataid配置。别问我则么麽知道.源码里面就写了getConfig是通过dataId去找的.....人晕了
![img.png](img.png)
看看,哪有这种,获取config,直接从dataId拿.恶心坏了