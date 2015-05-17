package nio.paths_and_files.directories;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * List all directory files and subdirectories
 * @author miguelinux
 */
public class FileVisitorExample {
    
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        Path path = Paths.get(homeDir);
        
        //DirectoryStream Interface - lists all files and directories
        try(DirectoryStream<Path> dirList = Files.newDirectoryStream(path)){
            for(Path p: dirList){
                //System.out.println(p.getFileName());
            }
        }catch(IOException e){
            
        }
        
        //SimpleFileVisitor Interface - list all files and subdirectories recursivelly
        SimpleFileVisitorExample fileVisitor = new SimpleFileVisitorExample();
        try {
            Files.walkFileTree(path, fileVisitor);
        } catch (IOException ex) {
            Logger.getLogger(FileVisitorExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
