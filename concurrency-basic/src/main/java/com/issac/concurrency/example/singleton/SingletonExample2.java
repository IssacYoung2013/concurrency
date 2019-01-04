package com.issac.concurrency.example.singleton;

import com.issac.concurrency.annotations.NotThreadSafe;
import com.issac.concurrency.annotations.ThreadSafe;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@ThreadSafe
public class SingletonExample2 {

    private static SingletonExample2 instance = new SingletonExample2();

    private SingletonExample2() {

    }

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
