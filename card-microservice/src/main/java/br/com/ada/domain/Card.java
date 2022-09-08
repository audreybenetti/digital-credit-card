package br.com.ada.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Card {

    public Card(String name, CardFlag cardFlag, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.cardFlag = cardFlag;
        this.income = income;
        this.limit = limit;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag cardFlag;
    private BigDecimal income;
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public void setCardFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
