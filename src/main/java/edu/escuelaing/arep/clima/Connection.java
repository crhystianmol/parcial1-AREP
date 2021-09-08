package edu.escuelaing.arep.clima;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection  {

    private String url, key;

    public Connection() {
        url = "http://api.openweathermap.org/data/2.5/weather?q=";
        key = "9a178544af29bf829d31c7dcaf790d56";

    }

    public void getWeather(String ciudad) throws Exception {

        try {
            System.out.println("Hola");
            URL obj = new URL(url + ciudad + "&appid=" + key);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            System.out.println(con.getResponseCode());
            StringBuffer response = null;
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Holiii");
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("holaa");
            }
            url= String.valueOf(response);
        } catch (MalformedURLException ex) {
            throw new Exception(ex.getMessage());
        } catch (IOException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    public String getURL(){
        return url;
    }
}