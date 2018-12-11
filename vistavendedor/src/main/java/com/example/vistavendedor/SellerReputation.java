package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

class SellerReputation {

    @SerializedName("level_id")
    private String level;

    @SerializedName("power_seller_status")
    private String powerSeller;

    @SerializedName("transactions")
    private Transacciones transactions;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPowerSeller() {
        return powerSeller;
    }

    public void setPowerSeller(String powerSeller) {
        this.powerSeller = powerSeller;
    }

    public Transacciones getTransactions() {
        return transactions;
    }

    public void setTransactions(Transacciones transactions) {
        this.transactions = transactions;
    }
}
