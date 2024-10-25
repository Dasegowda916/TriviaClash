package triviaClash.utilities;

// Custom Classes
import triviaClash.Data.RequestMethod;

// Java built-in classes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL; 
import java.net.HttpURLConnection;
import org.json.JSONObject;
import org.json.HTTP;

public class ConnectionManager {
    private URL url;
    private int responseCode;
    private JSONObject responseData;
    private HttpURLConnection connection;
    

    public void connect(String url, RequestMethod method) {
        method = RequestMethod.GET;
        try {
            connection = (HttpURLConnection)this.url.openConnection();
            responseCode = connection.getResponseCode();
            if(responseCode == connection.HTTP_OK) {
                System.out.println("Connected successfully !!");
                switch(method) {
                case GET: 
                    System.out.println("Setting request method to GET...");
                    connection.setRequestMethod("GET");

                    StringBuilder responseString = new StringBuilder();
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                
                    String inputLine;
                    while((inputLine = in.readLine()) != null) {
                    responseString.append(inputLine);
                    }
                    responseData = new JSONObject(responseString.toString());
                    break;

                case POST:
                    System.out.println("Setting request method to POST...");
                    connection.setRequestMethod("POST");
                    break;
            
                default:
                    System.out.println("Using request method GET (default)...");
                    break;
                }
            } else {
                System.out.println("Connection failed !!");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong !!\n" + e.getStackTrace());

        }
    } 

    public JSONObject fetchData() {
        return responseData;
    }
}
