package com.issac.concurrency.disruptor.review;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:  ywy
 * date:    2019-01-02
 * desc:
 */
public class Review {
    public static void main(String[] args) throws InterruptedException {
//        ConcurrentMap concurrentMap = new ConcurrentHashMap();

//        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
//        strings.add("a");
//
//        AtomicLong count = new AtomicLong(1);
//
//        count.compareAndSet(1,2);
//        count.compareAndSet(1,3);
//
//        System.out.println(count.get());
//
//
//        Thread A = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int sum = 0;
//                for (int i = 0; i < 10; i++) {
//                    sum+=i;
//                }
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                LockSupport.park(); // 后执行
//                System.out.println("sum:" + sum);
//            }
//        });
//
//        A.start();
//
//        Thread.sleep(2000);
//
//        LockSupport.unpark(A); // 先执行

//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(10);
//
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(
//                5,
//                Runtime.getRuntime().availableProcessors() * 2,
//                60,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(200), // 无界队列最大线程size无效
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        Thread t = new Thread(r);
//                        t.setName("order-thread");
//                        if (t.isDaemon()) {
//                            t.setDaemon(false);
//                        }
//                        if (Thread.NORM_PRIORITY == t.getPriority()) {
//                            t.setPriority(Thread.NORM_PRIORITY);
//                        }
//                        return t;
//                    }
//                },
//                new RejectedExecutionHandler() {
//                    @Override
//                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                        System.out.println("拒绝策略：" + r);
//                    }
//                }
//        );

        ReentrantLock reentrantLock = new ReentrantLock(true);


    }
}
