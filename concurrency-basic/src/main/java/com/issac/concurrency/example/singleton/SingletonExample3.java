package com.issac.concurrency.example.singleton;

import com.issac.concurrency.annotations.NotThreadSafe;
import com.issac.concurrency.annotations.ThreadSafe;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@NotThreadSafe
public class SingletonExample3 {

    private static SingletonExample3 instance = null;

    private SingletonExample3() {

    }

    public synchronized static SingletonExample3 getInstance() {
        if(instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
