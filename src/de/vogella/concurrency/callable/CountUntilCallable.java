package de.vogella.concurrency.callable;

import java.util.concurrent.Callable;

/**
 *
 * @author miguelinux
 */
public class CountUntilCallable implements Callable {
    private long countUntil;

    public CountUntilCallable(long countUntil) {
        this.countUntil = countUntil;
    }
    
    @Override
    public Object call() throws Exception {
        long sum = 0;
        
        for(int i = 0; i < countUntil; i++){
            sum += i;
        }
        return sum;
    }
    
}
