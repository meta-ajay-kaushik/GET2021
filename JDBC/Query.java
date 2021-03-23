package JDBC;
public class Query {
    public static String getOrderDetailQuery(int userId) {
        String query = "SELECT distinct orders.orderID,product.productID,orders.orderDate,orders.totalBill "
                + "FROM orders join user on orders.userID = user.userID JOIN "
                + "status on orders.orderID = status.orderID JOIN product ON product.productID=orders.productID"
                + " WHERE user.userID =" + userId + " AND status.shipped = 'y' order by orders.orderDate ASC";
        return query;
    }
    public static String getInsertImageQuery() {
        String query = "INSERT INTO productImages(productID,imageSrc) values(?, ?)";
        return query;
    }
    public static String getUpdateProductStatusQuery() {
        String query = "delete from product " + "where productID IN(select pid from "
        		+ "(select pr.productID as pid from product pr LEFT JOIN orderLine ol "
        		+ "ON pr.productID=ol.productID LEFT JOIN orders ors "
        		+ "ON ors.orderID=ol.orderID GROUP BY ol.productID "
        		+ "having TIMESTAMPDIFF(YEAR,MAX(ors.orderDate),CURDATE())>=1) as new)";
        return query;
    }
    public static String getTopCategoryDetails() {
        String query = "select c.categoryName,COUNT(cat.parentID) AS numberOfChildren "
                + "FROM category c LEFT JOIN category cat ON cat.parentID=c.categoryID WHERE c.parentID is NULL "
                + "GROUP BY c.categoryName ORDER BY c.categoryName";
        return query;
    }
}