package JDBC;
import java.sql.*;
public class orderDetail {
    private int orderId;
    private int productId;
    private Date orderDate;
    private double totalPrice;
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return totalPrice;
    }

    public void setOrderTotal(double orderTotal) {
        this.totalPrice = orderTotal;
    }

}