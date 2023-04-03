package pl.kzietek.productCatalog;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductCatalogTest {

    @Test
    void itExposeEmptyProductsList() {
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);
    }

    private static void assertEmptyList(List<Product> products) {
        assert  0 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productID = catalog.addProduct("Lego", "cool");
        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToChangePrice() {

    }

    @Test
    void itAllowsToAssignImage() {

    }


}