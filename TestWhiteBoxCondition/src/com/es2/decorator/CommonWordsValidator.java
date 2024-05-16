package com.es2.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonWordsValidator extends Decorator {
    public CommonWordsValidator(AuthInterface auth) {
        super(auth);
    }

    public String getHTTPRequest(String word) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://owlbot.info/api/v4/dictionary/" + word);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
        conn.setRequestProperty("Authorization", "Token aa806373dd7557bd6901557afe5ed6373434acbf");
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        conn.disconnect();
        rd.close();
        return result.toString();
    }

    public void auth(String username, String password) throws AuthException, IOException {
        try {
            this.getHTTPRequest(password);
        } catch (IOException e) {
            throw new AuthException("Unauthorized");
        }

        super.auth(username, password);
    }
}
