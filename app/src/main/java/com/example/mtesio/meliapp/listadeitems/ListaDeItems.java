package com.example.mtesio.meliapp.listadeitems;

import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListaDeItems {

    @SerializedName("results")
    @Expose
    private List<Item> list;

    public ListaDeItems(Context context){
        list = new ArrayList<Item>();
    }

    public void generateList(ListaDeItems list){
        this.list = list.getList();

    }

    public List<Item> getList(){
         return list;
    }

}
