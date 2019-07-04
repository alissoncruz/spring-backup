package br.com.gpa.james.management.model;

import javax.persistence.*;
import java.math.BigDecimal;

/*
        podemos atualizar o banco do oracle depois que pegar o estoque e a descricao do produto
 */

@Entity
@Table(name="PRECO_VENDA_ALTER")
public class PriceSellGpa {

    @Id
    @Column(name="cod_plu")
    private Long product;

    @Column(name="cod_Loja")
    private Long codeStory;

    @Column(name="val_venda_de")
    private BigDecimal valueSellFrom;

    @Column(name="val_venda_por1")
    private BigDecimal valueSellBy;

    @Column(name="desc_compl_plu")
    private String descriptionFullProduct;

    @Transient
    private Long storage;

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getCodeStory() {
        return codeStory;
    }

    public void setCodeStory(Long codeStory) {
        this.codeStory = codeStory;
    }

    public BigDecimal getValueSellFrom() {
        return valueSellFrom;
    }

    public void setValueSellFrom(BigDecimal valueSellFrom) {
        this.valueSellFrom = valueSellFrom;
    }

    public BigDecimal getValueSellBy() {
        return valueSellBy;
    }

    public void setValueSellBy(BigDecimal valueSellBy) {
        this.valueSellBy = valueSellBy;
    }

    public String getDescriptionFullProduct() {
        return descriptionFullProduct;
    }

    public void setDescriptionFullProduct(String descriptionFullProduct) {
        this.descriptionFullProduct = descriptionFullProduct;
    }

    public Long getStorage() {
        return storage;
    }

    public void setStorage(Long storage) {
        this.storage = storage;
    }
}
