package regexp;

import java.util.*;
import java.util.regex.*;

class ReplacementExample {

    static Map props = new HashMap();

    static {
        props.put("key1", "fox");
        props.put("key2", "dog");
    }

    public static void main(String[] args) {
        String input = "The quick brown ${key1} jumps over the lazy ${key2}.";

        Pattern p = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, (String)props.get(m.group(1)));
            //sb.append(props.get(m.group(1)));
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
        
        //email example
        System.out.println("\n---Email example---");
        String emailRegExp = "([a-zA-Z0-9]+@)([a-zA-Z]+)(\\.[a-zA-Z]+)";
        String email = "miguelangelcg25@gmail.com";
        Pattern pattern = Pattern.compile(emailRegExp);
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.find()){
            System.out.print(matcher.start() + " ");
            System.out.println(matcher.replaceAll("$1xxx$3"));
        }
        System.out.println(matcher.matches());
        matcher.reset();
        
        if(matcher.matches()){
            System.out.print(matcher.start() + " ");
            System.out.println(matcher.replaceAll("$1xxx$3"));
        }
        System.out.println(matcher.matches());
        matcher.reset();
    }
}
