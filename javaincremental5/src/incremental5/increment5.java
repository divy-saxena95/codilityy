package incremental5;

import java.util.regex.*;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * Using the documentation for java.util.regex.Pattern as a resource,
 * write and test a regular expression that checks a sentence to see that it begins with a capital letter
 * and ends with a period.
 */
public class increment5 {

    public static void main(String[] args) {
        // starts with any capital A through Z
        // then zero or more of any char except endline
        // ends with .
        String sen = "^[A-Z].*[\\.]$";
        String s1 = "Once upon a time.";
        String s2 = "abcd.";
        String s3 = "Abcd?";
        String s4 = "An easy way out.";
        String s5 = "Zorro.";
        String s6 = "X.";
        System.out.println(s1.matches(sen));
        System.out.println(s2.matches(sen));
        System.out.println(s3.matches(sen));
        System.out.println(s4.matches(sen));
        System.out.println(s5.matches(sen));
        System.out.println(s6.matches(sen));
    }
}