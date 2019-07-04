package br.com.gpa.james.management.repository;

import br.com.gpa.james.management.model.PriceSellGpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceSellRepository extends JpaRepository<PriceSellGpa, Long> {

    //@Query("select c from PriceSell c order by codeStory")
    //List<PriceSellGpa> findAll();
}
