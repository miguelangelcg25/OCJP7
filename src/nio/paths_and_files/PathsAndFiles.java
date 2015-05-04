package nio.paths_and_files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelica Medina
 */
public class PathsAndFiles {
    
    public static void main(String[] args) {
        Path dir = Paths.get("c:\\temp");
        
        if(!Files.exists(dir)){
            try {
                Files.createDirectory(dir);
            } catch (IOException ex) {
                Logger.getLogger(PathsAndFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(dir.getFileName() + " directory created");
        }else{
            System.out.println(dir.getFileName() + " directory already exists");
        }
        
        Path one = Paths.get("c:\\temp\\test1");            //exists
        Path two = Paths.get("c:\\temp\\test2.txt");        //exists
        Path target = Paths.get("c:\\temp\\test23.txt");    //doesn't yet exist
        
        try {
            if(Files.notExists(one)){
                Files.createFile(one);
                System.out.println(one.getFileName() + " file created");
            }else{
                System.out.println(one.getFileName() + " file already exists");
            }
            
            if(Files.notExists(two)){
                Files.createFile(two);
                System.out.println(two.getFileName() + " file created");
            }else{
                System.out.println(two.getFileName() + " file already exists");
            }
            
            Files.deleteIfExists(target);
        } catch (IOException ex) {
            Logger.getLogger(PathsAndFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Files.copy(one, target);
            System.out.println("Copied file " + one.getFileName() + " to target");
            
            //if no copy option is specified then throws FileAlreadyExistsException
            Files.copy(two, target, StandardCopyOption.REPLACE_EXISTING); 
            System.out.println("Copied file " + two.getFileName() + " to target");
            
            //list all files inside the directory
            //DirectoryStream must be closed or put into a try-with-resources
            try (DirectoryStream<Path> fileList = Files.newDirectoryStream(dir)) {
                System.out.println();
                
                for(Path p: fileList){
                    System.out.println(p.getFileName());
                }
            }
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(PathsAndFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Files.deleteIfExists(dir);            
        } catch (IOException ex) {
            try {
                System.out.println(dir.getFileName() + " directory must be empty before deleted");
                Files.deleteIfExists(one);
                Files.deleteIfExists(two);
                Files.deleteIfExists(target);
                System.out.println("All files deleted");
                Files.deleteIfExists(dir);
                System.out.println("Directory deleted");
            } catch (IOException ex1) {
                Logger.getLogger(PathsAndFiles.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
