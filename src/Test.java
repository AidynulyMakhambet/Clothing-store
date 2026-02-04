import database.DatabaseConnection;
import database.ClothingItemDAO;
import model.Pants;
import model.ClothingItem;
import model.Shirt;

import java.sql.Connection;
import java.util.List;

public class Test {
    static void main() {
        Pants testPants = new Pants("10", "PANTS!!!", "yellow", "L", 1000000, 1, "KZ", true);
        ClothingItemDAO clothingItemDAO = new ClothingItemDAO();
        clothingItemDAO.insertPants(testPants);

        List<Pants> pantsList = clothingItemDAO.getAllPants();
        for(Pants pants : pantsList){
            System.out.println(pants);
        }
    }
}