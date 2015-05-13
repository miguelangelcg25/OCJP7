package nio.paths_and_files.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 *
 * @author miguelangel
 */
public class PosixFileAttributesExample {

    public static void main(String[] args) throws IOException {
        //NIO.2 - Attibutes Interfaces (update)
        //POSIX file system
        Path path = Paths.get("/tmp/test.txt");
        Files.createFile(path);
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
        Set<PosixFilePermission> permissions = posix.permissions();
        System.out.println("group = " + posix.group());
        System.out.println("permissions = " + permissions);
        permissions = PosixFilePermissions.fromString("rwxr-xr--");
        Files.setPosixFilePermissions(path, permissions);
        System.out.println("new permissions = " + permissions);
        Files.delete(path);
    }
}
