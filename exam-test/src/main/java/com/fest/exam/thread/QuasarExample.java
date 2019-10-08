package com.fest.exam.thread;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yesitao
 * @Date: 2019/9/24 16:44
 * @Description:
 */
public class QuasarExample {
    private static AtomicInteger ma = new AtomicInteger(1);
    static long skynet(long num, int size, int div) throws SuspendExecution, InterruptedException {
        try {
            if (size == 1)
                return num;

            Fiber<Long>[] children = new Fiber[div];
            long sum = 0L;
            for (int i = 0; i < div; i++) {
                long subNum = num + i * (size / div);
                children[i] = new Fiber<>(() -> skynet(subNum, size / div, div)).start();
            }
            for (Fiber<Long> c : children)
                sum += c.get();
            return sum;
        } catch (ExecutionException e) {
            throw (RuntimeException) e.getCause();
        }
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < RUNS; i++) {
            new Fiber<>(() -> {
                ma.incrementAndGet();
                System.out.println("Thread-"+Thread.currentThread().getName()+" ma:"+ma);
            }).start();

        }
        countDownLatch.await();
    }

    static final int RUNS = 100;
}