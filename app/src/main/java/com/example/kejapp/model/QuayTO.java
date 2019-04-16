package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuayTO {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("quayNumber")
    @Expose
    private Long quayNumber;

    @SerializedName("portId")
    @Expose
    private Long portId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuayNumber() {
        return quayNumber;
    }

    public void setQuayNumber(Long quayNumber) {
        this.quayNumber = quayNumber;
    }

    public Long getPortId() {
        return portId;
    }

    public void setPortId(Long portId) {
        this.portId = portId;
    }
}
