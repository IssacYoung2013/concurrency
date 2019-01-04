package com.issac.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.issac.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    public static final Integer a = 1;
    public static final String b = "2";
    public static final Map<Integer, Integer> maps = Maps.newHashMap();

    static {
        maps.put(1,2);
        maps.put(3,4);
        maps.put(5,6);
    }

    private void test(final int a) {
//        a = 1;
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "3";
//        maps = Maps.newHashMap();
        maps.put(1,3);
        log.info("{}",maps.get(1));
    }
}
