package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angelica Medina
 */
public class BufferedWriterReader {
    
    public static void main(String[] args) {
        File myDir = new File("myDir");
        myDir.mkdir();  //creates myDir directory
        System.out.println(myDir.getPath() + " directory created");
        
        File subDirectories = new File("myDir/subdir1/subdir2");
        subDirectories.mkdirs(); //creates directory and all subdirectories
        System.out.println(subDirectories.getPath()+ " subdirectories created");
        
        //creates file under myDir directory
        File file = new File(myDir, "BufferedWriterTest.txt");
        System.out.println("File created under " + file.getAbsoluteFile());
        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){    //wraps writer object
            
            bufferedWriter.write("howdy");
            bufferedWriter.newLine();
            bufferedWriter.write("folks!");
            
        }catch(IOException e){
            Logger.getLogger(BufferedWriterReader.class.getName()).log(Level.SEVERE, "Error!", e);
        }
        
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);){
            String line;
            
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            Logger.getLogger(BufferedWriterReader.class.getName()).log(Level.SEVERE, "Error!", e);
        }
        
    }
    
}