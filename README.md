# Test_Mongodb_Session
### MongoDB测试多文档事务
* 看了下官方文档，试了下根据官方文档的来发现行不通，
[官方文档链接](https://docs.spring.io/spring-data/mongodb/docs/2.2.7.RELEASE/reference/html/#mongo.transactions.tx-manager)，
很奇怪，可能是springboot版本的问题，后来我重新创建了一个2.2.7版本的springboot跟着同版本的官方文档来还是会有错误。
官方文档是继承了一个抽象类，新增一个MongoTransactionManager的方法，还要重写其他的一些方法。但是我尝试了，一直报错，报错原因是创建bean失败。
官方文档的方式报错了，已经无语。
后面找到了一篇[博客](https://www.cnblogs.com/vettel0329/p/10778931.html)，直接往容器里加一个MongoTransactionManager就好了。
然后在需要事务的方法上加上@Transactional注解就能实现事务控制。

**注意事项：** 注意自己的springboot版本吧，然后还是要看着官方文档来，不同版本之间的还是有区别的。还有就是mongodb版本要升级到4.0以上，
且需要搭建一个复制集的环境，否则是无法实现事务控制的。
