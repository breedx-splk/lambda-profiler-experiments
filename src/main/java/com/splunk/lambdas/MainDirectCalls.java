package com.splunk.lambdas;

/**
 * This is the simplest example -- it just facilitates running foo() and bar()
 * via a helper method.
 */
public class MainDirectCalls {

    public static void main(String[] args) throws Exception {
        new MainDirectCalls().run();
    }

    private void run() throws Exception {
        while(true){
            System.out.print("Running 2 jobs...");
            runThis(this::foo);
            runThis(this::bar);
            System.out.println("complete.");
        }
    }

    void runThis(Runnable runme){
        runme.run();
    }

    void foo() {
        try {
            Thread.sleep(1317);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void bar() {
        try {
            Thread.sleep(1317);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
