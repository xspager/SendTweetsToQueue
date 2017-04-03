package br.softrock.sendtweetstoqueue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dlemos on 03/04/17.
 */

public class Utils {
    public static String cleanFluff(String subjectText) {
        // Remove the stupid extra fluff the youtube app include
        Pattern p = Pattern.compile("\"(.*)\"");
        Matcher m = p.matcher(subjectText);
        if (m.find()) {
            subjectText = m.group(1);
        }
        return subjectText;
    }
}
