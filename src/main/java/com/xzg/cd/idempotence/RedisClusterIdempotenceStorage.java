package com.xzg.cd.idempotence;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fred
 * @date 2021/1/24 21:08
 * @description redis 实现
 */
public class RedisClusterIdempotenceStorage implements IdempotenceStorage {

    private JedisCluster jedisCluster;

    public RedisClusterIdempotenceStorage(String redisClusterAddress, GenericObjectPoolConfig config) {
        Set<HostAndPort>redisNodes = parseHostAndPorts(redisClusterAddress);
        this.jedisCluster = new JedisCluster(redisNodes, config);

    }


    @Override
    public boolean saveIfAbsent(String idempotenceId) {
        Long success = jedisCluster.setnx(idempotenceId, "1");
        return success == 1;
    }

    @Override
    public void delete(String idempotenceId) {

        jedisCluster.del(idempotenceId);
    }

    @VisibleForTesting
    protected Set<HostAndPort> parseHostAndPorts(String redisClusterAddress) {
        String[] addressArray= redisClusterAddress.split(";");
        Set<HostAndPort> redisNodes = new HashSet<>();
        for (String address : addressArray) {
            String[] hostAndPort = address.split(":");
            redisNodes.add(new HostAndPort(hostAndPort[0], Integer.valueOf(hostAndPort[1])));
        }
        return redisNodes;
    }

}
