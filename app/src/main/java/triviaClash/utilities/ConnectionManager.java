package triviaClash.utilities;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.net.URL; 
import java.net.HttpURLConnection; 

import triviaClash.Data.RequestMethod;

import org.json.JSONObject; 

public class ConnectionManager {
    
    private URL url;
    private JSONObject jsonData; 
    private HttpURLConnection connection;
    private int responseCode; 

    public HttpURLConnection connect(String url, RequestMethod method) {
        try {
            this.url = new URL(url);
            connection = (HttpURLConnection) this.url.openConnection();
            switch(method) {
                case GET:
                    connection.setRequestMethod("GET");
                    break;
                case POST:
                    connection.setRequestMethod("POST");
                    break;
                default:
                    connection.setRequestMethod("GET");
            }

            responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                jsonData = new JSONObject(response.toString());
            }
        } catch(Exception e) {
            System.out.println("Connection error !!");
        }
        return connection;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }
}
