package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateUserTO {

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("password")
    @Expose
    String password;

    @SerializedName("phoneNumber")
    @Expose
    String phoneNumber;

    @SerializedName("userName")
    @Expose
    String userName;

    @SerializedName("userSurname")
    @Expose
    String userSurname;

    @SerializedName("vesselName")
    @Expose
    String vesselName;

    @SerializedName("vesselLength")
    @Expose
    Double vesselLength;

    @SerializedName("vesselWidth")
    @Expose
    Double vesselWidth;

    @SerializedName("vesselSubmersion")
    @Expose
    Double vesselSubmersion;

    @SerializedName("crewmenQuantity")
    @Expose
    Integer crewmenQuantity;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public Double getVesselLength() {
        return vesselLength;
    }

    public void setVesselLength(Double vesselLength) {
        this.vesselLength = vesselLength;
    }

    public Double getVesselWidth() {
        return vesselWidth;
    }

    public void setVesselWidth(Double vesselWidth) {
        this.vesselWidth = vesselWidth;
    }

    public Double getVesselSubmersion() {
        return vesselSubmersion;
    }

    public void setVesselSubmersion(Double vesselSubmersion) {
        this.vesselSubmersion = vesselSubmersion;
    }

    public Integer getCrewmenQuantity() {
        return crewmenQuantity;
    }

    public void setCrewmenQuantity(Integer crewmenQuantity) {
        this.crewmenQuantity = crewmenQuantity;
    }






}
