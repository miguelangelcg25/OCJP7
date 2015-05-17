package nio.paths_and_files.directories;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author miguelangel
 */
public class SimpleFileVisitorExample extends SimpleFileVisitor<Path>{
    
    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs){
        if(path.getFileName().toString().startsWith(".")){ 
            return FileVisitResult.SKIP_SUBTREE;
        }
        
        System.out.println("pre dir: " + path.getFileName());
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException exception){
        System.out.println("post dir: " + path.getFileName());
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs){
        if(!path.getFileName().toString().startsWith(".")){
            System.out.println("  file: " + path.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult visitFileFailed(Path path, IOException exception){
        System.out.println("Error: " + exception.getLocalizedMessage());
        return FileVisitResult.CONTINUE;
    }

}
