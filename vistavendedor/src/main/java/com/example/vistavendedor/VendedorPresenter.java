package com.example.vistavendedor;

public class VendedorPresenter{

    private VendedorModel model;
    private VendedorView view;

    public VendedorPresenter(VendedorView view, VendedorModel modelº){
        this.model = model;
        this.view = view;
    }
}
