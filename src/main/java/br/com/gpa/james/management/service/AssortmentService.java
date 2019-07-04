package br.com.gpa.james.management.service;

import br.com.gpa.james.management.model.Assortment;
import br.com.gpa.james.management.model.PriceSellGpa;

public interface AssortmentService {

    void createAssortment(Assortment assortment);

    Assortment fillAssortment(Assortment assortment, PriceSellGpa price);
}
