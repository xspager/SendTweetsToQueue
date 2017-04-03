package br.softrock.sendtweetstoqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dlemos on 03/04/17.
 */

public class UtilsTest {
    @Test
    public void happyTest() throws Exception {
        String subjectText = "Watch \"Descomplica: Estudar para o ENEM agora é Online!\" on YouTube";

        String result = Utils.cleanFluff(subjectText);

        assertEquals("Descomplica: Estudar para o ENEM agora é Online!", result);
    }

    @Test
    public void emptyString() throws Exception {
        String subjectText = "";

        String result = Utils.cleanFluff(subjectText);

        assertEquals("", result);
    }

    @Test
    public void nullString() throws Exception {
        String subjectText = null;

        String result = Utils.cleanFluff(subjectText);

        assertEquals("", result);
    }

    @Test
    public void noFluff() throws Exception {
        String subjectText = "Descomplica: Estudar para o ENEM agora é Online!";

        String result = Utils.cleanFluff(subjectText);

        assertEquals("Descomplica: Estudar para o ENEM agora é Online!", result);
    }

    @Test
    public void testExpandURL() throws Exception {
        String url = "https://youtu.be/6xd_ZAPZIDk";

        String result = Utils.expandURL(url);

        assertEquals("https://www.youtube.com/watch?v=6xd_ZAPZIDk", result);
    }
}