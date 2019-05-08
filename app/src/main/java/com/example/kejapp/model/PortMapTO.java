package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PortMapTO implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("latitude")
    @Expose
    private Double latitude;

    @SerializedName("longitude")
    @Expose
    private Double longitude;

    @SerializedName("freeQuaysQuantity")
    @Expose
    int freeQuaysQuantity;

    @SerializedName("allQuaysQuantity")
    @Expose
    int allQuaysQuantity;

    @SerializedName("calculatedPrice")
    @Expose
    Double calculatedPrice;

    @SerializedName("engineForbidden")
    @Expose
    Boolean engineForbidden;

    @SerializedName("gasStation")
    @Expose
    Boolean gasStation;

    @SerializedName("medicalCare")
    @Expose
    Boolean medicalCare;

    @SerializedName("sailingStore")
    @Expose
    Boolean sailingStore;

    @SerializedName("nightLights")
    @Expose
    Boolean nightLights;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getFreeQuaysQuantity() {
        return freeQuaysQuantity;
    }

    public void setFreeQuaysQuantity(int freeQuaysQuantity) {
        this.freeQuaysQuantity = freeQuaysQuantity;
    }

    public int getAllQuaysQuantity() {
        return allQuaysQuantity;
    }

    public void setAllQuaysQuantity(int allQuaysQuantity) {
        this.allQuaysQuantity = allQuaysQuantity;
    }

    public Double getCalculatedPrice() {
        return calculatedPrice;
    }

    public void setCalculatedPrice(Double calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }

    public Boolean getEngineForbidden() {
        return engineForbidden;
    }

    public void setEngineForbidden(Boolean engineForbidden) {
        this.engineForbidden = engineForbidden;
    }

    public Boolean getGasStation() {
        return gasStation;
    }

    public void setGasStation(Boolean gasStation) {
        this.gasStation = gasStation;
    }

    public Boolean getMedicalCare() {
        return medicalCare;
    }

    public void setMedicalCare(Boolean medicalCare) {
        this.medicalCare = medicalCare;
    }

    public Boolean getSailingStore() {
        return sailingStore;
    }

    public void setSailingStore(Boolean sailingStore) {
        this.sailingStore = sailingStore;
    }

    public Boolean getNightLights() {
        return nightLights;
    }

    public void setNightLights(Boolean nightLights) {
        this.nightLights = nightLights;
    }
}
