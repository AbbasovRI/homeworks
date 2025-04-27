package springaopdemo.aspect;

import springaopdemo.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
    @Before("execution(* springaopdemo.service.ProductService.createProduct(..)) && args(product)")
    public void validateProductBeforeCreation(JoinPoint joinPoint, Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be positive");
        }
    }
}