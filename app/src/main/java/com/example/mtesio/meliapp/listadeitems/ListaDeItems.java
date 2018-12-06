package com.example.mtesio.meliapp.listadeitems;

import android.content.Context;
import android.os.Handler;

import com.example.mtesio.meliapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListaDeItems {

    private List<Item> list;

    public ListaDeItems(Context context){
        list = new ArrayList<Item>();
        Item i1 = new Item(context.getResources().getDrawable(R.drawable.img1),"Esta es una descripcion ","Precio: 124.34");
        Item i2 = new Item(context.getResources().getDrawable(R.drawable.img2),"Esta es una descripcion ","Precio: 125.34");
        Item i3 = new Item(context.getResources().getDrawable(R.drawable.img3),"Esta es una descripcion ","Precio: 126.34");
        Item i8 = new Item(context.getResources().getDrawable(R.drawable.img7),"Esta es una descripcion ","Precio: 127.34");
        Item i4 = new Item(context.getResources().getDrawable(R.drawable.img4),"Esta es una descripcion ","Precio: 127.34");
        Item i9 = new Item(context.getResources().getDrawable(R.drawable.img7),"Esta es una descripcion ","Precio: 127.34");
        Item i5 = new Item(context.getResources().getDrawable(R.drawable.img5),"Esta es una descripcion ","Precio: 127.34");
        Item i6 = new Item(context.getResources().getDrawable(R.drawable.img6),"Esta es una descripcion ","Precio: 127.34");
        Item i7 = new Item(context.getResources().getDrawable(R.drawable.img7),"Esta es una descripcion ","Precio: 127.34");
        list.add(i1);
        list.add(i2);
        list.add(i8);
        list.add(i3);
        list.add(i4);
        list.add(i9);
        list.add(i5);
        list.add(i6);
        list.add(i7);
    }

    public void generateList(ListaPresenter lp){
        new Handler().postDelayed(() ->lp.onSuccess(list), 2000);
    }

    public List<Item> getList(){
         return list;
    }

}
