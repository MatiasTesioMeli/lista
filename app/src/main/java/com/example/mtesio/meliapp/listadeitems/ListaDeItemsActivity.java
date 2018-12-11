package com.example.mtesio.meliapp.listadeitems;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mtesio.meliapp.R;
import com.example.mtesio.meliapp.item.ItemActivity;
import com.mercadolibre.android.ui.widgets.MeliSnackbar;
import com.mercadolibre.android.ui.widgets.MeliSpinner;

public class ListaDeItemsActivity extends AppCompatActivity implements ListaView {

    private final String MY_PREFS_NAME = "MeliApp";
    private final String BUSQUEDA_SAVED = "busqueda";

    private RecyclerView list;
    private MeliSpinner progressBar;
    private ListaPresenter listaPresenter;
    private SearchView busqueda;
    private LinearLayout productos;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private final String ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_items);

        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();

        Intent intent = getIntent();
        Uri data = intent.getData();
        String stringUri = "";

        if(data != null) {
            stringUri = data.toString();
        }

        if(!stringUri.isEmpty() && stringUri != null && stringUri!= ""){
            editor.putString(BUSQUEDA_SAVED, stringUri);  // Saving string
            editor.commit();
        }

        productos = findViewById(R.id.productos);
        busqueda = findViewById(R.id.busqueda);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress_bar);



        setupSearchView();

        listaPresenter = new ListaPresenter(this, new ListaDeItems(this));
    }

    @Override
    protected void onDestroy() {
        listaPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String query=pref.getString(BUSQUEDA_SAVED, "musicman");         // getting String
        listaPresenter.onResume(query);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        productos.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        productos.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(ListaDeItems items) {
        list.setAdapter(new CustomListAdapter(items, new ItemListener()));
        hideProgress();
    }

    public void showError(){
        //Toast.makeText(this, "Request on failure", Toast.LENGTH_LONG).show();
        MeliSnackbar.make(list, "Request on failure", 3000, MeliSnackbar.Type.ERROR)
                .show();
    }

    public void navigateToNextPage(String id){
        Intent i = new Intent(this, ItemActivity.class);
        i.putExtra(ITEM_ID, id);
        startActivity(i);
    }

    public class ItemListener {
        public void onClick(String id) {
            listaPresenter.navigate(id);
        }
    };

    private void setupSearchView() {
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                busqueda.setIconified(false);
            }
        });

        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                editor.putString(BUSQUEDA_SAVED, query);  // Saving string
                editor.commit();
                listaPresenter.onResume(query);
                return true;
            }
        });
    }

}
