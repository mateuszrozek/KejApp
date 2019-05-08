package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MakeReservationRequest {

    @SerializedName("portName")
    @Expose
    String portName;

    @SerializedName("pier")
    @Expose
    String pier;

    @SerializedName("quayNumber")
    @Expose
    Double quayNumber;

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
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
