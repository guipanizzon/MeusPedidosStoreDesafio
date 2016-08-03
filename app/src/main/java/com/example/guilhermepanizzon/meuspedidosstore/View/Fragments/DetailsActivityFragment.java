package com.example.guilhermepanizzon.meuspedidosstore.View.Fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.guilhermepanizzon.meuspedidosstore.R;
import com.example.guilhermepanizzon.meuspedidosstore.View.Activities.MainActivity;
import com.example.guilhermepanizzon.meuspedidosstore.controller.AppController;
import com.example.guilhermepanizzon.meuspedidosstore.Model.Product;


public class DetailsActivityFragment extends Fragment {
    NetworkImageView photo_details_imageview;
    TextView name_details_textview, price_details_textview, description_details_textview;
    ImageLoader imageLoader;
    Product parcelable, parcelableMain;
    private static final String ARG_PARAM1 = "position";
    private int mParamPosition;
    private OnFragmentInteractionListener mListener;

    public DetailsActivityFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DetailsActivityFragment newInstance(int param1) {
        DetailsActivityFragment fragment = new DetailsActivityFragment();
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
            parcelable = getArguments().getParcelable(ListByCategoryFragment.PAR_KEY);
            parcelableMain = getArguments().getParcelable(MainActivity.PAR_KEY_MAIN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        final View v = inflater.inflate(R.layout.details_activity_fragment, container, false);

        imageLoader = AppController.getInstance().getImageLoader();
        photo_details_imageview = (NetworkImageView) v.findViewById(R.id.photo_details_fragment);
        name_details_textview = (TextView) v.findViewById(R.id.name_details_textview);
        price_details_textview = (TextView) v.findViewById(R.id.price_details_textview);
        description_details_textview = (TextView) v.findViewById(R.id.description_details_textview);
        if (parcelable != null) {
            setViewsValueByParcelableContextCriteria(parcelable);
        } else if (parcelableMain != null) {
            setViewsValueByParcelableContextCriteria(parcelableMain);
        }
        setHasOptionsMenu(true);


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

    public void setViewsValueByParcelableContextCriteria(Product parcelableCriteria) {
        name_details_textview.setText(parcelableCriteria.getName());
        price_details_textview.setText(parcelableCriteria.getPrice());
        description_details_textview.setText(parcelableCriteria.getDescription());
        photo_details_imageview.setImageUrl(parcelableCriteria.getPhoto(), imageLoader);


    }
}

