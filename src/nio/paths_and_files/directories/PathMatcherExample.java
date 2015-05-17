package nio.paths_and_files.directories;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Lists all java files under the NetBeansProject directory
 * @author miguelangel
 */
public class PathMatcherExample extends SimpleFileVisitor<Path>{
    
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/NetBeansProjects/**.java");
    
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs){
        if(matcher.matches(path)){
            System.out.println("file: " + path.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
    
    public static void main(String[] args) throws IOException {
        String homeDir = System.getProperty("user.home");
        PathMatcherExample matcherExample = new PathMatcherExample();
        Files.walkFileTree(Paths.get(homeDir), matcherExample);
    }
}
