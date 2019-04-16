package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ReservationTO implements Serializable {

    @SerializedName("pierId")
    @Expose
    String pierId;

    @SerializedName("freeQuaysNumbers")
    @Expose
    List<Long> freeQuaysNumbers;

    @SerializedName("allQuaysQuantity")
    @Expose
    int allQuaysQuantity;
}
