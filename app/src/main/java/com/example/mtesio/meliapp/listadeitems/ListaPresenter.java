package com.example.mtesio.meliapp.listadeitems;

import com.example.mtesio.meliapp.productservice.ProductsAPI;

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


    public ListaView getView() {
        return view;
    }

    public void onResume(String query) {
        if (view != null) {
            view.showProgress();
        }
        ProductsAPI.getInstance().getAllItems(query, new Callback<ListaDeItems>(){
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

    public void navigate(String id){
        if(view != null){
            view.navigateToNextPage(id);
        }
    }

}

