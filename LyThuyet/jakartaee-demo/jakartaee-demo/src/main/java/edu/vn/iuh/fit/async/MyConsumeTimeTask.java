package edu.vn.iuh.fit.async;

import jakarta.servlet.AsyncContext;

import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class MyConsumeTimeTask implements Runnable{
    private AsyncContext asyncContext;
    private PrintWriter writer;

    public MyConsumeTimeTask(AsyncContext asyncContext, PrintWriter writer) {
        this.asyncContext = asyncContext;
        this.writer = writer;
    }

    @Override
    public void run() {
        String msg = task();
        writer.println(msg);
        asyncContext.complete();
    }
    private String task () {
        long start = System.currentTimeMillis();
        try {
            int i = ThreadLocalRandom.current()
                    .nextInt(1, 5);
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "time to complete long task " + (System.currentTimeMillis() - start);
    }
}
