package nio.paths_and_files.attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author miguelangel
 */
public class BasicFileAttributesExample {
    
    public static void main(String[] args) throws IOException {
        //Old API
        System.out.println("Old I/O - File");
        Date date = new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime();
        File old = new File("/tmp/test.txt");
        old.createNewFile();
        System.out.println("isReadable = " + old.canRead());
        System.out.println("isWriteable = " + old.canWrite());
        System.out.println("isExecutable = " + old.canExecute());
        System.out.println("lastModifiedTime = " + old.lastModified());
        
        old.setLastModified(date.getTime());
        System.out.println("new lastModifiedTime = " + old.lastModified());
        old.delete();
        
        //NIO.2 - Files class
        System.out.println("\nNIO.2 - Files class");
        Path path = Paths.get("/home/miguelangel/test.txt");
        Files.createFile(path);
        System.out.println("isReadable = " + Files.isReadable(path));
        System.out.println("isWriteable = " + Files.isWritable(path));
        System.out.println("isExecutable = " + Files.isExecutable(path));
        System.out.println("lastModifiedTime = " + Files.getLastModifiedTime(path));
        
        FileTime fileTime = FileTime.fromMillis(date.getTime());
        Files.setLastModifiedTime(path, fileTime);
        System.out.println("new lastModifiedTime = " + Files.getLastModifiedTime(path));
    }
}