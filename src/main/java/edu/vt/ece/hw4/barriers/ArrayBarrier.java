package edu.vt.ece.hw4.barriers;

import java.util.concurrent.atomic.AtomicInteger;

public class ArrayBarrier implements Barrier {
    private AtomicInteger[] barr;
    private int n;
    public ArrayBarrier( int n) {
        this.barr = new AtomicInteger[n];
        this.n = n;
    }
    @Override
    public void enter() {
        int threadId = (int)(Thread.currentThread().getId()%n);
        if(threadId ==0){
            barr[0].set(1);
        } else{
            while(barr[threadId-1].get() != 1){

            }
            barr[threadId].set(1);
        }
        if(threadId == n-1){
            barr[n-1].set(2);
        } else{
            while(barr[n-1].get() !=2){

            }
        }

    }
}
