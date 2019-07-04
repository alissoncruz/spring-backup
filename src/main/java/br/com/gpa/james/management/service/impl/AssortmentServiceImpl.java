package br.com.gpa.james.management.service.impl;

import br.com.gpa.james.management.model.Assortment;
import br.com.gpa.james.management.model.PriceSellGpa;
import br.com.gpa.james.management.service.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AssortmentServiceImpl extends AssortmentServiceAbstract implements AssortmentService {

    private final Logger log =  LoggerFactory.getLogger(AssortmentServiceImpl.class);

    @Override
    public void createAssortment(Assortment assortment) {
        log.debug("Start method createAssortment");


        log.debug("Finish method createAssortment");
    }

    @Override
    public Assortment fillAssortment(Assortment assortment, PriceSellGpa price) {
        return parserAssortment(assortment,  price);
    }


}
