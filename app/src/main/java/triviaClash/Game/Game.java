package triviaClash.Game;

import java.util.Scanner; 
import java.util.ArrayList;

import triviaClash.Data.GameData.MainUI;
import triviaClash.Data.GameData.QuestionInterface;
import triviaClash.Data.GameData.GameMode;
import triviaClash.utilities.QueryManager;

public class Game {
    private String sessionToken = "";
    private ArrayList<QuestionInterface> questions;
    private ArrayList<ArrayList<String>> options;
    private GameMode mode; 
    private QueryManager manager;
    
    public void startGame() {
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

        getSessionToken();
        
    }

    private void getSessionToken() {
        manager = new QueryManager();
        sessionToken = manager.getSessionToken();       
    }
}
