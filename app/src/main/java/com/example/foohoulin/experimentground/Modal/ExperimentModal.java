package com.example.foohoulin.experimentground.Modal;

import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ExperimentModal {
    private String itemTitle ;
    private String itemCurrency ;
    private double itemPrice ;
    private boolean itemFavour ;
    private String itemAddress ;
    private float lat ;
    private float lng;
    private LatLng latLng ;

    public ExperimentModal(String itemTitle , String itemAddress , LatLng latLng){
        this.itemTitle = itemTitle ;
        this.itemAddress = itemAddress ;
        this.latLng = latLng ;
    }

    public LatLng getLatLng() { return latLng; }

    public void setLatLng(LatLng latLng){ this.latLng = latLng ; }

    public String getItemAddress() { return itemAddress; }

    public void setItemAddress(String itemAddress) { this.itemAddress = itemAddress; }

    public void setLat(float lat){this.lat = lat ;}

    public float getLat(){return lat ;}

    public void setLng(float lng){this.lng = lng;}

    public float getLng(){return lng;}

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
