package triviaClash.Data.GameData;

import java.util.HashMap;
import java.util.Map; 
import triviaClash.utilities.QueryManager;

public class CategoriesUI {
    
    private Map<Integer, String> categories;

    public CategoriesUI() {

        QueryManager manager = new QueryManager();
        categories = manager.getCategories();
    }

    private void printCategories() {
        System.out.println("====== CATEGORIES ======");
        for(int x: categories.keySet()) {
            System.out.printf("%d. %s\n",x, categories.getOrDefault(x,""));
        }
    }
}
