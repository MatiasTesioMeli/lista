package com.example.mtesio.meliapp.listadeitems;

import android.view.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("title")
    @Expose
    private String description;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("thumbnail")
    @Expose
    private String image;

    @SerializedName("id")
    @Expose
    private String id;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Item(String image, String description, String price){
        this.image = image;
        this.description = description;
        this.price = price;

    }

    public String getId() {
        return id;
    }
}
