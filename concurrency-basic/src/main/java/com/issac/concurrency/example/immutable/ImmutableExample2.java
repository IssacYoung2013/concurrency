package com.issac.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.issac.concurrency.annotations.NotThreadSafe;
import com.issac.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    public static Map<Integer, Integer> maps = Maps.newHashMap();

    static {
        maps.put(1,2);
        maps.put(3,4);
        maps.put(5,6);
        maps = Collections.unmodifiableMap(maps);
    }

    public static void main(String[] args) {
        // 通过Collections.unmodifiableMap不允许修改
        maps.put(1,3);
        log.info("{}",maps.get(1));
    }
}
