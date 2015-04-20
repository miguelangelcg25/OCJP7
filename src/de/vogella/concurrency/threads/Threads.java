package de.vogella.concurrency.threads;

import de.vogella.concurrency.CountUntilRunnable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguelinux
 */
public class Threads {
    
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        
        for(int i = 0; i < 500; i++){
            Runnable task = new CountUntilRunnable(1_000L + i);
            Thread worker = new Thread(task);
            worker.setName(String.valueOf(i));
            worker.start();
            threadList.add(worker);
        }
        
        int running;
        
        do{
            running = 0;
            
            for(Thread t: threadList){
                if(t.isAlive()){
                    running++;
                }
            }
            System.out.println("We have " + running + " running threads.");
        }while (running > 0);
    }
}
