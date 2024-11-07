package triviaClash.Game;

import java.util.ArrayList;

import triviaClash.Data.GameData.CategoriesUI;
import triviaClash.Data.GameData.MainUI;
import triviaClash.Data.GameData.QuestionData;
import triviaClash.Data.GameData.GameMode;
import triviaClash.utilities.QueryManager;
import triviaClash.utilities.OutputManager;

public class Game {
    private String sessionToken = "";
    private ArrayList<QuestionData> questions;
    private ArrayList<ArrayList<String>> options;
    private GameMode mode; 
    private QueryManager manager;
    private String notifierMessage = "";

    public void startGame() {
        OutputManager.clear();
            notifier("Check your internet connection !!");
        MainUI ui = new MainUI();
        switch(ui.getChoice()) {
            case 1: 
                System.out.println("Starting single player mode...");
                mode = GameMode.SINGLE_PLAYER;
                break;
            case 2:
                System.out.println("Starting multi player mode...");
                mode = GameMode.MULTI_PLAYER;
                break;
            case 3:
                System.out.println("Coming soon !!");
                break;
            case 4:
                System.out.println("Thanks for playing, exitting the game..");
                System.exit(0);
        } 

        if(mode == GameMode.SINGLE_PLAYER) {
            getSessionToken();
            if(sessionToken == "") {
                notifierMessage = "Check your internet connection and try again !!";
                startGame();
            }
            new CategoriesUI();
        }  
    }


    private void getSessionToken() {
        manager = new QueryManager();
        sessionToken = manager.getSessionToken();       
    }

    private void notifier (String message) {
        if ( notifierMessage != "" ) {
            System.out.println("ALERT!! Check your internet connection."); 
        } 
    }
}
