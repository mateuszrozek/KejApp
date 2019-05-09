package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MakeReservationRequest {

    @SerializedName("portId")
    @Expose
    Long portId;

    @SerializedName("pier")
    @Expose
    String pier;

    @SerializedName("quayNumber")
    @Expose
    Double quayNumber;

    public Long getPortId() {
        return portId;
    }

    public void setPortName(Long portId) {
        this.portId = portId;
    }

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public Double getQuayNumber() {
        return quayNumber;
    }

    public void setQuayNumber(Double quayNumber) {
        this.quayNumber = quayNumber;
    }
}
