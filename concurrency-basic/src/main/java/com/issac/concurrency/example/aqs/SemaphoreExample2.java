package com.issac.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@Slf4j
public class SemaphoreExample2 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire(3); // 获取许可
                    test(threadNum);
                    semaphore.release(3); // 释放许可
                } catch (InterruptedException e) {
                    log.error("exception:",e);
                }
            });
        }

        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(100);
    }
}
