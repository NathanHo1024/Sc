/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MyRobbinRuleUpdate
 * Author:   Nathan
 * Date:     2020/4/9 13:37
 * Description: 需求ribbon轮询
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hlgj.myconfig.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈需求ribbon轮询〉
 *
 *  需求场景：
 *  依旧轮询策略，但是加上新需求，每个服务器要求被调用5次，
 * @author Nathan
 * @create 2020/4/9
 * @since 1.0.0
 */
public class MyRobbinRuleUpdate extends AbstractLoadBalancerRule {

    //total = 0》当total打到5后，我们指针才能往下走
    //index = 0 》，当前对外提供服务的服务器地址
    //total需要 重新置为0，但是已经达到过一个5次，即index = 1
    //分析：5次，但是微服务只有8009 8008 8007 三台，
    private Integer total = 0;  //总共被调用的次数，目前要求每台服务器被调用5次
    private Integer currentIndex = 0;   //当前提供服务的机器号

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    public Server choose(ILoadBalancer ib, Object object){
        if(ib == null){//如果负载均衡算法为null，即没有算法，直接返回空
            return null;
        }
        Server server = null;

        while (server == null){//如果服务为空
            if(Thread.interrupted()){//如果线程被打断
                return null;
            }
            List<Server> upLists = ib.getReachableServers();//获取线上注册的
            List<Server> allLists = ib.getAllServers();//获取所有注册的

            int serverCount = allLists.size();

            if(serverCount == 0){
                //如果注册服务为0，即不存在 或者挂掉
                return null;
            }

            if(total < 5){
                server = upLists.get(currentIndex);
                total ++ ;
            }else {
                total = 0;
                currentIndex ++ ;
                if(currentIndex >= upLists.size()){
                    currentIndex = 0;
                }
            }

            if(server == null){//如果服务为空，
                Thread.yield();//线程休息
                continue;
            }

            if(server.isAlive()){//如果服务正常
                return (server);//返回当前正常的服务
            }

            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }
}