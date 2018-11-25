package cit360httpurl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpURLExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public void sendGet() throws Exception {
        URL object = new URL("https://icanhazdadjoke.com/");
        HttpURLConnection connect = (HttpURLConnection) object.openConnection();

        connect.setRequestMethod("GET");
        connect.setRequestProperty("User-Agent", USER_AGENT);
        connect.setRequestProperty("X-Requested-With", "Curl");
        connect.addRequestProperty("Accept", "text/plain");

        int respond_code = connect.getResponseCode();

        if (respond_code == 200) {

            BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String line = null;

            while((line = input.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println();

        } else {
            System.out.println("Oh no! The Dad Joke site seems to have an issue!\n");
        }

        connect.disconnect();
    }
}
