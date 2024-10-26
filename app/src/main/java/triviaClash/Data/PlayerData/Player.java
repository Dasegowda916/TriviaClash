package triviaClash.Data.PlayerData;

public class Player {
    private int lives = 3;
    private int score = 0;
    private String name = "";
    private static int playerCount = 0; 
    private int id = 0;

    public Player(String name) {
        this.name = name;
        playerCount++;
        id = playerCount;
    }
    
    public void score() {
        this.score++; 
    }
    
    public static int getPlayerCount() {
        return playerCount;
    }

    public void reduceLife() {
        this.lives--;
    }

    // getters and setters 
    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
