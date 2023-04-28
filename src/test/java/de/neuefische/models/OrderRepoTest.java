package de.neuefische.models;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    // create two products to use them in the Testmethods
    Product pr0 = new Product("0","Product 0");
    Product pr1 = new Product("1","Product 1");


    @Test
    public void addOrder_returnAddedOrder(){
        // given
        // create order, which should be added to OrderRepo:
        Map<String,Product> productMap = new HashMap<>();
        productMap.put(pr0.getProductId(), pr0);
        productMap.put(pr1.getProductId(),pr1);
        Order newOrder = new Order("0",productMap);

        // create OrderRepo which contains empty Map
        Map<String,Order> orderRepoMap = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orderRepoMap);

        // when
        Order actualAddedOrder = orderRepo.addOrder(newOrder);

        // then
        assertEquals(newOrder, actualAddedOrder);
    }


    @Test
    public void getAllOrders_(){
        // given
        // Order 0: (1x product 0, 1x product 1)
        Map<String,Product> productMap0 = new HashMap<>();
        productMap0.put(pr0.getProductId(),pr0);
        productMap0.put(pr1.getProductId(),pr1);
        Order order0 = new Order("0",productMap0);

        // Order 1: (2x product 0)
        Map<String,Product> productMap1 = new HashMap<>();
        productMap1.put(pr1.getProductId(),pr1);
        productMap1.put(pr0.getProductId(),pr0);
        Order order1 = new Order("1",productMap1);

        // create OrderRepo which contains empty Map
        Map<String,Order> orderRepoMap = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orderRepoMap);

        // add Orders to OrderRepo
        orderRepo.addOrder(order0);
        orderRepo.addOrder(order1);

        String expectedStr = "Order-ID: 1, Products: " + order1.getOrderProducts();

        // when
        String actualStr = orderRepo.getAllOrders();

        // then
        assertEquals(expectedStr, actualStr);
    }

    @Test
    public void getOrderById_returnSpecificOrder(){
        // given
        String searchId = "0";

        // create order, which should be added to OrderRepo:
        Map<String,Product> productMap = new HashMap<>();
        productMap.put(pr0.getProductId(), pr0);
        productMap.put(pr1.getProductId(),pr1);
        Order newOrder = new Order("0",productMap);

        // create OrderRepo which contains empty Map
        Map<String,Order> orderRepoMap = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orderRepoMap);

        // add Orders to OrderRepo
        orderRepo.addOrder(newOrder);

        // when
        Order actualOrder = orderRepo.getOrderById(searchId);

        // then
        assertEquals(newOrder, actualOrder);
    }

    @Test
    public void getOrderById_throwExceptionIfNotExistent(){
        // given
        String searchId = "1";

        // create order, which should be added to OrderRepo:
        Map<String,Product> productMap = new HashMap<>();
        productMap.put(pr0.getProductId(), pr0);
        productMap.put(pr1.getProductId(),pr1);
        Order newOrder = new Order("0",productMap);

        // create OrderRepo which contains empty Map
        Map<String,Order> orderRepoMap = new HashMap<>();
        OrderRepo orderRepo = new OrderRepo(orderRepoMap);

        // add Orders to OrderRepo
        orderRepo.addOrder(newOrder);

        // when/then
        try {
            Order actualOrder = orderRepo.getOrderById(searchId);
            fail();
        } catch (NoSuchElementException e){
            assertTrue(true);
        }
    }

}