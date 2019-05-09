package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuayInfoTO implements Serializable {

    @SerializedName("portName")
    @Expose
    String portName;

    @SerializedName("latitude")
    @Expose
    Double latitude;

    @SerializedName("longitude")
    @Expose
    Double longitude;

    @SerializedName("pier")
    @Expose
    String pier;

    @SerializedName("quayNumber")
    @Expose
    Long quayNumber;

    @SerializedName("maxVesselLength")
    @Expose
    Double maxVesselLength;

    @SerializedName("maxVesselWidth")
    @Expose
    Double maxVesselWidth;

    @SerializedName("maxVesselSubmersion")
    @Expose
    Double maxVesselSubmersion;

    @SerializedName("mooringAvailable")
    @Expose
    Boolean mooringAvailable;

    @SerializedName("mooringType")
    @Expose
    String mooringType;

    @SerializedName("buoyAvailable")
    @Expose
    Boolean buoyAvailable;

    @SerializedName("anchorRequired")
    @Expose
    Boolean anchorRequired;

    @SerializedName("electricityAvailable")
    @Expose
    Boolean electricityAvailable;

    @SerializedName("currentWaterAvailable")
    @Expose
    Boolean currentWaterAvailable;

    @SerializedName("calculatedPrice")
    @Expose
    Double calculatedPrice;

    @SerializedName("notes")
    @Expose
    String notes;


    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
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

    public Double getMaxVesselLength() {
        return maxVesselLength;
    }

    public void setMaxVesselLength(Double maxVesselLength) {
        this.maxVesselLength = maxVesselLength;
    }

    public Double getMaxVesselWidth() {
        return maxVesselWidth;
    }

    public void setMaxVesselWidth(Double maxVesselWidth) {
        this.maxVesselWidth = maxVesselWidth;
    }

    public Double getMaxVesselSubmersion() {
        return maxVesselSubmersion;
    }

    public void setMaxVesselSubmersion(Double maxVesselSubmersion) {
        this.maxVesselSubmersion = maxVesselSubmersion;
    }

    public Boolean getMooringAvailable() {
        return mooringAvailable;
    }

    public void setMooringAvailable(Boolean mooringAvailable) {
        this.mooringAvailable = mooringAvailable;
    }

    public String getMooringType() {
        return mooringType;
    }

    public void setMooringType(String mooringType) {
        this.mooringType = mooringType;
    }

    public Boolean getBuoyAvailable() {
        return buoyAvailable;
    }

    public void setBuoyAvailable(Boolean buoyAvailable) {
        this.buoyAvailable = buoyAvailable;
    }

    public Boolean getAnchorRequired() {
        return anchorRequired;
    }

    public void setAnchorRequired(Boolean anchorRequired) {
        this.anchorRequired = anchorRequired;
    }

    public Boolean getElectricityAvailable() {
        return electricityAvailable;
    }

    public void setElectricityAvailable(Boolean electricityAvailable) {
        this.electricityAvailable = electricityAvailable;
    }

    public Boolean getCurrentWaterAvailable() {
        return currentWaterAvailable;
    }

    public void setCurrentWaterAvailable(Boolean currentWaterAvailable) {
        this.currentWaterAvailable = currentWaterAvailable;
    }

    public Double getCalculatedPrice() {
        return calculatedPrice;
    }

    public void setCalculatedPrice(Double calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
