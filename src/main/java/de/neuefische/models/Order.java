package de.neuefische.models;

import java.util.Map;
import java.util.Objects;

public class Order {
    // properties
    private String orderId;
    private Map<String,Product> orderProducts;




    // constructors
    public Order(){}
    public Order(String orderId, Map<String, Product> orderProducts) {
        this.orderId = orderId;
        this.orderProducts = orderProducts;
    }




    // methods
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderProducts=" + orderProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(orderProducts, order.orderProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderProducts);
    }




    // get/set
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<String, Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Map<String, Product> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
