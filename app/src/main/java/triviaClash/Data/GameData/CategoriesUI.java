package triviaClash.Data.GameData;

import java.util.Map; 
import triviaClash.utilities.QueryManager;

public class CategoriesUI {
    
    private static Map<Integer, Map<Integer, String>> categories;     
    
    public CategoriesUI() {
        QueryManager manager = new QueryManager();
        categories = manager.getCategories();
        printCategories();
    }

    private static void printCategories() {
        System.out.println("====== CATEGORIES ======");
        for(Integer x: categories.keySet()) {
            for( Integer m: categories.get(x).keySet()) {
                System.out.printf("\n%d. %s\n", x, categories.get(x).get(m));  
            }
        } 
    }
}
