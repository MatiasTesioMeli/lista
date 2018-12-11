package com.example.mtesio.meliapp.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemModel {

    @SerializedName("pictures")
    @Expose
    private List<ItemImages> images;

    @SerializedName("title")
    @Expose
    private String titulo;

    @SerializedName("available_quantity")
    @Expose
    private String cantidadDisponible;

    @SerializedName("accepts_mercadopago")
    @Expose
    private String mercadopago;

    @SerializedName("price")
    @Expose
    private String precio;

    @SerializedName("currency_id")
    @Expose
    private String currency;

    @SerializedName("condition")
    @Expose
    private String condition;

    @SerializedName("permalink")
    @Expose
    private String uriArticuloMeli;

    @SerializedName("warranty")
    @Expose
    private String descripcion;

    @SerializedName("seller_id")
    @Expose
    private String seller_id;

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public List<ItemImages> getImages() {
        return images;
    }

    public void setImages(List<ItemImages> images) {
        this.images = images;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getMercadopago() {
        return mercadopago;
    }

    public void setMercadopago(String mercadopago) {
        this.mercadopago = mercadopago;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        condition = condition;
    }

    public String getUriArticuloMeli() {
        return uriArticuloMeli;
    }

    public void setUriArticuloMeli(String uriArticuloMeli) {
        this.uriArticuloMeli = uriArticuloMeli;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
