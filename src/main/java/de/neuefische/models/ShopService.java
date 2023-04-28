package de.neuefische.models;

import java.util.Objects;

public class ShopService {
    // properties
    private ProductRepo productRepo;
    private OrderRepo orderRepo;




    // constructors
    public ShopService(){}
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }




    // standard methods
    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }


    // implemented methods
    public void getAllProducts_Service(){
        productRepo.getAllProducts();
    }

    public void getProductById_Service(String searchId){
        productRepo.getProductById(searchId);
    }

    public void addOrder_Service(Order newOrder){
        orderRepo.addOrder(newOrder);
    }

    public void getAllOrders_Service(){
        orderRepo.getAllOrders();
    }

    public void getOrderByIdService(String searchId){
        orderRepo.getOrderById(searchId);
    }




    // get/set
    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }
}
