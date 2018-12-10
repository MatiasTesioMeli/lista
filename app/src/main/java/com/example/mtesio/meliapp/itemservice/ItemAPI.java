package com.example.mtesio.meliapp.itemservice;

import com.example.mtesio.meliapp.item.ItemModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemAPI {

    @GET("items/{id}")
    Call<ItemModel> getItem(@Path("id") String id);
}
