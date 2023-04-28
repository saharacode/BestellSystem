package de.neuefische.models;

import java.util.Map;
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




    // get/set
    public Map<String, Product> getRepoProducts() {
        return repoProducts;
    }

    public void setRepoProducts(Map<String, Product> repoProducts) {
        this.repoProducts = repoProducts;
    }
}
