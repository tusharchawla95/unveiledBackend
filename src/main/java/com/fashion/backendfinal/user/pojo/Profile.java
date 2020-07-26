package com.fashion.backendfinal.user.pojo;


import com.fashion.backendfinal.entities.user.User;

public class Profile {
    Integer id;
    Integer houseNumber;
    String streetName;
    Integer zipCode;
    String city;
    String state;
    String landmark = "";
    String gender;

    public Profile(User user, Integer houseNumber, String streetName, Integer zipCode, String city, String state, String landmark, String gender) {
        this.id = user.getId();
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.landmark = landmark;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }


}
