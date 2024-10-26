package triviaClash.Data.GameData;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    private static int questionCount;
    private ArrayList<String> options;
    private String question;

    public Question() {
        questionCount++;
    }

    // getters and setters 
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String options[]) {
        this.options = new ArrayList<String>(Arrays.asList(options));
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getQuestion() {
        return question;
    }
}
