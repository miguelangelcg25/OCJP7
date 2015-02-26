package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Migue
 */
public class RegExp {
    
    public static void main(String[] args) {
        String word = "w2w w$ $#w2";
        regexpTest("\\b", word);
        System.out.println("");
        regexpTest("\\B", word);
        
        word = "0x 0X0 x0g 0xcafe 0 0x54";
        regexpTest("0[xX]([a-fA-f0-9])+", word);
        
        word = "proj1model.txt,proj3.txt,proj1,test.doc,proj1.java";
        regexpTest("proj1([^,])*", word);
        
        word = "xyxxyyyxx";
        regexpTest(".*xx", word);   //greedy quatifier
        regexpTest(".*?xx", word);   //reluctant quatifier
    }
    
    public static void regexpTest(String pattern, String word){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(word);
        
        System.out.println(word);
        System.out.println("01234567890123467890");
        
        while(matcher.find()){
            System.out.print(matcher.start()+" ");
            System.out.println(matcher.group());
        }
        
        System.out.println("");
    }
}
