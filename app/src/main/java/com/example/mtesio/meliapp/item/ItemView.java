package com.example.mtesio.meliapp.item;

public interface ItemView {

    void showError(String msj);

    void setItems(ItemModel item);

    void navigateToNextPage(String meliLink);
}
