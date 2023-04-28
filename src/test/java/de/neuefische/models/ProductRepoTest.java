package de.neuefische.models;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    @Test
    public void getAllProducts_returnLastStringOnConsole(){
        // given
        Product pr0 = new Product("0","Product 0");
        Product pr1 = new Product("1","Product 1");
        String expectedStr = "ID: 1, Product: Product 1"; // Last string of Map to print out

        Map<String,Product> map1 = new HashMap<>();
        map1.put(pr0.getProductId(),pr0);
        map1.put(pr1.getProductId(),pr1);
        ProductRepo repoProducts = new ProductRepo(map1);

        // when
        String actualStr = repoProducts.getAllProducts();

        // then
        assertEquals(expectedStr, actualStr);
    }

    @Test
    public void getProductById_returnSpecificProduct(){
        // given
        Product pr0 = new Product("0","Product 0");
        Product pr1 = new Product("1","Product 1");
        String searchId = "1";

        Map<String,Product> map1 = new HashMap<>();
        map1.put(pr0.getProductId(),pr0);
        map1.put(pr1.getProductId(),pr1);
        ProductRepo repoProducts = new ProductRepo(map1);

        // when
        Product actualProduct = repoProducts.getProductById(searchId);

        // then
        assertEquals(pr1, actualProduct);
    }

    @Test
    public void getProductById_throwExceptionIfNotExistent(){
        // given
        Product pr0 = new Product("0","Product 0");
        Product pr1 = new Product("1","Product 1");
        String searchId = "2"; // not existent, should result in exception

        Map<String,Product> map1 = new HashMap<>();
        map1.put(pr0.getProductId(),pr0);
        map1.put(pr1.getProductId(),pr1);
        ProductRepo repoProducts = new ProductRepo(map1);

        // when/then
        try {
            Product actualProduct = repoProducts.getProductById(searchId);
            fail();
        } catch (NoSuchElementException e){
            assertTrue(true);
        }
    }
}