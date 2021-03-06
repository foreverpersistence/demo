package com.learning.fred.design.project.com.xzg.ratelimite.alg;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fred
 * @date 2021/1/21 13:58
 * @description 固定时间窗口算法
 */
public class RateLimitAlg {

    private static final long TRY_LOCK_TIMEOUT = 200L; // 200ms.
    private Stopwatch stopwatch;
    private AtomicInteger currentCount = new AtomicInteger(0);
    private final int limit;
    private Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this(limit, Stopwatch.createStarted());
    }

    @VisibleForTesting
    protected RateLimitAlg(int limit, Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
        this.limit = limit;
    }

    public boolean tryAcquire() throws InternalErrorException {
        //判断是否超量
        int updatedCount = currentCount.incrementAndGet();
        if (updatedCount <= limit) {
            return true;
        }
        try {
            //判断 时间
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    //超过时间
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {

                        currentCount.set(0);
                        stopwatch.reset();
                    }
                    updatedCount = currentCount.incrementAndGet();
                    return updatedCount <= limit;
                }finally {
                    lock.unlock();
                }
        } else {
            throw new InternalErrorException("tryAcquire() wait lock too long:" + "");
        }
    } catch (InterruptedException e) {
        throw new InternalErrorException("tryAcquire() is interrupted by lock-tim");
    }
    }

}
