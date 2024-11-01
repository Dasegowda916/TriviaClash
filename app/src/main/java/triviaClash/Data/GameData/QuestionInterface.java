package triviaClash.Data.GameData;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionInterface {
    private String questionString;
    private ArrayList<String> options;
    private String correctOptionId;
    private static int questionCount;

    public void printQuestionData() {
        System.out.printf("%d. %s \n ", questionCount+1, questionString);
        for(int i=0; i<options.size(); i++) {
            System.out.printf("(%d) %s", i+1, options.get(i));
        }
    } 

    public void resetCount() {
        questionCount = 0;
    }
}
