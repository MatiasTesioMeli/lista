package com.example.vistavendedor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vendedorservice.VendedorService;

public class VendedorPresenter{

    private VendedorModel model;
    private VendedorView view;

    public VendedorPresenter(VendedorView view, VendedorModel model){
        this.model = model;
        this.view = view;
    }

    public void onDestroy() {
        view = null;
    }

    public void onResume(String id) {

        VendedorService.getInstance().getItem(id, new Callback<VendedorModel>(){
            @Override
            public void onResponse(Call<VendedorModel> call, Response<VendedorModel> response) {
                if(response.isSuccessful()){
                    model = response.body();
                    view.setItems(model);
                }
            }

            @Override
            public void onFailure(Call<VendedorModel> call, Throwable t) {
                view.showError();
            }
        });
    }

    public void navigate(String route){
        if(view != null){
            if(route.equals("meli-vendedor"))
                view.navigateToNextPage(model.getPermalink());
        }
    }
}
