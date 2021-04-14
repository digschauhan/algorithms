package src.com;

import java.util.regex.Pattern;

public class StringUtils {

    public static void main(String[] args) {
        String s = "this is a sample text to @ and .com http://abc.xyz.com check pattern or any string manipulation";

        String regex = ".@.";
        boolean result = Pattern.matches(regex, s);

        System.out.println(result);
    }
    
}
