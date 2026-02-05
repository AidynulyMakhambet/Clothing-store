package database;

import model.*;

import javax.xml.crypto.Data;
import java.nio.file.FileSystemNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StaffDAO - Week 8 Enhanced
 * Complete CRUD operations + Advanced Search
 * - CREATE (INSERT) ✓
 * - READ (SELECT) ✓
 * - UPDATE ✓ NEW!
 * - DELETE ✓ NEW!
 * - SEARCH by name ✓ NEW!
 * - SEARCH by salary range ✓ NEW!
 */
public class ClothingItemDAO {

    // ========================================
    // CREATE - INSERT OPERATIONS (Week 7)
    // ========================================

    /**
     * INSERT Pants into database
     */
    public boolean insertPants(Pants pants) {
        String sql = "INSERT INTO clothingItems (clothingItemId, name, color, size, price, stockQuantity, brand, clothing_item_type, hasBeltLoops, sleeveType) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, 'PANTS', ?, NULL)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pants.getClothingItemId());
            statement.setString(2, pants.getName());
            statement.setString(3, pants.getColor());
            statement.setString(4, pants.getSize());
            statement.setDouble(5, pants.getPrice());
            statement.setInt(6, pants.getStockQuantity());
            statement.setString(7, pants.getBrand());
            statement.setBoolean(8, pants.getHasBeltLoops());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Pants inserted: " + pants.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Pants failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    /**
     * INSERT Shirt into database
     */
    public boolean insertShirt(Shirt shirt) {
        String sql = "INSERT INTO clothingItems (clothingItemId, name, color, size, price, stockQuantity, brand, clothing_item_type, hasBeltLoops, sleevetype) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, 'SHIRT', false, ?)";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, shirt.getClothingItemId());
            statement.setString(2, shirt.getName());
            statement.setString(3, shirt.getColor());
            statement.setString(4, shirt.getSize());
            statement.setDouble(5, shirt.getPrice());
            statement.setInt(6, shirt.getStockQuantity());
            statement.setString(7, shirt.getBrand());
            statement.setString(8, shirt.getSleeveType());


            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Shirt inserted: " + shirt.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Shirt failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // READ - SELECT OPERATIONS (Week 7)
    // ========================================

    /**
     * SELECT ALL clothingItem members
     * @return List of ClothingItem (Pants and Shirt objects)
     */
    public List<ClothingItem> getAllClothingItems() {
        List<ClothingItem> clothingItemList = new ArrayList<>();
        String sql = "SELECT * FROM clothingItems ORDER BY clothing_item_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem != null) {
                    clothingItemList.add(clothingItem);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + clothingItemList.size() + " clothingItem from database");

        } catch (SQLException e) {
            System.out.println("❌ Select all clothingItem failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return clothingItemList;
    }

    /**
     * SELECT clothingItem by ID
     */
    public ClothingItem getClothingItemById(String clothingItemId) {
        String sql = "SELECT * FROM clothingItems WHERE clothing_item_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clothingItemId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if (clothingItem != null) {
                    System.out.println("✅ Found clothingItem with ID: " + clothingItemId);
                }

                return clothingItem;
            }

            System.out.println("⚠️ No clothingItem found with ID: " + clothingItemId);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }

    /**
     * SELECT all Pants
     */
    public List<Pants> getAllPants() {
        List<Pants> pants = new ArrayList<>();
        String sql = "SELECT * FROM clothingitems WHERE clothing_item_type = 'PANTS' ORDER BY clothing_item_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pants;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem instanceof Pants) {
                    pants.add((Pants) clothingItem);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + pants.size() + " pants");

        } catch (SQLException e) {
            System.out.println("❌ Select pants failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pants;
    }

    /**
     * SELECT all Shirts
     */
    public List<Shirt> getAllShirts() {
        List<Shirt> shirts = new ArrayList<>();
        String sql = "SELECT * FROM clothingitems WHERE clothing_item_type = 'SHIRT' ORDER BY clothing_item_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return shirts;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem instanceof Shirt) {
                    shirts.add((Shirt) clothingItem);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + shirts.size() + " shirts");

        } catch (SQLException e) {
            System.out.println("❌ Select shirts failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return shirts;
    }

    // ========================================
    // WEEK 8: UPDATE OPERATION
    // ========================================

    /**
     * UPDATE Pants in database
     * @param pants Pants object with updated data
     * @return true if successful
     */

    // CHEF from DB
    // CHEF set change
    // update chef
    public boolean updatePants(Pants pants) {
        String sql = "UPDATE clothingItems SET name = ?, color = ?, size = ?, price = ?, stockQuantity = ?, brand = ?, hasBeltLoops = ?" +
                "WHERE clothingItemId = ? AND clothing_item_type = 'PANTS'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pants.getName());
            statement.setString(2, pants.getColor());
            statement.setString(3, pants.getSize());
            statement.setDouble(4, pants.getPrice());
            statement.setInt(5, pants.getStockQuantity());
            statement.setString(6, pants.getBrand());
            statement.setBoolean(7, pants.getHasBeltLoops());
            statement.setString(8, pants.getClothingItemId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Pants updated: " + pants.getName());
                return true;
            } else {
                System.out.println("⚠️ No pants found with ID: " + pants.getClothingItemId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Update Pants failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    /**
     * UPDATE Shirt in database
     * @param shirt Shirt object with updated data
     * @return true if successful
     */
    public boolean updateShirt(Shirt shirt) {
        String sql = "UPDATE clothingItems SET name = ?, color = ?, size = ?, price = ?, stockQuantity = ?, brand = ?, sleeveType = ?" +
                "WHERE clothing_item_id = ? AND clothing_item_type = 'SHIRT'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, shirt.getName());
            statement.setString(2, shirt.getColor());
            statement.setString(3, shirt.getSize());
            statement.setDouble(4, shirt.getPrice());
            statement.setInt(5, shirt.getStockQuantity());
            statement.setString(6, shirt.getBrand());
            statement.setString(7, shirt.getSleeveType());
            statement.setString(8, shirt.getClothingItemId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Shirt updated: " + shirt.getName());
                return true;
            } else {
                System.out.println("⚠️ No shirt found with ID: " + shirt.getClothingItemId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Update Shirt failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // WEEK 8: DELETE OPERATION
    // ========================================

    /**
     * DELETE clothingItem by ID
     * @param clothingItemId ID of clothingItem to delete
     * @return true if successful
     */
    public boolean deleteClothingItem(String clothingItemId) {
        String sql = "DELETE FROM clothingItems WHERE clothing_item_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clothingItemId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("✅ ClothingItem deleted (ID: " + clothingItemId + ")");
                return true;
            } else {
                System.out.println("⚠️ No clothingItem found with ID: " + clothingItemId);
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    // ========================================
    // WEEK 8: SEARCH BY NAME
    // ========================================

    /**
     * SEARCH clothingItem by name (partial match, case-insensitive)
     * Example: searchByName("mur") finds "Murat", "Murray", etc.
     * @param name Name or partial name to search
     * @return List of matching clothingItems
     */
    public List<ClothingItem> searchByName(String name) {
        List<ClothingItem> clothingItemList = new ArrayList<>();

        // ILIKE for case-insensitive search, % for partial match
        String sql = "SELECT * FROM clothingItems WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");  // % = wildcard

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem != null) {
                    clothingItemList.add(clothingItem);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + clothingItemList.size() + " clothingItems matching '" + name + "'");

        } catch (SQLException e) {
            System.out.println("❌ Search by name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return clothingItemList;
    }

    // ========================================
    // WEEK 8: SEARCH BY SALARY RANGE
    // ========================================

    /**
     * SEARCH clothingItem by price range
     * @param minPrice Minimum price (inclusive)
     * @param maxPrice Maximum price (inclusive)
     * @return List of clothingItems in price range
     */
    public List<ClothingItem> searchByPriceRange(double minPrice, double maxPrice) {
        List<ClothingItem> clothingItemList = new ArrayList<>();

        String sql = "SELECT * FROM clothingItems WHERE price BETWEEN ? AND ? ORDER BY price DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem != null) {
                    clothingItemList.add(clothingItem);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + clothingItemList.size() + " clothingItems in price range " +
                    minPrice + " - " + maxPrice);

        } catch (SQLException e) {
            System.out.println("❌ Search by price failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return clothingItemList;
    }

    /**
     * SEARCH clothingItem with minimum price
     * @param minPrice Minimum price
     * @return List of clothingItems that cost ar least minPrice
     */
    public List<ClothingItem> searchByMinPrice(double minPrice) {
        List<ClothingItem> clothingItemList = new ArrayList<>();

        String sql = "SELECT * FROM clothingItems WHERE price >= ? ORDER BY price DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return clothingItemList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClothingItem clothingItem = extractClothingItemFromResultSet(resultSet);
                if (clothingItem != null) {
                    clothingItemList.add(clothingItem);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + clothingItemList.size() + " clothingItems that cost >= " + minPrice);

        } catch (SQLException e) {
            System.out.println("❌ Search by min price failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return clothingItemList;
    }

    // ========================================
    // HELPER METHOD
    // ========================================

    /**
     * Extract ClothingItem object from ResultSet
     * Creates Pants or Shirt based on clothing_item_type
     */
    private ClothingItem extractClothingItemFromResultSet(ResultSet resultSet) throws SQLException {
        String clothingItemId = resultSet.getString("clothingItemId");
        String name = resultSet.getString("name");
        String color = resultSet.getString("color");
        String size = resultSet.getString("size");
        double price = resultSet.getDouble("price");
        int stockQuantity = resultSet.getInt("stockQuantity");
        String brand = resultSet.getString("brand");
        String type = resultSet.getString("clothing_item_type");

        ClothingItem item = null;

        if ("PANTS".equals(type)) {
            boolean hasBeltLoops = resultSet.getBoolean("hasBeltLoops");

            item = new Pants(clothingItemId, name, color, size, price, stockQuantity, brand, hasBeltLoops);
        }
        else if ("SHIRT".equals(type)) {
            String sleeveType = resultSet.getString("sleeveType");

            item = new Shirt(clothingItemId, name, color, size, price, stockQuantity, brand, sleeveType);
        }

        return item;
    }

    // ========================================
    // DISPLAY METHODS
    // ========================================

    /**
     * Display all staff in console
     */
    public void displayAllClothingItems() {
        List<ClothingItem> clothingItemList = getAllClothingItems();

        System.out.println("\n========================================");
        System.out.println("   ALL CLOTHING ITEMS FROM DATABASE");
        System.out.println("========================================");

        if (clothingItemList.isEmpty()) {
            System.out.println("No clothing items in database.");
        } else {
            for (int i = 0; i < clothingItemList.size(); i++) {
                ClothingItem s = clothingItemList.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + s.getType() + "] ");
                System.out.println(s.toString());
            }
        }

        System.out.println("========================================\n");
    }

    /**
     * Demonstrate polymorphism with database data
     */
    public void demonstratePolymorphism() {
        List<ClothingItem> clothingItemList = getAllClothingItems();

        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: ClothingItems from Database");
        System.out.println("========================================");

        if (clothingItemList.isEmpty()) {
            System.out.println("No clothingItems to demonstrate.");
        } else {
            for (ClothingItem s : clothingItemList) {
                s.wear();  // Polymorphic call!
            }
        }

        System.out.println("========================================\n");
    }
}