package br.softrock.sendtweetstoqueue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dlemos on 03/04/17.
 */

class Utils {
    static String cleanFluff(String subjectText) {
        // Remove the stupid extra fluff the youtube app include
        Pattern p = Pattern.compile("\"(.*)\"");
        try {
            Matcher m = p.matcher(subjectText);
            if (m.find()) {
                subjectText = m.group(1);
            }
        } catch (NullPointerException e) {
            subjectText = "";
        }

        return subjectText;
    }
}
