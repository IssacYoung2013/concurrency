package com.issac.concurrency.example.singleton;

import com.issac.concurrency.annotations.ThreadSafe;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@ThreadSafe
public class SingletonExample6 {

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    private SingletonExample6() {

    }

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
