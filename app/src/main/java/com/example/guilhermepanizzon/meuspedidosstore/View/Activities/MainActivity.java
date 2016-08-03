package com.example.guilhermepanizzon.meuspedidosstore.View.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.android.volley.VolleyLog;
import com.example.guilhermepanizzon.meuspedidosstore.R;
import com.example.guilhermepanizzon.meuspedidosstore.View.Adapters.ProductAdapter;
import com.example.guilhermepanizzon.meuspedidosstore.View.Fragments.DetailsActivityFragment;
import com.example.guilhermepanizzon.meuspedidosstore.View.Listeners.RecyclerItemClickListener;
import com.example.guilhermepanizzon.meuspedidosstore.controller.VolleyNetworkManagerRequests;
import com.example.guilhermepanizzon.meuspedidosstore.Model.Product;
import com.example.guilhermepanizzon.meuspedidosstore.View.Listeners.VolleyResponseListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by guilhermepanizzon on 7/29/16.
 */

public class MainActivity extends BaseDrawerActivity {
    ListView mList;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    DrawerLayout drawer;
    int lastFirstVisiblePosition;
    final List<Product> listTest = new ArrayList<>();
    Context mContext;

    RecyclerView recList;
    private ProgressDialog pDialog;
    private static final String TAG = MainActivity.class.getSimpleName();
    public final static String PAR_KEY_MAIN = "com.example.guilhermepanizzon.meuspedidosstore.View.Activities.par";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);

        }


        setupNavDrawer(false);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recList.setLayoutManager(llm);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Carregando...");
        pDialog.show();
        final ProductAdapter productListAdapterRecycleView = new ProductAdapter(listTest);
        recList.setAdapter(productListAdapterRecycleView);
        mContext = getApplicationContext();

        recList.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Product product = listTest.get(position);
                        if (product != null) {

                            Bundle mBundle = new Bundle();
                            mBundle.putParcelable(PAR_KEY_MAIN, product);

                            DetailsActivityFragment detailsActivityFragment = new DetailsActivityFragment();
                            detailsActivityFragment.setArguments(mBundle);
                            mFragmentManager = getSupportFragmentManager();
                            mFragmentTransaction = mFragmentManager.beginTransaction();
                            mFragmentTransaction.addToBackStack(null);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                            mFragmentTransaction.replace(R.id.content_relative_main_layout, detailsActivityFragment).commit();
                            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        }
                    }
                })
        );
        VolleyNetworkManagerRequests.getVolleyFromJsonToProductList(new VolleyResponseListener() {

            @Override
            public void onError(String message) {
                hidePDialog();
                VolleyLog.d(TAG, "Error: " + message);
            }

            @Override
            public void onResponse(ArrayList<?> response) {
                listTest.addAll((Collection<? extends Product>) response);
                hidePDialog();
                productListAdapterRecycleView.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.onBackPressed();
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            return true;
        }
        ;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (recList != null)
            lastFirstVisiblePosition = ((LinearLayoutManager) recList.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (recList != null)
            ((LinearLayoutManager) recList.getLayoutManager()).scrollToPosition(lastFirstVisiblePosition);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        }


    }


}
