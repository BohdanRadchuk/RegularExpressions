package controller.util;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    public static boolean checkInputToRegex (String regex, String input){
        System.out.println(regex + " - regex, " + input + " - input");
        boolean asd = Pattern.matches(regex, input);
        System.out.println(asd);
        return asd;
    }
}
