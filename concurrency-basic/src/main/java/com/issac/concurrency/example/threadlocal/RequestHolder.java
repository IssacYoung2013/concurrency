package com.issac.concurrency.example.threadlocal;

/**
 *
 * author:  ywy
 * date:    2018-12-29
 * desc:
 */
public class RequestHolder {

    public static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
