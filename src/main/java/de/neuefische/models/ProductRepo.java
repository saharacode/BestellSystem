package de.neuefische.models;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ProductRepo {
    // properties
    private Map<String,Product> repoProducts;



    // constructors
    public ProductRepo(){}
    public ProductRepo(Map<String, Product> repoProducts) {
        this.repoProducts = repoProducts;
    }



    // methods
    @Override
    public String toString() {
        return "ProductRepo{" +
                "repoProducts=" + repoProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(repoProducts, that.repoProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repoProducts);
    }

    public String getAllProducts(){
        String currentStr = "";
        for (String key :repoProducts.keySet()) {
            Product pr = repoProducts.get(key);
            currentStr = "ID: " + pr.getProductId() + ", Product: " + pr.getProductName();
            System.out.println(currentStr);
        }
        return currentStr;
    }

    public Product getProductById(String searchId) {
        for (String key :repoProducts.keySet()) {
            if (key.equals(searchId)){
                Product pr = repoProducts.get(key);
                String currentStr = "ID: " + pr.getProductId() + ", Product: " + pr.getProductName();
                System.out.println(currentStr);
                return pr;
            }
        }
        throw new NoSuchElementException();

    }




    // get/set
    public Map<String, Product> getRepoProducts() {
        return repoProducts;
    }

    public void setRepoProducts(Map<String, Product> repoProducts) {
        this.repoProducts = repoProducts;
    }


}
