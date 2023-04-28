package de.neuefische.models;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    Product pr0 = new Product("0","Product 0");
    Product pr1 = new Product("1","Product 1");

    @Test
    public void addOrder_returnAddedOrder(){
        // given
        // - create order, which should be added to OrderRepo:
        Map<String,Product> productMap = new HashMap<>();
        productMap.put(pr0.getProductId(), pr0);
        productMap.put(pr1.getProductId(),pr1);
        Order newOrder = new Order("0",productMap);

        // - create OrderRepo which contains empty Map
        Map<String,Order> orderRepoMap = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orderRepoMap);

        // when
        Order actualAddedOrder = orderRepo.addOrder(newOrder);

        // then
        assertEquals(newOrder, actualAddedOrder);
    }

        /*
    @Test
    public void getAllOrders_(){
        // given
        // -products
        Product pr0 = new Product("0","Product 0");
        Product pr1 = new Product("1","Product 1");

        // -Order 0: (1x product 0, 1x product 1)
        Map<String,Product> orderMap0 = new HashMap<>();
        orderMap0.put(pr0.getProductId(),pr0);
        orderMap0.put(pr1.getProductId(),pr1);
        Order order0 = new Order("0",orderMap0);

        // -Order 1: (2x product 0)
        Map<String,Product> orderMap1 = new HashMap<>();
        orderMap0.put(pr0.getProductId(),pr0);
        orderMap0.put(pr0.getProductId(),pr0);
        Order order1 = new Order("1",orderMap1);

        // - Create OrderRepo
        Map<String,Product> orderRepoMap = new HashMap<>();
        orderRepoMap.put(order0.getOrderId(),order0);
        orderRepoMap.put(pr1.getProductId(),pr1);
        OrderRepo repoProducts = new ProductRepo(map1);

        // when
        String actualStr = repoProducts.getAllProducts();

        // then
        assertEquals(expectedStr, actualStr);
    }

     */
}