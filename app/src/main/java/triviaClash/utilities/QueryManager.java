package triviaClash.utilities;

import java.util.HashMap; 
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import triviaClash.Data.RequestMethod;

public class QueryManager {
    private String finalQueryString = "";
    private static String sessionToken = ""; 
    private ConnectionManager manager = new ConnectionManager();
    
    public Map<Integer,Map<Integer, String>> getCategories() {
        Map<Integer, Map<Integer, String>> categories = new HashMap<Integer, Map<Integer, String>>();
        manager.connect("https://opentdb.com/api_category.php",RequestMethod.GET);
        JSONArray myArray = manager.getJsonData().getJSONArray("trivia_categories");
        JSONObject obj;
        for(int i = 0; i < myArray.length(); i++) {
            Map<Integer, String> temp = new HashMap<Integer, String>();
            obj = myArray.getJSONObject(i);
            temp.put(obj.getInt("id"), obj.getString("name"));
            categories.put(i+1, temp);
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

    public String getQueryString(int amount, int category, String token, String difficulty) {
        StringBuilder temp = new StringBuilder("https://opentdb.com/api.php?");
        temp.append("amount="+amount+"&");
        temp.append("category="+category+"&");
        temp.append("difficulty="+difficulty);
        finalQueryString = temp.toString();
        return finalQueryString;
    }

    public void resetSessionToken() {
        sessionToken = "";
    }
}
