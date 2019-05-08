package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationTO implements Serializable {

    @SerializedName("quayInfoTO")
    @Expose
    QuayInfoTO quayInfoTO;

    @SerializedName("startDate")
    @Expose
    LocalDateTime startDate;

    @SerializedName("endDate")
    @Expose
    LocalDateTime endDate;

    public QuayInfoTO getQuayInfoTO() {
        return quayInfoTO;
    }

    public void setQuayInfoTO(QuayInfoTO quayInfoTO) {
        this.quayInfoTO = quayInfoTO;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
