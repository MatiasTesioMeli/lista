package com.example.mtesio.meliapp.productservice;

import com.example.mtesio.meliapp.listadeitems.ListaDeItems;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsAPI {

    private static final String BASE_URL = "https://api.mercadolibre.com/";
    private static ProductsAPI instance;
    private static ProductService iMeliService;

    private ProductsAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iMeliService = retrofit.create(ProductService.class);
    }

    public static ProductsAPI getInstance(){
        if(instance == null){
            instance = new ProductsAPI();
        }

        return instance;
    }

    public void getAllItems(String query, Callback<ListaDeItems> callback){
        iMeliService.getAllItems(query).enqueue(callback);
    }
}


