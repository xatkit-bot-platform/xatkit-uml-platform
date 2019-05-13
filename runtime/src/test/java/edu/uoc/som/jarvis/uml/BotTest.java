package edu.uoc.som.jarvis.uml;

import edu.uoc.som.jarvis.Jarvis;

public class BotTest {

    public static void main(String[] args) throws InterruptedException {
        Jarvis.main(new String[]{"<path of .properties file>"});

        Thread.sleep(100000000);
    }
}
