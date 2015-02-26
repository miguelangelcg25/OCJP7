package regexp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Migue
 */
public class ScannerExample {
    
    public static void main(String[] args) {
        String token = "mcg";
        String text = "usu mcg99ds#mcgjjj";
        System.out.println("Scanner search: ");
        Scanner scanner = new Scanner(text);

        //Scanner search
        while((token = scanner.findInLine(token)) != null){
            System.out.println("found: " + token);
        }   
        System.out.println("--End scanner search--\n");
        
        //Scanner tokenizing
        text = "1 true 342 hi";
        scanner = new Scanner(text);
        
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                System.out.println("int = " + scanner.nextInt());
            }else if(scanner.hasNextBoolean()){
                System.out.println("boolean = " + scanner.nextBoolean());
            }else{
                System.out.println("next = " + scanner.next());
            }
        }
        
        System.out.println("--End scanner tokenizing--\n");
        
        String a = "1 a2 b 3 c4d 5e";
        String vec [] = a.split("\\d");
        System.out.println(vec.length);
        
        for (String vec1 : vec) {
            System.out.print(">"+vec1+"< ");
        }
    }
    
}