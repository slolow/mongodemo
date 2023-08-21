package com.slo.coding.mongodemo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // eigentlich besser ein DataTransferObject zu benutzen (so wie in Haruns Beispiel)
    // hier wird das Product direkt verwendet, weil es ein crash course ist.
    public String save(Product product) {
        // todo use a DTO (data tarnsfer object)
        // todo validate the objects
        return repository.save(product).getId();
    }

    public Product findById(String id) {
        // .orElse(null) --> if there is no product with this id return null.
        // we could also us orElseThrow
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
