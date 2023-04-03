package pl.kzietek.productCatalog;

import java.util.*;

public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return products;
    }

    public String addProduct(String name, String desc) {
        Product newOne = new Product (
                UUID.randomUUID(),
                name,
                desc
        );
        this.products.add(newOne);
        return newOne.getId();
    }
}