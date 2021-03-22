package JDBC;
import java.util.*;
import java.sql.*;
import java.sql.Date;
public class DatabaseHelper {
    public static List<orderDetail> getOrderDetails(int userId) {
        List<orderDetail> listOfOrders = new ArrayList<orderDetail>();
        String query = Query.getOrderDetailQuery(userId);
        Connection connection = DatabaseConnection.getConnection();
        try {
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            // execute select query and returns result set
            ResultSet rset = statement.executeQuery();
            while (rset.next()) {
                int orderId = rset.getInt("orderID");
                int productId = rset.getInt("productID");
                Date orderDate = rset.getDate("orderDate");
                double orderTotal = rset.getDouble("totalBill");
                orderDetail orderDetail = new orderDetail();
                orderDetail.setOrderId(orderId);
                orderDetail.setProductId(productId);
                orderDetail.setOrderDate(orderDate);
                orderDetail.setOrderTotal(orderTotal);
                listOfOrders.add(orderDetail);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return listOfOrders;
    }
    public static void insertImage(List<ProductImage> listOfImage) {
        String query = Query.getInsertImageQuery();
        try (Connection connection = DatabaseConnection.getConnection();
                // Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query);) {
            try {
                statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
                connection.setAutoCommit(false);
                for (ProductImage image : listOfImage) {
                    statement.setInt(1, image.getProductId());
                    statement.setString(2, image.getImageUrl());
                    statement.addBatch();
                }
                // multiple rows are inserted using batch insert technique
                statement.executeBatch();
                connection.commit();
                statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                connection.rollback();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static int updateProductStatus() {
        int updatedRows = 0;
        String query = Query.getUpdateProductStatusQuery();
        try (Connection connection = DatabaseConnection.getConnection();
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);) {
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
            // execute update query and return updated rows
            updatedRows = statement.executeUpdate();
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return updatedRows;
    }
    public static List<TopCategoryDetail> getTopCategoryDetails() {
        List<TopCategoryDetail> listOfTopCategoryDetail = new ArrayList<TopCategoryDetail>();
        String query = Query.getTopCategoryDetails();
        try (Connection connection = DatabaseConnection.getConnection();
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);) {
            // execute select query and returns result set
            ResultSet rset = statement.executeQuery();
            while (rset.next()) {
                String categoryName = rset.getString("categoryName");
                int numberOfChildren = rset.getInt("numberOfChildren");
                TopCategoryDetail topCategoryDetail = new TopCategoryDetail();
                topCategoryDetail.setName(categoryName);
                topCategoryDetail.setNumberOfChildren(numberOfChildren);
                listOfTopCategoryDetail.add(topCategoryDetail);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return listOfTopCategoryDetail;
    }
}