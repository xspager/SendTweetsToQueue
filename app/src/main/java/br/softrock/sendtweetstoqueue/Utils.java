package br.softrock.sendtweetstoqueue;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    static String expandURL(String url_string) {
        Pattern p = Pattern.compile("https://youtu.be/(.*)");
        try {
            Matcher m = p.matcher(url_string);
            if (m.find()) {
                return String.format("https://www.youtube.com/watch?v=%s", m.group(1));
            }
        } catch (Exception e) {
            // do nothing
        }
        return url_string;
    }

    static String formatTweetURL(String originalMessage) {

        String originalMessageEscaped = null;
        try {
            originalMessageEscaped = String.format(
                    "https://twitter.com/intent/tweet?source=webclient&text=%s",
                    URLEncoder.encode(originalMessage, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return originalMessageEscaped;
    }

}
