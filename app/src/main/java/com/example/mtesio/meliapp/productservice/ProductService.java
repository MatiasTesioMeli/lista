package com.example.mtesio.meliapp.productservice;

import com.example.mtesio.meliapp.listadeitems.Item;
import com.example.mtesio.meliapp.listadeitems.ListaDeItems;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductService {
    @GET("sites/MLA/search")
    Call<ListaDeItems> getAllItems(@Query("q") String prod);
}
