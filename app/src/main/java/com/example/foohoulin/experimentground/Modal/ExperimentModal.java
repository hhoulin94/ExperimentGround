package com.example.foohoulin.experimentground.Modal;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExperimentModal {
    private String itemTitle ;
    private String itemCurrency ;
    private double itemPrice ;
    private boolean itemFavour ;


    public void setItemTitle(String title){
        this.itemTitle = title ;
    }

    public void setItemCurrency(String currency){
        this.itemCurrency = currency ;
    }

    public void setItemPrice(double price){
        this.itemPrice = price ;
    }

    public void setItemFavour(boolean favour){
        this.itemFavour = favour ;
    }

    public String getItemTitle(){
        return itemTitle ;
    }

    public String getItemCurrency(){
        return itemCurrency ;
    }

    public String getItemPrice(){
        NumberFormat formatter = new DecimalFormat("#0.00") ;
        return formatter.format(itemPrice) ;
    }

    public boolean getItemFavour(){
        return itemFavour ;
    }
}
