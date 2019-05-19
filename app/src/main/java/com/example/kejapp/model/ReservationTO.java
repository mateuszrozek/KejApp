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

    @SerializedName("id")
    @Expose
    Long id;

    @SerializedName("startDate")
    @Expose
    String startDate;

    @SerializedName("endDate")
    @Expose
    String endDate;

    public QuayInfoTO getQuayInfoTO() {
        return quayInfoTO;
    }

    public void setQuayInfoTO(QuayInfoTO quayInfoTO) {
        this.quayInfoTO = quayInfoTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
