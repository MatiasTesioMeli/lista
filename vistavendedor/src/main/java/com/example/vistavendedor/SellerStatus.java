package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

class SellerStatus {

    @SerializedName("site_status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
