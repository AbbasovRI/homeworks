package springaopdemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springaopdemo.model.Product;
import springaopdemo.service.ProductService;

@SpringBootTest
class ValidationAspectTest {
    @Autowired
    private ProductService service;

    @Test
    void testValidationAspectWithValidProduct() {
        Product product = new Product();
        product.setName("Valid");
        product.setPrice(100.0);

        assertDoesNotThrow(() -> service.createProduct(product));
    }

    @Test
    void testValidationAspectWithEmptyName() {
        Product product = new Product();
        product.setName("");
        product.setPrice(100.0);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.createProduct(product));
        assertEquals("Product name cannot be empty", ex.getMessage());
    }

    @Test
    void testValidationAspectWithNegativePrice() {
        Product product = new Product();
        product.setName("Test");
        product.setPrice(-100.0);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.createProduct(product));
        assertEquals("Product price must be positive", ex.getMessage());
    }
}