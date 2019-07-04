package br.com.gpa.james.management.repository;

import br.com.gpa.james.management.model.PriceSellGpa;

import java.util.List;

public interface PriceSellGpaCustomRepository {

    List<PriceSellGpa> findAll();
}
