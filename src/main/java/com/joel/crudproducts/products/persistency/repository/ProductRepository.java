package com.joel.crudproducts.products.persistency.repository;

import com.joel.crudproducts.products.persistency.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //@Query("SELECT * FROM product p WHERE p.name = ?1") puedes hacer esta consulta personalizada utilizando SQL nativo.

    // o puedes (mejor aun)

    //    con la convención de nomenclatura de Spring Data JPA te permite definir consultas de manera declarativa simplemente siguiendo un patrón de nombres en los métodos del repositorio.
    Optional<Product> findProductByName(String name);

}
