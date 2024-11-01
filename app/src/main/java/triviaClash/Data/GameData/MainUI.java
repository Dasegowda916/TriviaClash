package triviaClash.Data.GameData; 

import java.util.Scanner; 

public class MainUI {
    
    private int choice;
    private Scanner in = new Scanner(System.in);

    public MainUI() {
        System.out.println("========= GAME MENU =========");
        System.out.println("1. SINGLE PLAYER MODE");
        System.out.println("2. MULTI-PLAYER MODE");
        System.out.println("3. HELP");
        System.out.println("4. EXIT");
        System.out.println("=============================");
        
        boolean flag = true;
        while(flag) {
            System.out.print("> ENTER YOUR CHOICE : ");
            choice = in.nextInt();
            switch(choice) {
                case 1: 
                case 2:
                case 3: 
                case 4:
                flag = false;
                break;

                default:
                    System.out.println("> Please enter valid choice : ");
            }
        }
    }

    public int getChoice() {
        return choice;
    }
}
