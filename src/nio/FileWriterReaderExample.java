package nio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Migue
 */
public class FileWriterReaderExample {
    
    public static void main(String[] args) {
        try {
            File file = new File("NewFile.txt");    //Just an object, doesn't create the file in disk
            boolean newFile;
            
            System.out.println("File exists? " + file.exists());
            newFile = file.createNewFile();
            System.out.println("Created new File? " + newFile);
            System.out.println("File exists? " + file.exists());
            //1st time run -> false true true
            //2nd time run -> true false true   
        } catch (IOException ex) {
            Logger.getLogger(FileWriterReaderExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //write and read a file
        System.out.println();
        File anotherFile = new File("TextFile.txt");

        try (FileWriter out = new FileWriter(anotherFile);
             FileReader in = new FileReader(anotherFile)) {
            
            //FileWriter line break must be manually specified
            out.write("howdy\nfolks!\n");
            out.flush();  
            //out.close();  try catch wit resources closes it automatically
            
            char buffer[] = new char[50];
            int size = in.read(buffer);            
            System.out.println(size + " characters readed");
            
            //Read char by char
            for (char c : buffer) {
                System.out.print(c);
            }            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }        
    }    
}