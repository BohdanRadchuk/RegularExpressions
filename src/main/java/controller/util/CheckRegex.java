package controller.util;

import java.util.regex.Pattern;

public class CheckRegex {
    public static boolean checkRegexToInput(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
