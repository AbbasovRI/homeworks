package springaopdemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springaopdemo.model.Product;
import springaopdemo.repository.ProductRepository;

class ProductRepositoryTest {
    private ProductRepository repository;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        repository = new ProductRepository();
        testProduct = new Product();
        testProduct.setName("Test Product");
        testProduct.setPrice(100.0);
    }

    @Test
    void testSaveNewProduct() {
        Product saved = repository.save(testProduct);
        assertNotNull(saved.getId());
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void testFindById() {
        Product saved = repository.save(testProduct);
        Product found = repository.findById(saved.getId());
        assertEquals(saved.getId(), found.getId());
    }

    @Test
    void testUpdateProduct() {
        Product saved = repository.save(testProduct);
        saved.setPrice(200.0);
        Product updated = repository.save(saved);
        assertEquals(200.0, updated.getPrice(), 0.001);
    }

    @Test
    void testDeleteById() {
        Product saved = repository.save(testProduct);
        repository.deleteById(saved.getId());
        assertNull(repository.findById(saved.getId()));
        assertEquals(0, repository.findAll().size());
    }
}