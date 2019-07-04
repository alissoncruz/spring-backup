package br.com.gpa.james.management.repository.impl.simulation;

import br.com.gpa.james.management.model.PriceSellGpa;
import br.com.gpa.james.management.repository.PriceSellGpaCustomRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public class PriceSellGpaSimulation implements PriceSellGpaCustomRepository {

    @Override
    public List<PriceSellGpa> findAll() {
        return mockPriceSellsGpa();
    }

    private List<PriceSellGpa> mockPriceSellsGpa(){
        return Arrays.asList(mockPriceSellGpa());
    }
    private PriceSellGpa mockPriceSellGpa(){
        PriceSellGpa priceSellGpa = new PriceSellGpa();
        priceSellGpa.setCodeStory(100L);
        priceSellGpa.setProduct(100L);
        priceSellGpa.setDescriptionFullProduct("Banana");
        priceSellGpa.setStorage(90L);
        priceSellGpa.setValueSellFrom(BigDecimal.valueOf(5.20));
        priceSellGpa.setValueSellBy(BigDecimal.valueOf(3.50));

        return priceSellGpa;
    }
}
