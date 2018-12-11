package com.example.vistavendedor;

import com.google.gson.annotations.SerializedName;

class Transacciones {

    @SerializedName("canceled")
    private String cancelled;
    @SerializedName("completed")
    private String completed;
    @SerializedName("total")
    private String total;

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
