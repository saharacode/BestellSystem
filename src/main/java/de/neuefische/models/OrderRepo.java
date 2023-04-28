package de.neuefische.models;

import java.util.Map;
import java.util.Objects;

public class OrderRepo {
    // properties
    private Map<String,Order> repoOrders;



    // constructors
    public OrderRepo(){}
    public OrderRepo(Map<String, Order> repoOrders) {
        this.repoOrders = repoOrders;
    }



    // methods
    @Override
    public String toString() {
        return "OrderRepo{" +
                "repoOrders=" + repoOrders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(repoOrders, orderRepo.repoOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repoOrders);
    }

    public Order addOrder(Order newOrder) {
        repoOrders.put(newOrder.getOrderId(),newOrder);
        return repoOrders.get(newOrder.getOrderId());
    }




    // get/set
    public Map<String, Order> getRepoOrders() {
        return repoOrders;
    }

    public void setRepoOrders(Map<String, Order> repoOrders) {
        this.repoOrders = repoOrders;
    }


}
