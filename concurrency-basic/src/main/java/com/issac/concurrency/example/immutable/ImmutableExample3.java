package com.issac.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
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
public class ImmutableExample3 {

    public final static ImmutableList list = ImmutableList.of(1,2,3);

    public static final ImmutableSet set = ImmutableSet.copyOf(list);

    public static final ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,3,4,5,6);

    public static final ImmutableMap<Integer,Integer> map2 = ImmutableMap.<Integer,Integer>builder().put(1,3).put(2,4).build();


    public static void main(String[] args) {
//        list.add(1);
//        map.put(1,4);
    }
}
