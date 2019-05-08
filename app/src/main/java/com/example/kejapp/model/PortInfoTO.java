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

    @SerializedName("entryDescription")
    @Expose
    String entryDescription;
    @SerializedName("phoneNumber")
    @Expose
    String phoneNumber;
    @SerializedName("website")
    @Expose
    String website;

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

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
