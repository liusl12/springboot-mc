package com.liusl.springbootmc.config;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * memcache连接配置类
 * Author: shunli1
 * Date: 2018/9/5
 * Time: 下午4:43
 **/
@Component
public class MemcacheConfig {
    @Autowired
    private SocketIOPoolConfig socketIOPoolConfig;

    @Bean
    public SockIOPool sockIOPool(){
        //获取连接池实例
        SockIOPool pool = SockIOPool.getInstance();

        //服务器列表及其权重
        String[] servers = socketIOPoolConfig.getServers();
        Integer[] weights = socketIOPoolConfig.getWeights();

        //设置服务器信息
        pool.setServers(servers);
        pool.setWeights(weights);

        //设置初始连接数、最小连接数、最大连接数、最大处理时间
        pool.setInitConn(socketIOPoolConfig.getInitConn());
        pool.setMinConn(socketIOPoolConfig.getMinConn());
        pool.setMaxConn(socketIOPoolConfig.getMaxConn());

        //设置连接池守护线程的睡眠时间
        pool.setMaintSleep(socketIOPoolConfig.getMaintSleep());

        //设置TCP参数，连接超时
        pool.setNagle(socketIOPoolConfig.isNagle());
        pool.setSocketTO(socketIOPoolConfig.getSocketTO());

        //初始化并启动连接池
        pool.initialize();
        return pool;
    }
    @Bean
    public MemCachedClient memCachedClient(){
        return new MemCachedClient();
    }

}
