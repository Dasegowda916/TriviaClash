package triviaClash.utilities;

import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import triviaClash.utilities.ConnectionManager;
import triviaClash.Data.RequestMethod;

public class QueryManager {
    private String finalQueryString = "";
    private static String sessionToken = ""; 
    private ConnectionManager manager = new ConnectionManager();
    
    public Map<Integer, String> getCategories() {
        Map<Integer, String> categories = new HashMap<Integer, String>();
        manager.connect("https://opentdb.com/api_category.php",RequestMethod.GET);
        JSONArray myArray = manager.getJsonData().getJSONArray("trivia_categories");
        JSONObject obj;
        for(int i = 0; i < myArray.length(); i++) {
            obj = myArray.getJSONObject(i);
            categories.put(obj.getInt("id"), obj.getString("name"));
        }

        return categories;
    }

    public String getSessionToken() {
        if(sessionToken == "") {
            manager.connect("https://opentdb.com/api_token.php?command=request",RequestMethod.GET); 
            sessionToken =  manager.getJsonData().getString("token"); 
        }
        return sessionToken;
    }

    public String getQueryString(int amount, int category, String token) {
        StringBuilder temp = new StringBuilder("https://opentdb.com/api.php?");
        temp.append("amount="+amount+"&");
        temp.append("category="+category);
        finalQueryString = temp.toString();
        return finalQueryString;
    }

    public void resetSessionToken() {
        sessionToken = "";
    }
}
