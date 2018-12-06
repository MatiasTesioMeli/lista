package com.example.mtesio.meliapp.listadeitems;

import java.util.List;

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
        listaDeItems.generateList(this);
    }

    public void onSuccess(List<Item> list){
        view.setItems(list);
    }
}

