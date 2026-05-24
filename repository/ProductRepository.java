package org.example.ex1.repository;

import jakarta.transaction.Transactional;
import org.example.ex1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySku(String sku);

    @Modifying
    @Transactional
    @Query("""
        UPDATE Product p
        SET p.quantity = p.quantity + :quantity
        WHERE p.sku = :sku
    """)
    int stockIn(@Param("sku") String sku,
                @Param("quantity") Integer quantity);

    @Modifying
    @Transactional
    @Query("""
        UPDATE Product p
        SET p.quantity = p.quantity - :quantity
        WHERE p.sku = :sku
        AND p.quantity >= :quantity
    """)
    int stockOut(@Param("sku") String sku,
                 @Param("quantity") Integer quantity);
}