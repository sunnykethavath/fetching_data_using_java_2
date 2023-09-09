package org.example;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String myUrl = "https://api.zippopotam.us/us/33162";
        try {
            URL url = new URL(myUrl);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            int responseCode = connect.getResponseCode();

            if(responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                StringBuilder apiData = new StringBuilder();
                String line;

                while((line = in.readLine()) != null){
                    apiData.append(line);
                }
                in.close();

                JSONObject jsonObj = new JSONObject(apiData.toString());
                System.out.println(jsonObj);
            }else{
                System.out.println("Failed to fetch data. HTTP Response Code: " + responseCode);
            }
            connect.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}