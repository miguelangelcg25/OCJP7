package nio.paths_and_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelica Medina
 */
public class FileOperations {
    
    public static void main(String[] args) {
        Path one = Paths.get("c:\\temp\\test1");            //exists
        Path two = Paths.get("c:\\temp\\test2.txt");        //exists
        Path target = Paths.get("c:\\temp\\test23.txt");    //doesn't yet exist
        
        try {
            Files.copy(one, target);
            Files.copy(two, target, StandardCopyOption.REPLACE_EXISTING);   //if no copy option is specified then throws FileAlreadyExistsException
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
