package FirstBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String str = "2019-11-14";
        String pat = "\\d{4}-\\d{2}-\\d{2}";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(str);
        if(m.matches()){
            System.out.println(m.replaceAll("1"));
            System.out.println("ok");
        }else{
            System.out.printf("no");
        }

        if(Pattern.compile("[0-9]+").matcher("123456").matches()){
            System.out.println("all numbers");
        }else{
            System.out.println("not pure");
        }
    }
}
