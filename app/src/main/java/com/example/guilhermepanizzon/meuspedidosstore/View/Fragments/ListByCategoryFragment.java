package com.example.guilhermepanizzon.meuspedidosstore.View.Fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guilhermepanizzon.meuspedidosstore.Model.Product;
import com.example.guilhermepanizzon.meuspedidosstore.R;
import com.example.guilhermepanizzon.meuspedidosstore.View.Activities.MainActivity;
import com.example.guilhermepanizzon.meuspedidosstore.View.Listeners.RecyclerItemClickListener;
import com.example.guilhermepanizzon.meuspedidosstore.View.Adapters.ProductAdapter;
import com.example.guilhermepanizzon.meuspedidosstore.controller.VolleyNetworkManagerRequests;

import java.util.ArrayList;


public class ListByCategoryFragment extends Fragment {

    public final static String PAR_KEY = "com.example.guilhermepanizzon.meuspedidosstore.View.Fragments.par";
    public static final String POSITION_ID = "POSITION_ID";
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    ArrayList<Product> listProductByCategory;
    private static final String ARG_PARAM1 = "position";

    Product product;
    private int mParamPosition;


    private OnFragmentInteractionListener mListener;

    public ListByCategoryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListByCategoryFragment newInstance(int param1) {
        ListByCategoryFragment fragment = new ListByCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamPosition = getArguments().getInt(MainActivity.POSITION_ID);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.list_by_category_fragment, container, false);
        RecyclerView recList = (RecyclerView) v.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        if (mParamPosition == 0) {
            listProductByCategory = VolleyNetworkManagerRequests.listProduct;
        } else {
            listProductByCategory = VolleyNetworkManagerRequests.sortProductByCategory(mParamPosition);
        }
        //  Log.v("VER O QUE DA", listProductByCategory.get(0).getName());
        ProductAdapter ca = new ProductAdapter(listProductByCategory);
        recList.setAdapter(ca);
        recList.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {
                        // TODO Handle item click
                        Log.e("@@@@@", "" + position);

                        product = listProductByCategory.get(position);
                        if (product != null) {
                            DetailsActivityFragment detailsActivityFragment = new DetailsActivityFragment();
                            Bundle args = new Bundle();
                            args.putParcelable(PAR_KEY, product);
                            detailsActivityFragment.setArguments(args);
                            mFragmentManager = getFragmentManager();
                            mFragmentTransaction = mFragmentManager.beginTransaction();
                            mFragmentTransaction.addToBackStack(null);
                            mFragmentTransaction.replace(R.id.frame_layout_category, detailsActivityFragment).commit();
                        }
                    }
                }));

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
