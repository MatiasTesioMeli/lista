package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

public class VendedorModel {

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("permalink")
    private String permalink;

    @SerializedName("country_id")
    private String country;

    @SerializedName("address")
    private Address address;

    @SerializedName("status")
    private SellerStatus status;


    @SerializedName("seller_reputation")
    private SellerReputation sellerReputation;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public SellerReputation getSellerReputation() {
        return sellerReputation;
    }

    public void setSellerReputation(SellerReputation sellerReputation) {
        this.sellerReputation = sellerReputation;
    }

    public SellerStatus getStatus() {
        return status;
    }

    public void setStatus(SellerStatus status) {
        this.status = status;
    }
}
