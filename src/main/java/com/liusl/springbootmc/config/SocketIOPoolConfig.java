package com.liusl.springbootmc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * socket连接池配置类
 * Author: shunli1
 * Date: 2018/9/5
 * Time: 下午4:36
 **/
@Component
@ConfigurationProperties(prefix = "memcache")
public class SocketIOPoolConfig {
    private String[] servers;
    private Integer[] weights;
    private int initConn;
    private int minConn;
    private int maxConn;
    private long maintSleep;
    private boolean nagle;
    private int socketTO;

    public String[] getServers() {
        return servers;
    }

    public void setServers(String[] servers) {
        this.servers = servers;
    }

    public Integer[] getWeights() {
        return weights;
    }

    public void setWeights(Integer[] weights) {
        this.weights = weights;
    }

    public int getInitConn() {
        return initConn;
    }

    public void setInitConn(int initConn) {
        this.initConn = initConn;
    }

    public int getMinConn() {
        return minConn;
    }

    public void setMinConn(int minConn) {
        this.minConn = minConn;
    }

    public int getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }

    public long getMaintSleep() {
        return maintSleep;
    }

    public void setMaintSleep(long maintSleep) {
        this.maintSleep = maintSleep;
    }

    public boolean isNagle() {
        return nagle;
    }

    public void setNagle(boolean nagle) {
        this.nagle = nagle;
    }

    public int getSocketTO() {
        return socketTO;
    }

    public void setSocketTO(int socketTO) {
        this.socketTO = socketTO;
    }
}
