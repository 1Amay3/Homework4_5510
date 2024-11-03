package edu.vt.ece.hw4.backoff;

public class PolynomialBackoff implements Backoff {

    private int attempts=0;
    @Override
    public void backoff() throws InterruptedException {
        int delay= attempts*attempts;
        Thread.sleep(delay);
        attempts++;
    }
}
