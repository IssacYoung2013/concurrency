package com.issac.concurrency.example.lock;

import com.issac.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@Slf4j
@ThreadSafe
public class LockExample3 {

    private final Map<String,Data> map = new TreeMap<>();

    public  final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock  readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        }
        finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys() {

        readLock.lock();
        try {
            return map.keySet();
        }
        finally {
            readLock.unlock();
        }
    }

    public Data put(String key,Data value) {

        writeLock.lock();
        try {
            return map.put(key,value);
        }
        finally {
            writeLock.unlock();
        }
    }

    class Data {}
}
