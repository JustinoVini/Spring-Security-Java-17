package br.com.vinicius.crud.domain.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinicius.crud.domain.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByActiveTrue();

}
