import database.DatabaseConnection;
import database.ClothingItemDAO;
import menu.Menu;
import menu.clothingStoreMenu;
import model.Pants;
import model.ClothingItem;

import javax.xml.crypto.Data;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    //Chef chef = new Chef(1, "Test", 4500, 1,"TestSpec");
    ClothingItemDAO clothingItemDAO = new ClothingItemDAO();
    List<ClothingItem> clothingItemList = clothingItemDAO.getAllClothingItems();
    for(ClothingItem clothingItem : clothingItemList){
      System.out.println(clothingItem);
    }
  }
}