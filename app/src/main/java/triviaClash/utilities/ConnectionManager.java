package triviaClash.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI; 
import java.net.HttpURLConnection; 
import triviaClash.Data.RequestMethod;
import triviaClash.Data.CommandMode; 

import org.json.JSONObject; 

public class ConnectionManager {
    
    private URI uri;
    private JSONObject jsonData; 
    private HttpURLConnection connection;
    private int responseCode; 
    private boolean connected = false;

    public boolean connect(String url, RequestMethod method) {
        try {
            uri = new URI(url);
            connection = (HttpURLConnection) this.uri.toURL().openConnection();
            connection.setRequestMethod(method.name());
            responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                connected = true;
                System.out.printf("\n\n> HTTP Connection successful, Response code : %d \n\n", responseCode);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                this.connected = true;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                jsonData = new JSONObject(response.toString());
            }
        } catch(Exception e) {
            OutputManager.SOP("Sorry, connection failed with the following error...\n", CommandMode.CMD_LINE);
            e.printStackTrace();
        } 

        if(connected) {
            if(jsonData.has("response_code")) {
                System.out.println(jsonData+" \nhas response code : "); 
                switch(jsonData.getInt("response_code")) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Sorry, no results for the query...");
                    case 2:
                        System.out.println("Invalid parameter...");
                    case 3:
                        System.out.println("Token is likely to be expired or invalid...");
                    case 4:
                        System.out.println("Please reset the token!!");
                    case 5:
                        System.out.println("Too many requests...");
                }
            }
        }
        return connected;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }
}
