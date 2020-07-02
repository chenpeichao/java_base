package org.pcchen.pdmi.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.concurrent.TimeUnit;

/**
 * 单机redis连接测试
 *
 * @author ceek
 * @create 2019-10-28 19:16
 **/
public class JedisDemo {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("10.10.32.62", 6381);
//        String pong = jedis.ping();
//
//        System.out.println(pong);

        JedisCluster jedisCluster = new JedisCluster(new HostAndPort("10.10.32.62", 6379));
        jedisCluster.set("user_flag", "wojiushiwo");

        jedisCluster.expire("user_flag", 10000);

        while (true) {
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(jedisCluster.ttl("user_flag"));
        }
    }
}
