package LucrareRestApi.LucrareRestApi.controller;

import LucrareRestApi.LucrareRestApi.exception.ResourceNotFoundException;
import LucrareRestApi.LucrareRestApi.model.Product;
import LucrareRestApi.LucrareRestApi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")

public class ProductController {


    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/product")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product =
                productRepository
                        .findById(productId)
                        .orElseThrow();
        return ResponseEntity.ok().body(product);
    }
}
