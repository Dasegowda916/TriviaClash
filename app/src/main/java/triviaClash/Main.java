package triviaClash;

import org.json.JSONObject;

import triviaClash.Data.RequestMethod;
import triviaClash.utilities.ConnectionManager;

public class Main {
    public static void main(String args[]) {
        ConnectionManager conman = new ConnectionManager(); 
        conman.connect("https://opentdb.com/api.php?amount=4",RequestMethod.GET);
        System.out.println(conman.getJsonData());
    }
}
