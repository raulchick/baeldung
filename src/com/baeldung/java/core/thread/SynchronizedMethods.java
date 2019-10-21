package com.baeldung.java.core.thread;

public class SynchronizedMethods {

    private int sum = 0;
    public static int staticSum = 0;
    public static int staticSum2 = 0;

    public void calculate() {
        setSum(getSum() + 1);
    }

    public synchronized void synchronisedCalculate() {
        setSum(getSum() + 1);
    }

    public static synchronized void syncStaticCalculate() {
        staticSum += 1;
    }

    public void performSynchronisedCalculate() {
        synchronized (this) {
            setSum(getSum() + 1);
        }
    }

    public static void performStaticSyncCalculate(){
        synchronized (SynchronizedMethods.class) {
            staticSum2 += 1;
        }
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
