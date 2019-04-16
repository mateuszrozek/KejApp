package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PierTO implements Serializable {

    @SerializedName("portId")
    @Expose
    Long portId;

    @SerializedName("pierId")
    @Expose
    String pierId;

    @SerializedName("freeQuaysNumbers")
    @Expose
    List<Long> freeQuaysNumbers;

    @SerializedName("allQuaysQuantity")
    @Expose
    int allQuaysQuantity;

    public Long getPortId() {
        return portId;
    }

    public void setPortId(Long portId) {
        this.portId = portId;
    }

    public String getPierId() {
        return pierId;
    }

    public void setPierId(String pierId) {
        this.pierId = pierId;
    }

    public List<Long> getFreeQuaysNumbers() {
        return freeQuaysNumbers;
    }

    public void setFreeQuaysNumbers(List<Long> freeQuaysNumbers) {
        this.freeQuaysNumbers = freeQuaysNumbers;
    }

    public int getAllQuaysQuantity() {
        return allQuaysQuantity;
    }

    public void setAllQuaysQuantity(int allQuaysQuantity) {
        this.allQuaysQuantity = allQuaysQuantity;
    }
}
