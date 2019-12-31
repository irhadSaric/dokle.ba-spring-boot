package com.dokle.ba.demo.service.dtos;

public class DetailsDTO {
    private byte[] avatar;
    private String city;
    private String phoneNumber;
    private Short country;

    public DetailsDTO() {
    }

    public DetailsDTO(byte[] avatar, String city, String phoneNumber, Short country) {
        this.avatar = avatar;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Short getCountry() {
        return country;
    }

    public void setCountry(Short country) {
        this.country = country;
    }
}
