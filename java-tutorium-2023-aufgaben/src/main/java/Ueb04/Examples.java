package Ueb04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Examples {

    public static void main(String[] args) {

        String s1 = "Hallo";
        String s2 = "Hallo";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = "Hallo, Du!";
        s1 = s1 + ", Du!";
        System.out.println(s1);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        String s = "a";
        char c = 'a';

        System.out.println(c + 1);
        System.out.println((char)(c + 1));

        System.out.println((char)48);

        String str = "Feine msditKzwef Kalbsleberwurst mksiuzteedk";
        char character = str.charAt(str.length() - 1);
        System.out.println(character);
        char[] charArr = str.toCharArray();

        System.out.println(str.contains("leber"));

        System.out.println(str.toLowerCase());

        System.out.println(str);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                count++;
            }
            System.out.println(str.charAt(i));
        }
        System.out.println("Anzahl von e: " + count);

        System.out.println(str.indexOf('e'));

        String searchTerm = "Kalbsleberwurst";
        int startIndex = str.indexOf(searchTerm);
        int endIndex = startIndex + searchTerm.length();
        System.out.println(startIndex);
        String kalbsleberwurst = str.substring(startIndex, endIndex);
        System.out.println(kalbsleberwurst);

        String wurst1 = "Feine msditKzwef Kalbsleberwurst mksiuzteedk";
        String wurst2 = "Kalbsleberwurst";
        String wurst3 = "Feine msditKzwef wurst mksiuzteedk";
        Pattern pattern = Pattern.compile("^[a-zA-Z]+wurst$");
        Matcher matcher = pattern.matcher(wurst1);
        System.out.println(matcher.find());

    }

}
