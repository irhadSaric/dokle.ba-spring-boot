package com.dokle.ba.demo.service.dtos;

import java.sql.Timestamp;

public class PathResponse {
    private Long pathId;
    private Timestamp departureDate;
    private String destination;
    private String startingPoint;
    private Timestamp departureTime;
    private Short countryId;
    private Short paymentId;
    private String countryName;
    private String paymentName;
    private String userFirstName;
    private Long userId;
    private String senderLogo;

    public PathResponse() {
    }

    public PathResponse(Long pathId, Timestamp departureDate, String destination, String startingPoint, Timestamp departureTime, Short countryId, Short paymentId, String countryName, String paymentName, String userFirstName, Long userId, String senderLogo) {
        this.pathId = pathId;
        this.departureDate = departureDate;
        this.destination = destination;
        this.startingPoint = startingPoint;
        this.departureTime = departureTime;
        this.countryId = countryId;
        this.paymentId = paymentId;
        this.countryName = countryName;
        this.paymentName = paymentName;
        this.userFirstName = userFirstName;
        this.userId = userId;
        this.senderLogo = senderLogo;
    }

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public Short getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Short paymentId) {
        this.paymentId = paymentId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSenderLogo() {
        return senderLogo;
    }

    public void setSenderLogo(String senderLogo) {
        this.senderLogo = senderLogo;
    }
}
