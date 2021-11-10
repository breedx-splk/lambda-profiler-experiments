package com.splunk.lambdas;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This submits foo() and bar() lambdas as background workers to a
 * thread pool.
 */
public class MainBackgroundWorkers {

    public static void main(String[] args) throws Exception {
        new MainBackgroundWorkers().run();
    }

    private void run() throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        while(true){
            System.out.print("Running 2 jobs...");
            CompletableFuture<?> fooFuture = CompletableFuture.runAsync(this::foo, exec);
            CompletableFuture<?> barFutureFuture = CompletableFuture.runAsync(this::bar, exec);
            CompletableFuture.allOf(fooFuture, barFutureFuture).get();
            System.out.println("complete.");
        }
    }


    void foo() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void bar() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
