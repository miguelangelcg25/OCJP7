package de.vogella.concurrency.nonblocking.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author miguelinux
 */
public class AtomicCounter {
    private AtomicInteger atomicNumber = new AtomicInteger();
    
    public int getValue(){
        return atomicNumber.get();
    }
    
    public int increment(){
        return atomicNumber.incrementAndGet();
    }
    
    public int incrementExplicitVersion(){
        int oldValue = atomicNumber.get();
        
        while(!atomicNumber.compareAndSet(oldValue, oldValue + 1)){
            oldValue = atomicNumber.get();
        }
        return oldValue;
    }
}
