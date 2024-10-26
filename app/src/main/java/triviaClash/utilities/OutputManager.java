package triviaClash.utilities; 

import triviaClash.Data.CommandMode;

public class OutputManager {
    private static String outputText;
    private static CommandMode mode;

    public static void SOP(String outputText, CommandMode mode) {
        switch(mode) {
            case CMD_LINE:
                System.out.println(outputText);
                break;
            case TEXT_FIELD:
            default:
                System.err.println("GUI integration required to use this mode!!");
        }
    }
}
