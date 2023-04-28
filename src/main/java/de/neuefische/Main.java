package de.neuefische;

import de.neuefische.models.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // SETUP

        // Products
        Product product0 = new Product("0","Computer");
        Product product1 = new Product("1","Maus");
        Product product2 = new Product("2","Tastatur");
        Product product3 = new Product("3","Kopfhoerer");

        ////////////////////////////////////////////////////////////////

        // ProductRepo
        Map<String,Product> productMap = new HashMap<>();
        productMap.put(product0.getProductId(),product0);
        productMap.put(product1.getProductId(),product1);
        productMap.put(product2.getProductId(),product2);
        productMap.put(product3.getProductId(),product3);
        ProductRepo productRepo = new ProductRepo(productMap);

        ////////////////////////////////////////////////////////////////

        // OrderRepo
        // Order 0:
        Map<String,Product> productMapOrder0 = new HashMap<>();
        productMapOrder0.put(product0.getProductId(),product0);
        productMapOrder0.put(product1.getProductId(),product1);
        Order order0 = new Order("0",productMapOrder0);

        // Order 1:
        Map<String,Product> productMapOrder1 = new HashMap<>();
        productMapOrder1.put(product2.getProductId(),product1);
        productMapOrder1.put(product3.getProductId(),product3);
        Order order1 = new Order("1",productMapOrder1);

        // Order 2:
        Map<String,Product> productMapOrder2 = new HashMap<>();
        productMapOrder2.put(product0.getProductId(),product0);
        productMapOrder2.put(product1.getProductId(),product1);
        productMapOrder2.put(product2.getProductId(),product2);
        productMapOrder2.put(product3.getProductId(),product3);
        Order order2 = new Order("2",productMapOrder2);

        // create OrderRepo which contains empty Map
        Map<String,Order> orderRepoMap = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orderRepoMap);

        ////////////////////////////////////////////////////////////////

        // ShopService
        ShopService shopService = new ShopService(productRepo,orderRepo);

        // TestMethods for ProductRepo
        System.out.println("TEST 1: SHOW ALL PRODUCTS -->\n");
        shopService.getAllProducts_Service();

        System.out.println("\nTEST 2: GET PRODUCT BY ID -->\n");
        shopService.getProductById_Service("0");

        System.out.println("\nTEST 3: GET ALL ORDERS -->\n");
        shopService.getAllOrders_Service();

        System.out.println("\nTEST 4: ADD NEW ORDER -->\n");
        shopService.addOrder_Service(order0);
        shopService.addOrder_Service(order1);
        shopService.addOrder_Service(order2);
        shopService.getAllOrders_Service();

        System.out.println("\nTEST 5: GET ORDER BY ID -->\n");
        shopService.getOrderById_Service("1");

    }
}