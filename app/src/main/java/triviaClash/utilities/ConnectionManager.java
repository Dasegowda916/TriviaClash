package triviaClash.utilities;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.net.URL; 
import java.net.HttpURLConnection; 

import triviaClash.Data.GameData.ResponseCodes;
import triviaClash.Data.RequestMethod;
import triviaClash.Data.CommandMode; 

import org.json.JSONObject; 

public class ConnectionManager {
    
    private URL url;
    private JSONObject jsonData; 
    private HttpURLConnection connection;
    private int responseCode; 
    private boolean connected = false;

    public HttpURLConnection connect(String url, RequestMethod method) {
        try {
            this.url = new URL(url);
            connection = (HttpURLConnection) this.url.openConnection();
            connection.setRequestMethod(method.name());
            responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
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
        
        switch(jsonData.getInt("response_code")) {
            case 0:
                System.out.println("connection success...");
                connected = true;
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
            default:
                System.out.println("Some unexpected error has occured !!");
                connected = false;
                return null;
        }
        return connection;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }

    public boolean isConnected() {
        return this.connected;
    }
}
