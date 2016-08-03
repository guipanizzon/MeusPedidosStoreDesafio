package com.example.guilhermepanizzon.meuspedidosstore.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by guilhermepanizzon on 7/27/16.
 */

public class Product implements Parcelable {
    private Integer productId;
    private String name;
    private String description;
    private String photo;
    private String price;
    private Integer category_id;
    private Boolean isFavoriteProduct;

    public Product(String name, String description, String photo, String price, Integer category_id) {
        this.setName(name);
        this.setDescription(description);
        this.setPhoto(photo);
        this.setPrice(price);
        this.setCategory_id(category_id);

    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPrice() {
        return price;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Boolean getFavoriteProduct() {
        return isFavoriteProduct;
    }

    public void setFavoriteProduct(Boolean favoriteProduct) {
        isFavoriteProduct = favoriteProduct;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(photo);
        parcel.writeString(price);
        parcel.writeValue(category_id);
    }

    public static final Parcelable.Creator<Product> CREATOR = new Creator<Product>() {
        public Product createFromParcel(Parcel source) {
            Product mBook = new Product();
            mBook.name = source.readString();
            mBook.description = source.readString();
            mBook.photo = source.readString();
            mBook.price = source.readString();
            mBook.category_id = source.readInt();
            return mBook;
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
