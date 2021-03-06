package br.edu.ifrs.canoas.labds.moveis.moveisspringbackend.repository;

import br.edu.ifrs.canoas.labds.moveis.moveisspringbackend.domain.ProductPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase, Long> {
    @Query("SELECT SUM(c.amount) FROM ProductPurchase c")
    Long getSumProductAmount();
}
