package br.com.gpa.james.management.service;

import br.com.gpa.james.management.model.PriceSellGpa;

import java.util.List;

public interface PriceSellService {

    List<PriceSellGpa> findAll();
    List<PriceSellGpa> findAllSimulation();
}
