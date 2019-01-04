package com.issac.concurrency.example.singleton;

import com.issac.concurrency.annotations.NotThreadSafe;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@NotThreadSafe
public class SingletonExample1 {

    private static SingletonExample1 instance = null;

    private SingletonExample1() {

    }

    public static SingletonExample1 getInstance() {
        if(instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
