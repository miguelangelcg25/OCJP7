package de.vogella.concurrency.nonblocking.counter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miguelinux
 */
public class Main {
    private static int NTHREADS = 10;
    
    public static void main(String[] args) {
        final AtomicCounter number = new AtomicCounter();
        ExecutorService threadPool = Executors.newFixedThreadPool(NTHREADS);
        List<Future<Integer>> resultList = new ArrayList<>();
        
        for(int i = 0; i < 500; i++){
            Callable<Integer> task = new Callable<Integer>(){                
                @Override
                public Integer call() throws Exception{
                    int result = number.increment();
                    System.out.println(number.getValue());
                    return result;
                }
            };
            Future<Integer> submit = threadPool.submit(task);
            resultList.add(submit);
        }
        
        threadPool.shutdown();
        while(!threadPool.isTerminated());
        
        Set<Integer> set = new HashSet<>();
        for(Future f: resultList){
            try {
                set.add((Integer) f.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(resultList.size() != set.size()){
            throw new RuntimeException("Duplicated values!");
        }
    }
}
