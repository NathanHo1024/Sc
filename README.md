# Sc
Sringcloud 个人学习

Eureka的参数：
System Status

Environment : 环境，默认为test， 该参数在实际使用过程中，可以不用更改

Data center ： 数据中心，使用的是默认的是 “MyOwn”

Current time：当前的系统时间

Uptime ： 已经运行了多少时间

Lease expiration enabled ：是否启用租约过期 ， 自我保护机制关闭时，该值默认是true， 自我保护机制开启之后为false。

Renews threshold ： 每分钟最少续约数

Renews (last min) ： 最后一分钟的续约数量（不含当前，1分钟更新一次）

#**红字提醒**
1.在配置上，自我保护机制关闭

RENEWALS ARE LESSER THAN THE THRESHOLD. THE SELF PRESERVATION MODE IS TURNED OFF.THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.

2.自我保护机制开启了

EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE

NOT BEING EXPIRED JUST TO BE SAFE.


3.在配置上，自我保护机制关闭了，但是一分钟内的续约数没有达到85% ， 可能发生了网络分区，会有如下提示

THE SELF PRESERVATION MODE IS TURNED OFF.THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.

#DS Replicas
这个下面的信息是这个Eureka Server相邻节点，互为一个集群。

再往下面，就是注册到这个服务上的实例信息，**Instances currently registered with Eureka**
这个里面包含了所有注册到eureka的服务信息。


#General Info

total-avail-memory : 总共可用的内存

environment : 环境名称，默认test

num-of-cpus : CPU的个数

current-memory-usage : 当前已经使用内存的百分比

server-uptime : 服务启动时间

registered-replicas : 相邻集群复制节点

unavailable-replicas ：不可用的集群复制节点，如何确定不可用？ 主要是server1 向 server2和server3 发送接口查询自身的注册信息，

如果查询不到，则默认为不可用 ， 也就是说如果Eureka Server自身不作为客户端注册到上面去，则相邻节点都会显示为不可用。

available-replicas ：可用的相邻集群复制节点

#Last 1000 since startup
Last 1000 cancelled leases

最后1000个取消的租约

Last 1000 newly registered leases

最后1000个新注册的租约