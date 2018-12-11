package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

class SellerReputation {

    @SerializedName("level_id")
    private String level;

    @SerializedName("power_seller_status")
    private String powerSeller;

    @SerializedName("total")
    private String transactions;
}
