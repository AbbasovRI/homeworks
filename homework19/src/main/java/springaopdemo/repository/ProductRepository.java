package springaopdemo.repository;

import springaopdemo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(counter.incrementAndGet());
            products.add(product);
            return product;
        } else {
            return update(product);
        }
    }

    private Product update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);
                return product;
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}