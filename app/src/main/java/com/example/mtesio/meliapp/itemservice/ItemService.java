package com.example.mtesio.meliapp.itemservice;

import com.example.mtesio.meliapp.item.ItemModel;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemService {

    private static final String BASE_URL = "https://api.mercadolibre.com/";
    private static ItemService instance;
    private static ItemAPI iItemMeliService;

    private ItemService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iItemMeliService = retrofit.create(ItemAPI.class);
    }

    public static ItemService getInstance(){
        if(instance == null){
            instance = new ItemService();
        }

        return instance;
    }

    public void getItem(String query, Callback<ItemModel> callback){
        iItemMeliService.getItem(query).enqueue(callback);
    }
}




