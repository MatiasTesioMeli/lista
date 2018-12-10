package com.example.mtesio.meliapp.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ItemImages {

    @SerializedName("url")
    @Expose
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
