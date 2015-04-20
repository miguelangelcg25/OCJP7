package de.vogella.concurrency;

/**
 *
 * @author miguelinux
 */
public class CountUntilRunnable implements Runnable {
    
    private long countUntil;
    
    public CountUntilRunnable(long countUntil){
        this.countUntil = countUntil;
    }
    
    @Override
    public void run() {
        long sum = 0;
        
        for(long i = 0; i < countUntil; i++){
            sum += i;
        }
        System.out.println("The result is " + sum);
    }
    
    
    
}
