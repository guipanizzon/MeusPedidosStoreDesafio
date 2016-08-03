package com.example.guilhermepanizzon.meuspedidosstore.Model;

/**
 * Created by guilhermepanizzon on 8/2/16.
 */

public class FavItems {

    private String productName;
    private Integer isFavoriteValue;

    public FavItems() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getIsFavoriteValue() {
        return isFavoriteValue;
    }

    public void setIsFavoriteValue(Integer isFavoriteValue) {
        this.isFavoriteValue = isFavoriteValue;
    }
}
