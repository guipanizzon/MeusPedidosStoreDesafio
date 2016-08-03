package com.example.guilhermepanizzon.meuspedidosstore.Model;

import java.util.ArrayList;

/**
 * Created by guilhermepanizzon on 7/27/16.
 */

public class Category {
    private int id;
    private String name;
    private ArrayList<Product> productArrayList;
    private int icon;

    public Category(int id, String name) {
        setId(id);
        setName(name);
    }

    public Category(int id, String name, int icon) {
        setId(id);
        setName(name);
        setIcon(icon);
    }

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
