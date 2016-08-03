package com.example.guilhermepanizzon.meuspedidosstore.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyLog;
import com.example.guilhermepanizzon.meuspedidosstore.R;
import com.example.guilhermepanizzon.meuspedidosstore.View.Adapters.CategoryAdapter;
import com.example.guilhermepanizzon.meuspedidosstore.View.Adapters.NavDrawerListAdapter;
import com.example.guilhermepanizzon.meuspedidosstore.View.Fragments.ListByCategoryFragment;
import com.example.guilhermepanizzon.meuspedidosstore.controller.VolleyNetworkManagerRequests;
import com.example.guilhermepanizzon.meuspedidosstore.Model.Category;
import com.example.guilhermepanizzon.meuspedidosstore.View.Listeners.VolleyResponseListener;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseDrawerActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,
        SearchView.OnQueryTextListener {
    public static final String POSITION_ID = "POSITION_ID";
    private static final String TAG = MainActivity.class.getSimpleName();
    TextView textViewAllCategories;
    NavigationView navigationView;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> listNavigationItem;
    FragmentManager mFragmentManager;
    NavDrawerListAdapter navDrawerListAdapter;
    SearchView mSearchView;
    ImageView search_image_view_icon;
    FragmentTransaction mFragmentTransaction;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (item != null && item.getItemId() == R.id.btnMyMenu) {
            if (drawer.isDrawerOpen(GravityCompat.END)) {
                drawer.closeDrawer(GravityCompat.END);
            } else {
                drawer.openDrawer(GravityCompat.END);
            }
        }
        // Handle action buttons
        return super.onOptionsItemSelected(item);

    }

    protected void setupNavDrawer(final Boolean useDrawerIndicator) {

        mDrawerList = (ListView) findViewById(R.id.navigation_listview);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textViewAllCategories = (TextView) findViewById(R.id.textview_all_categories);
        textViewAllCategories.setOnClickListener(this);
        mSearchView = (SearchView) findViewById(R.id.category_search_view);
        search_image_view_icon = (ImageView) findViewById(R.id.search_image_view_icon);
        search_image_view_icon.setOnClickListener(this);
        listNavigationItem = new ArrayList<>();
        navigationView.inflateMenu(R.menu.activity_main_drawer); //inflate new items.
        categoryAdapter = new CategoryAdapter(listNavigationItem, getApplicationContext());
        mDrawerList.setAdapter(categoryAdapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerList.setTextFilterEnabled(true);


        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                mSearchView.setEnabled(false);

                return true;
            }
        });

        setupSearchView();


        VolleyNetworkManagerRequests.getVolleyFromJsonToCategory(new VolleyResponseListener() {
            @Override
            public void onError(String message) {
                VolleyLog.d("ERROR_MESSAGE", message);

                updateScreenWithRefreshOption();

            }

            @Override
            public void onResponse(ArrayList<?> response) {
                // ArrayList<Category> p = ((ArrayList<Category>) response);

                listNavigationItem.addAll((Collection<? extends Category>) response);
                categoryAdapter.notifyDataSetChanged();

            }

        });

    }


    protected void closeDrawer() {
        mDrawerLayout.closeDrawer(mDrawerList);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }


    protected void setDrawerItemChecked(int position, boolean value) {
        mDrawerList.setItemChecked(position, value);
    }

    public void onClick(View arg0) {

        if (arg0 == textViewAllCategories) {

            ListByCategoryFragment listByCategoryFragment = new ListByCategoryFragment();
            Bundle args = new Bundle();
            args.putInt(POSITION_ID, 0);
            listByCategoryFragment.setArguments(args);
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.content_relative_main_layout, listByCategoryFragment).commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.END);

        }
        if (arg0 == search_image_view_icon) {

            mSearchView.requestFocusFromTouch();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
        }

    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                search_image_view_icon.setVisibility(View.VISIBLE);

            }
        });
        mSearchView.setQueryHint("Categorias");
        mSearchView.setSubmitButtonEnabled(false);

    }

    @Override
    public boolean onQueryTextChange(String newText) {

        search_image_view_icon.setVisibility(View.VISIBLE);


        if (TextUtils.isEmpty(newText)) {
            mDrawerList.clearTextFilter();
        } else {
            mDrawerList.setFilterText(newText);
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            ListByCategoryFragment listByCategoryFragment = new ListByCategoryFragment();
            Bundle args = new Bundle();
            args.putInt(POSITION_ID, position + 1);
            listByCategoryFragment.setArguments(args);
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.content_relative_main_layout, listByCategoryFragment).commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.END);

        }
    }

    public void updateScreenWithRefreshOption() {

        AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this)
                .setTitle("")
                .setMessage("");
        final FrameLayout frameView = new FrameLayout(getApplicationContext());
        builder.setView(frameView);

        final AlertDialog alertDialog = builder.create();
        LayoutInflater inflater = alertDialog.getLayoutInflater();
        View dialoglayout = inflater.inflate(R.layout.network_problem_connection_layout, frameView);
        dialoglayout.findViewById(R.id.button_refresh_connection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        alertDialog.show();


    }

}
