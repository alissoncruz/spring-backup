package br.com.gpa.james.management.service.impl;

import br.com.gpa.james.management.model.Assortment;
import br.com.gpa.james.management.model.Categories;
import br.com.gpa.james.management.model.Item;
import br.com.gpa.james.management.model.PriceSellGpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;

public abstract class AssortmentServiceAbstract {

    public Assortment parserAssortment(Assortment assortment, PriceSellGpa priceSell){
        List<Categories> categories = new ArrayList<>();
        assortment.setStoryId( nonNull(priceSell.getCodeStory()) ? priceSell.getCodeStory() : null);
        assortment.setCategories(categories);

        Categories category = new Categories();

        fillCategory(category, priceSell);

        return assortment;
    }

    private void fillCategory(Categories categories, PriceSellGpa priceSell){
        List<Item> items = new ArrayList<>();

        categories.setTitle(null);
        categories.setGpaId(null);
        categories.setItems(items);
    }

    private Item fillItem(Item item, PriceSellGpa priceSell){
        item.setProduct(priceSell.getProduct());
        item.setName("");
        item.setPrice(null);
        item.setCurrentPrice(null);
        item.setShortDescription(null);
        item.setEans(null);
        item.setStorage(null);
        item.setImages(Arrays.asList());
        return item;
    }



    public List<Assortment> mockAssortments(){
        List<Assortment> list = new ArrayList<>();
        list.add(mockAssortment());
        return list;
    }

    private Assortment mockAssortment(){
        Assortment assortment = new Assortment();
        assortment.setStoryId(123L);
        assortment.setCategories(categoriesList());
        return assortment;
    }

    private List<Categories> categoriesList(){
        return  Arrays.asList(mockCategories());
    }
    private Categories mockCategories(){
        Categories categories = new Categories();

        categories.setGpaId(100L);
        categories.setTitle("CARNES");
        categories.setTitle("AVES");

        return categories;
    }
    private Item mockItems(){
        Item items = new Item();
        items.setName("Peito de Frango");
        items.setShortDescription("Peito de frango sadia");
        return mockItems();
    }

}
