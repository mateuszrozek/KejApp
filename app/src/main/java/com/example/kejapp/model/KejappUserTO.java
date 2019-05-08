package com.example.kejapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KejappUserTO {

    @SerializedName("username")
    @Expose
    String username;

    @SerializedName("password")
    @Expose
    String password;

    @SerializedName("phoneNumber")
    @Expose
    String phoneNumber;

    @SerializedName("firstName")
    @Expose
    String firstName;

    @SerializedName("lastName")
    @Expose
    String lastName;

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

    @SerializedName("role")
    @Expose
    String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
