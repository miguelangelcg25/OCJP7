package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        File subDirectories = new File(myDir, "subdir1\\subdir2\\subdir3\\");
        subDirectories.mkdirs(); //creates directory and all subdirectories
        System.out.println(subDirectories.getAbsolutePath() + " subdirectories created\n");
        
        //creates file under myDir directory
        File file = new File(subDirectories, "BufferedWriterTest.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File created under " + file.getAbsoluteFile());
            } catch (IOException ex) {
                Logger.getLogger(BufferedWriterReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //BufferedWriter example
        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){    //wraps writer object
            
            bufferedWriter.write("howdy");
            bufferedWriter.newLine();
            bufferedWriter.write("folks!");
            bufferedWriter.newLine();
            bufferedWriter.flush();            
        }catch(IOException e){
            Logger.getLogger(BufferedWriterReader.class.getName()).log(Level.SEVERE, "Error!", e);
        }
        
        //PrintWriter example
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))){
            printWriter.println("PrintWriter message");
            printWriter.println();
            
            int i = 5;
            double d = 1_000d;
            printWriter.printf("i = %d d = %f", i, d);
            printWriter.flush();
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
        
        //rename a file, it's the same for directories
        System.out.println();
        String oldName = file.getName();
        File newFileName = new File(subDirectories, "anotherFileName.txt");
        file.renameTo(newFileName);
        System.out.println(file.getName() + " exists? " + file.exists());
        System.out.println(newFileName.getName() + " exists? " + newFileName.exists());
        
        //delete directories and files
        boolean deleteSub = subDirectories.delete();
        System.out.println("Non empty directories can't be deleted, deleteSub = " + deleteSub);
        newFileName.delete();
        File fileDir = newFileName.getParentFile();
        
        deleteSub = fileDir.delete();
        System.out.println("deleteSub = " + deleteSub);
    }
    
}