package de.vogella.concurrency.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelinux
 */
public class FuturesAndCallables {
    private static int NTHREADS = 10;
    
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(NTHREADS);
        List<Future<Long>> resultList = new ArrayList<>();
        
        for(int i = 0; i < 500; i ++){
            Callable<Long> task = new CountUntilCallable(1000_000L + i);
            Future<Long> submit = threadPool.submit(task);
            resultList.add(submit);
        }
        
        long sum = 0;
        
        for(Future<Long> result: resultList){
            try {
                sum += result.get();
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(FuturesAndCallables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("The result is " + sum);
        threadPool.shutdown();
    }
    
}
