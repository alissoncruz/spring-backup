package br.com.gpa.james.management.service.impl;

import br.com.gpa.james.management.model.PriceSellGpa;
import br.com.gpa.james.management.repository.PriceSellRepository;
import br.com.gpa.james.management.service.PriceSellService;
import br.com.gpa.james.management.repository.PriceSellGpaCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceSellServiceImpl implements PriceSellService {

    @Autowired
    private PriceSellGpaCustomRepository priceSellGpaCustomRepository;

    @Autowired
    private PriceSellRepository priceSellRepository;

    @Override
    public List<PriceSellGpa> findAll() {

        List<PriceSellGpa> prices = new ArrayList<>();
        Iterable<PriceSellGpa> list = priceSellRepository.findAll();
        list.forEach(priceSellGpa -> {
            prices.add(priceSellGpa);
        });
        return prices;
    }

    @Override
    public List<PriceSellGpa> findAllSimulation() {
        return priceSellGpaCustomRepository.findAll();
    }
}
