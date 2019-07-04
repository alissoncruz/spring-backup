package br.com.gpa.james.management.controller;

import br.com.gpa.james.management.model.Assortment;
//import com.api.james.core.apicorejames.api.AssortmentApi;
//import com.api.james.core.apicorejames.model.AssortmentTO;
import br.com.gpa.james.management.service.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import static br.com.gpa.james.management.service.utils.ParserUtil.convertValue;

@Controller
public class AssortmentController extends BaseController /*implements AssortmentApi*/ {

//    private final Logger log =  LoggerFactory.getLogger(AssortmentController.class);
////
////    @Autowired
////    private AssortmentService assortmentService;
////
////    @Override
////    public ResponseEntity<Void> updateAssortment(AssortmentTO body) {
////        log.debug(" Start method createAssortment");
////
////        Assortment assortment = convertValue(body, Assortment.class);
////
////        assortmentService.createAssortment(assortment);
////
////        log.debug(" Start method createAssortment");
////
////        return new ResponseEntity<>(HttpStatus.OK);
////    }
}
