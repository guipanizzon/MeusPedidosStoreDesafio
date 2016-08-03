package com.example.guilhermepanizzon.meuspedidosstore.controller;

import android.util.Log;

import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.guilhermepanizzon.meuspedidosstore.Model.Category;
import com.example.guilhermepanizzon.meuspedidosstore.Model.Product;
import com.example.guilhermepanizzon.meuspedidosstore.View.Listeners.VolleyResponseListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by guilhermepanizzon on 7/31/16.
 */

public class VolleyNetworkManagerRequests {
    private static final String TAG = "VolleyNetworkManagerRequests";
    private static final String URL_CATEGORY = "https://gist.githubusercontent.com/ronanrodrigo/e84d0d969613fd0ef8f9fd08546f7155/raw/a0611f7e765fa2b745ad9a897296e082a3987f61/categories.json";
    private static final String URL_PRODUCT = "https://gist.githubusercontent.com/ronanrodrigo/b95b75cfddc6b1cb601d7f806859e1dc/raw/dc973df65664f6997eeba30158d838c4b716204c/products.json";

    static ArrayList<Category> listNavigationItem;
    public static ArrayList<Product> listProduct;
    static HashMap<String, Product> hashMap;
    static int valor = 1;

    public static void getVolleyFromJsonToProductList(final VolleyResponseListener listener) {
        listProduct = new ArrayList<>();
        JsonArrayRequest movieReq = new JsonArrayRequest(URL_PRODUCT,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            final Gson gson = new Gson();
                            JSONArray json = new JSONArray(response.toString());
                            Log.v("TESTANDO", json.toString());
                            Product[] navigation = gson.fromJson(json.toString(), Product[].class);
                            for (int i = 0; i < navigation.length; i++) {
                                listProduct.add(navigation[i]);
                            }
                            listener.onResponse(listProduct);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                listener.onError(error.toString());

            }
        });
        AppController.getInstance().addToRequestQueue(movieReq);


    }

    public static void getVolleyFromJsonToCategory(final VolleyResponseListener listener) {
        listNavigationItem = new ArrayList<>();
        JsonArrayRequest movieReq = new JsonArrayRequest(URL_CATEGORY,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            final Gson gson = new Gson();
                            JSONArray json = new JSONArray(response.toString());
                            Log.v("JSON_RESULT", json.toString());
                            Category[] navigation = gson.fromJson(json.toString(), Category[].class);
                            for (int i = 0; i < navigation.length; i++) {
                                listNavigationItem.add(navigation[i]);
                            }

                            listener.onResponse(listNavigationItem);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.toString());


            }
        });
        AppController.getInstance().addToRequestQueue(movieReq);
    }


    public static ArrayList<Product> sortProductByCategory(Integer categoryId) {

        if (categoryId == 0) {
            return listProduct;
        }

        ArrayList<Product> addAllProductsByCategoryArrayList = new ArrayList<>();

        for (int i = 0; i < listProduct.size(); i++) {
            Integer value = listProduct.get(i).getCategory_id();
            if ((value != null) && (value == categoryId)) {
                addAllProductsByCategoryArrayList.add(listProduct.get(i));

            }
        }

        return addAllProductsByCategoryArrayList;

    }
}