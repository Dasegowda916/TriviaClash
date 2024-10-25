package triviaClash;

import triviaClash.utilities.ConnectionManager;
import triviaClash.Data.RequestMethod;

import org.json.JSONObject;

public class Main {
    public static void main(String args[]) {
        ConnectionManager manager = new ConnectionManager();
        manager.connect("https://opentdb.com/api.php?amount=10",RequestMethod.GET);
        JSONObject jsonData = manager.fetchData();
        System.out.println(jsonData);
    }
}
