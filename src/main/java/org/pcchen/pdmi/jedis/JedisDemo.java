package org.pcchen.pdmi.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
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

        JedisCluster jedisCluster = new JedisCluster(new HostAndPort("10.101.67.4", 7000));
//        jedisCluster.set("user_flag", "wojiushiwo");

//        jedisCluster.expire("user_flag", 10000);


        String redisString = "10.101.67.4:7000";
        String[] hostArray = redisString.split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();

        //配置redis集群
        for (String host : hostArray) {
            String[] detail = host.split(":");
            nodes.add(new HostAndPort(detail[0], Integer.parseInt(detail[1])));
        }

        jedisCluster = new JedisCluster(nodes);

        System.out.println(jedisCluster.del("content_item_detail_hash:9c63d254eab4862fefd785c207a095f8"));
    }
}
