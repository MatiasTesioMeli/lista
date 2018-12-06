package com.example.mtesio.meliapp.listadeitems;

import android.graphics.drawable.Drawable;

public class Item {

    private Drawable image;
    private String description;
    private String price;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
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

    public Item(Drawable image, String description, String price){
        this.image = image;
        this.description = description;
        this.price = price;

    }
}
