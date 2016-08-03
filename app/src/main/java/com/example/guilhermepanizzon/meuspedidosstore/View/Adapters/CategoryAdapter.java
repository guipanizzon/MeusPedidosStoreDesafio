package com.example.guilhermepanizzon.meuspedidosstore.View.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.guilhermepanizzon.meuspedidosstore.Model.Category;
import com.example.guilhermepanizzon.meuspedidosstore.R;


import java.util.ArrayList;

/**
 * Created by guilhermepanizzon on 7/30/16.
 */



public class CategoryAdapter extends BaseAdapter implements Filterable {

    public class ViewHolder {
        TextView txtTitle;


    }

    public ArrayList<Category> categoryArrayList;

    public Context context;
    public ArrayList<Category> orig;
    public CategoryAdapter(ArrayList<Category> categoryArrayList, Context context) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoryArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ViewHolder viewHolder;

        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            rowView = inflater.inflate(R.layout.drawer_list_item, null);
            // configure view holder
            viewHolder = new ViewHolder();
            viewHolder.txtTitle = (TextView) rowView.findViewById(R.id.drawer_list_item_text_view);


            rowView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtTitle.setText(categoryArrayList.get(position).getName() + "");
        return rowView;


    }

    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<Category> results = new ArrayList<Category>();
                if (orig == null)
                    orig = categoryArrayList;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final Category g : orig) {
                            if (g.getName().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                categoryArrayList = (ArrayList<Category>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


}
