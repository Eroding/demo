package com.example.demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author cnh
 * @date 2022-03-17
 */
public class Reids {
    public static void main(String[] args) {
        Config c = new Config();
        RedissonClient redissonClient = Redisson.create(c);
        RLock lock = redissonClient.getLock("lock");

        try {
            lock.lock();
        }finally {
            lock.unlock();
        }

    }
}
