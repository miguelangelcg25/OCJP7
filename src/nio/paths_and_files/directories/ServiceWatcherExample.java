package nio.paths_and_files.directories;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Watch a directory for changes delete/create/modify
 * @author miguelangel
 */
public class ServiceWatcherExample {
    
    public static void main(String[] args) throws IOException {
        String homeDir = System.getProperty("user.home");
        Path path = Paths.get(homeDir);
        WatchService watcher = FileSystems.getDefault().newWatchService();
        
        path.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
        
        while(true){
            WatchKey key = null;
            
            try {
                key = watcher.take();   //wait for an event
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceWatcherExample.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(WatchEvent<?> event: key.pollEvents()){
                WatchEvent.Kind<?> kind = event.kind();     //create/delete/modify
                System.out.println(kind.name() + " " + kind.type());
                System.out.println("directory/file: " + event.context().toString());    //file/directory name
            }
            key.reset();    //keep looking for errors
        }
    }
    
}