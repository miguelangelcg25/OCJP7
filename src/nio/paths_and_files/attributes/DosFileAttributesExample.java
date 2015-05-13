package nio.paths_and_files.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 *
 * @author miguelangel
 */
public class DosFileAttributesExample {
    
    public static void main(String[] args) throws IOException {
        //NIO.2 - Attributes Interfaces (read)
        Path path = Paths.get("/tmp/test.txt");
        Files.createFile(path);
        System.out.println("\nNIO.2 - Read basic attributes");
        BasicFileAttributes basic = Files.readAttributes(path, BasicFileAttributes.class);  //throws IOException
        FileTime creationTime = basic.creationTime();
        FileTime lastModifiedTime = basic.lastModifiedTime();
        FileTime lastAccessTime = basic.lastAccessTime();
        System.out.println("creationTime = " + creationTime);
        System.out.println("lastModifiedTime = " + lastModifiedTime);
        System.out.println("lastAccessTime = " + lastAccessTime);
                
        //NIO.2 - Attibutes Interfaces (update)
        //DOS file system
        System.out.println("\nNIO.2 - DOS file system");
        Files.setAttribute(path, "dos:readonly", false);
        Files.setAttribute(path, "dos:hidden", false);        
        DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("isReadOnly = " + dos.isReadOnly());
        System.out.println("isHidden = " + dos.isHidden());
        Files.setAttribute(path, "dos:readonly", true);
        Files.setAttribute(path, "dos:hidden", true); 
        dos = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("isReadOnly = " + dos.isReadOnly());
        System.out.println("isHidden = " + dos.isHidden());
        
        //DosFileAttributeView
        System.out.println("\nDosFileAttributeView");
        DosFileAttributeView dosView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosView.setReadOnly(false);
        dosView.setHidden(false);
        dos = dosView.readAttributes();
        System.out.println("setReadOnly = " + dos.isReadOnly());
        System.out.println("setHidden = " + dos.isHidden());
        Files.delete(path);
    }
}
