package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuayTO implements Serializable {

    @SerializedName("portId")
    @Expose
    private Long portId;

    @SerializedName("pier")
    @Expose
    private String pier;

    @SerializedName("quayNumber")
    @Expose
    private Long quayNumber;

    public Long getPortId() {
        return portId;
    }

    public void setPortId(Long portId) {
        this.portId = portId;
    }

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public Long getQuayNumber() {
        return quayNumber;
    }

    public void setQuayNumber(Long quayNumber) {
        this.quayNumber = quayNumber;
    }
}
