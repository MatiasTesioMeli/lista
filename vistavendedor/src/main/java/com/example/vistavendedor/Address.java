package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

class Address {

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
