package com.example.mtesio.meliapp.listadeitems;

import java.util.List;

public interface ListaView {

    void showProgress();

    void hideProgress();

    void setItems(List<Item> items);
}
