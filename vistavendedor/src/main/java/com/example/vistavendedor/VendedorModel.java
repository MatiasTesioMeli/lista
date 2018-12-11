package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

public class VendedorModel {

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("country_id")
    private String country;


    @SerializedName("address")
    private Address address;

    @SerializedName("permalink")
    private String permalink;

    @SerializedName("seller_reputation")
    private SellerReputation sellerReputation;

    @SerializedName("status")
    private SellerStatus status;

}
