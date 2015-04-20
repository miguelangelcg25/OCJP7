package de.vogella.concurrency.threadpools;

import de.vogella.concurrency.CountUntilRunnable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelinux
 */
public class ThreadPools {
    private static final int NTHREADS = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(NTHREADS);
        
        for(int i = 0; i < 500; i++){
            Runnable task = new CountUntilRunnable(1_000L);
            threadPool.execute(task);
        }
        
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(300, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadPools.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Finished all threads");
    }
}
