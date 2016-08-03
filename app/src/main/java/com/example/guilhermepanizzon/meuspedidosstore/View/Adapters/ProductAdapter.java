package com.example.guilhermepanizzon.meuspedidosstore.View.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.guilhermepanizzon.meuspedidosstore.R;
import com.example.guilhermepanizzon.meuspedidosstore.controller.AppController;
import com.example.guilhermepanizzon.meuspedidosstore.Model.Product;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    static Context mContext;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private List<Product> productList;
    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.cardview_list, parent, false);
        mContext = itemView.getContext();
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int position) {
        Product ci = productList.get(position);
        productViewHolder.name.setText(ci.getName());
        productViewHolder.price.setText(ci.getPrice().toString());
        Product product = productList.get(position);
        productViewHolder.photo.setImageUrl(product.getPhoto(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected NetworkImageView photo;
        protected TextView price;
        protected ImageView favorite_image_view;
        public ProductViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name_textview);
            ImageLoader imageLoader = AppController.getInstance().getImageLoader();
            if (imageLoader == null)
                imageLoader = AppController.getInstance().getImageLoader();
            photo = (NetworkImageView) v.findViewById(R.id.photo_imageview_thumbnail);
            price = (TextView) v.findViewById(R.id.price_textview);
            favorite_image_view = (ImageView) v.findViewById(R.id.favorite_image_view);
        }
    }
}
