package edu.vt.ece.hw4.backoff;

import java.util.Random;

public class ExponentialBackoff implements Backoff {
    private int attempts;
    private int max;
    private int baseDelay;
    private Random random;
    @Override
    public void backoff() throws InterruptedException {
        this.attempts=0;
        this.max=10000;
        this.baseDelay=10;
        this.random = new Random();



        long exponentialDelay=Math.min(baseDelay*(1L << attempts),max);
        long maxDelay = Math.min(exponentialDelay, Long.MAX_VALUE / 2);
        long delay = maxDelay + (long)(random.nextDouble() * maxDelay);
        Thread.sleep(delay);
        attempts++;
    }

}
