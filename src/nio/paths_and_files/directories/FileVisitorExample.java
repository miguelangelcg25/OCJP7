package nio.paths_and_files.directories;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * List all directory files and subdirectories
 * @author miguelinux
 */
public class FileVisitorExample {
    
    public static void main(String[] args) {
        String homeDir = System.getProperty("home.dir");
        Path path = Paths.get(homeDir);
        
        try(DirectoryStream<Path> dirList = Files.newDirectoryStream(path)){
            for(Path p: dirList){
                System.out.println(p.getFileName());
            }
        }catch(IOException e){
            
        }
    }
    
}
