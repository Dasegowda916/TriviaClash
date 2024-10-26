package triviaClash;

import org.json.JSONObject;

import triviaClash.Data.RequestMethod;
import triviaClash.Data.CommandMode;
import triviaClash.utilities.ConnectionManager;
import triviaClash.utilities.OutputManager;

public class Main {
    public static void main(String args[]) {
        ConnectionManager conman = new ConnectionManager(); 
        int counter = 0;
        while(counter <= 5 && !conman.isConnected()) {
            OutputManager.SOP("Connecting...",CommandMode.CMD_LINE);
            conman.connect("https://opentdb.com/api.php?amount=4",RequestMethod.GET);
            counter ++;
        }
        System.out.println(conman.getJsonData());
    }
}
