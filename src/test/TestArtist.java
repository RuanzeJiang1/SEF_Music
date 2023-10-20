package test;

import java.io.ByteArrayInputStream;
import java.io.IOException;


import bean.Artist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// set test execution order
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestArtist {

    @Test
    public void testVaildID() throws IOException {
        // test date
        String input = "555AAAAA!@\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022, The Best Song in the world";
        // set ByteArrayInputStream to analog user input
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        // create new Artist object and call the addArtist method
        Artist artist = new Artist();
        boolean result1 = artist.addArtist();

        String input2 = "555BBBBB!@\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream2);
        Artist artist2 = new Artist();
        boolean result2 = artist2.updateArtist();
        // use the assertTrue method to validate the results of the addArtist and updateArtist methods
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void testInvaildID() throws IOException {
        String input = "555AAAAA_A\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Artist artist = new Artist();
        boolean result1 = artist.addArtist();

        String input2 = "555BBBBB_B\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream2);
        Artist artist2 = new Artist();
        boolean result2 = artist2.updateArtist();
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void testInvaildAddress() throws IOException {
        String input = "555AAAAA__\n" +
                "jrz\n" +
                "MelbourneVIC\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Artist artist = new Artist();
        boolean result1 = artist.addArtist();

        String input2 = "555AAAAA__\n" +
                "jrz\n" +
                "MelbourneVICAustralian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream2);
        Artist artist2 = new Artist();
        boolean result2 = artist2.updateArtist();
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void testInvaildBio() throws IOException {
        String input = "555AAAAA__\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Artist artist = new Artist();
        boolean result1 = artist.addArtist();

        String input2 = "555AAAAA__\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was test case Q W E R T Y U I O P A S D F G H J K L Z X C V B N M Q W E R T Y U I O P A S D F G H J K L Z X C V B N M M Q W E R T Y U I O P \n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream2);
        Artist artist2 = new Artist();
        boolean result2 = artist2.updateArtist();
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void testInvaildGenre() throws IOException {
        String input = "555AAAAA__\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "classical\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Artist artist = new Artist();
        boolean result1 = artist.addArtist();

        String input2 = "555AAAAA__\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop\n" +
                "2022,The Best Song in the world";
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream2);
        Artist artist2 = new Artist();
        boolean result2 = artist2.updateArtist();
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    public void testInvaildAwards() throws IOException {
        String input = "555AAAAA__\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,Best Song";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        Artist artist = new Artist();
        boolean result1 = artist.addArtist();

        String input2 = "555AAAAA__\n" +
                "jrz\n" +
                "Melbourne|VIC|Australian\n" +
                "20-10-1999\n" +
                "This document was used for test cases test cases test cases test cases\n" +
                "singer,song writer\n" +
                "pop,classical\n" +
                "2022,The Best Song in the world world world world world world world world";
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream2);
        Artist artist2 = new Artist();
        boolean result2 = artist2.updateArtist();
        assertTrue(result1);
        assertTrue(result2);
    }

}
