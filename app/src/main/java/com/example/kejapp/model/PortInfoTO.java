package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PortInfoTO implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("entranceWidth")
    @Expose
    private Double entranceWidth;

    @SerializedName("entranceDepth")
    @Expose
    private Double entranceDepth;

    @SerializedName("maxVesselSubmersion")
    @Expose
    private Double maxVesselSubmersion;

    @SerializedName("maxVesselLength")
    @Expose
    private Double maxVesselLength;

    @SerializedName("maxVesselWidth")
    @Expose
    private Double maxVesselWidth;

    @SerializedName("dailyWaterLevelUp")
    @Expose
    private Double dailyWaterLevelUp;

    @SerializedName("dailyWaterLevelDown")
    @Expose
    private Double dailyWaterLevelDown;

    @SerializedName("showerPrice")
    @Expose
    private Double showerPrice;

    @SerializedName("bathroomPrice")
    @Expose
    private Double bathroomPrice;

    @SerializedName("electricityPrice")
    @Expose
    private Double electricityPrice;

    @SerializedName("currentWaterPrice")
    @Expose
    private Double currentWaterPrice;

    @SerializedName("toiletEmptyingPrice")
    @Expose
    private Double toiletEmptyingPrice;

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

    public Double getEntranceWidth() {
        return entranceWidth;
    }

    public void setEntranceWidth(Double entranceWidth) {
        this.entranceWidth = entranceWidth;
    }

    public Double getEntranceDepth() {
        return entranceDepth;
    }

    public void setEntranceDepth(Double entranceDepth) {
        this.entranceDepth = entranceDepth;
    }

    public Double getMaxVesselSubmersion() {
        return maxVesselSubmersion;
    }

    public void setMaxVesselSubmersion(Double maxVesselSubmersion) {
        this.maxVesselSubmersion = maxVesselSubmersion;
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

    public Double getDailyWaterLevelUp() {
        return dailyWaterLevelUp;
    }

    public void setDailyWaterLevelUp(Double dailyWaterLevelUp) {
        this.dailyWaterLevelUp = dailyWaterLevelUp;
    }

    public Double getDailyWaterLevelDown() {
        return dailyWaterLevelDown;
    }

    public void setDailyWaterLevelDown(Double dailyWaterLevelDown) {
        this.dailyWaterLevelDown = dailyWaterLevelDown;
    }

    public Double getShowerPrice() {
        return showerPrice;
    }

    public void setShowerPrice(Double showerPrice) {
        this.showerPrice = showerPrice;
    }

    public Double getBathroomPrice() {
        return bathroomPrice;
    }

    public void setBathroomPrice(Double bathroomPrice) {
        this.bathroomPrice = bathroomPrice;
    }

    public Double getElectricityPrice() {
        return electricityPrice;
    }

    public void setElectricityPrice(Double electricityPrice) {
        this.electricityPrice = electricityPrice;
    }

    public Double getCurrentWaterPrice() {
        return currentWaterPrice;
    }

    public void setCurrentWaterPrice(Double currentWaterPrice) {
        this.currentWaterPrice = currentWaterPrice;
    }

    public Double getToiletEmptyingPrice() {
        return toiletEmptyingPrice;
    }

    public void setToiletEmptyingPrice(Double toiletEmptyingPrice) {
        this.toiletEmptyingPrice = toiletEmptyingPrice;
    }
}
