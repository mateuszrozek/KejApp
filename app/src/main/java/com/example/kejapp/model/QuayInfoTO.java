package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuayInfoTO {

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
    Double quayNumber;

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
}
