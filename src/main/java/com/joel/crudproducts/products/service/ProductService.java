package com.joel.crudproducts.products.service;

import com.joel.crudproducts.products.persistency.model.Product;
import com.joel.crudproducts.products.persistency.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {



    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Object> createProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findProductByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();


        if (existingProduct.isPresent() && product.getId() == null) {
            data.put("error", true);
            data.put("message", "The product with this name already exist.");

            return new ResponseEntity<>(data, HttpStatus.CONFLICT);
        } else {

            data.put("data", product);

            if (product.getId() != null) {
                data.put("message", "The product has been successfully modify.");
            } else {
                data.put("message", "The product has been successfully saved.");
            }
            productRepository.save(product);

            return new ResponseEntity<>(data, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> deleteProduct(Long id) {
        boolean exist = this.productRepository.existsById(id);
        HashMap<String, Object> deletedata = new HashMap<>();

        if(!exist) {
            deletedata.put("error", true);

            deletedata.put("message", "The product with this id don't exist.");

            return new ResponseEntity<>(deletedata, HttpStatus.CONFLICT);
        }
        else {
            productRepository.deleteById(id);
            deletedata.put("message", "The product was successfully deleted.");
            return new ResponseEntity<>(deletedata, HttpStatus.ACCEPTED);
        }
    }

}
