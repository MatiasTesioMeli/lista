package com.example.mtesio.meliapp.listadeitems;

import android.widget.Toast;

import com.example.mtesio.meliapp.productservice.ProductService;
import com.example.mtesio.meliapp.productservice.ProductsAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaPresenter {

    private ListaDeItems listaDeItems;
    private ListaView view;

    public ListaPresenter(ListaView view, ListaDeItems listaDeItems){
        this.view = view;
        this.listaDeItems = listaDeItems;
    }

    public void onDestroy() {
        view = null;
    }


    public void onResume() {
        if (view != null) {
            view.showProgress();
        }
        ProductsAPI.getInstance().getAllItems("fender", new Callback<ListaDeItems>(){
            @Override
            public void onResponse(Call<ListaDeItems> call, Response<ListaDeItems> response) {
                if(response.isSuccessful()){
                    view.setItems(response.body());
                }
            }

            @Override
            public void onFailure(Call<ListaDeItems> call, Throwable t) {
                view.showError();
            }
        });

    }

}

