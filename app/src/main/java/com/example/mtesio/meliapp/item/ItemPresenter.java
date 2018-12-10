package com.example.mtesio.meliapp.item;

import com.example.mtesio.meliapp.itemservice.ItemService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemPresenter {

    private ItemView view;
    private ItemModel itemModel;

    public ItemPresenter(ItemView view, ItemModel itemModel){
        this.view = view;
        this.itemModel = itemModel;
    }

    public void onDestroy() {
        view = null;
    }


    public ItemView getView() {
        return view;
    }

    public void onResume(String id) {

        ItemService.getInstance().getItem(id, new Callback<ItemModel>(){
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                if(response.isSuccessful()){
                    itemModel = response.body();
                    view.setItems(itemModel);
                }
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                view.showError("onFailureItemReq");
            }
        });

    }

    public void navigate(){
        if(view != null){
            view.navigateToNextPage(itemModel.getUriArticuloMeli());
        }
    }

}
