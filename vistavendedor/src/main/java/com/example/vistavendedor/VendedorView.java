package com.example.vistavendedor;

public interface VendedorView {

    void setItems(VendedorModel vendedor);

    void showError();

    void navigateToNextPage(String meliLink);
}
