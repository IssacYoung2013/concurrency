package com.issac.concurrency.example.singleton;

import com.issac.concurrency.annotations.NotThreadSafe;

/**
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
@NotThreadSafe
public class SingletonExample4 {

    private static SingletonExample4 instance = null;

    private SingletonExample4() {

    }

    // 1. memory = allocate() 分配对象的内存空间
    // 2. ctorInstance() 初始化对象
    // 3. instance  = memory 设置 instance 指向内存地址

    public static SingletonExample4 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
