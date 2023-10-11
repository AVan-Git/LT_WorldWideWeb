package edu.vn.iuh.fit.async;


import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "myAsyncServlet", urlPatterns = {"/async-test"},
                    asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new MyAsyncListener());

        asyncContext.start(new MyConsumeTimeTask(asyncContext,writer));

        /*asyncContext.start(new Runnable() {
            @Override
            public void run () {
                String msg = task();
                writer.println(msg);
                asyncContext.complete();
            }
        });*/
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