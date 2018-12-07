package com.example.mtesio.meliapp.listadeitems;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mtesio.meliapp.R;

import java.util.List;

public class ListaDeItemsActivity extends AppCompatActivity implements ListaView {

    private RecyclerView list;
    private ProgressBar progressBar;
    private ListaPresenter listaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_items);

        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress_bar);

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
        listaPresenter.onResume();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        list.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(ListaDeItems items) {
        list.setAdapter(new CustomListAdapter(items));
        hideProgress();
    }

    public void showError(){
        Toast.makeText(this, "Request on failure",
                Toast.LENGTH_LONG).show();
    }
}
