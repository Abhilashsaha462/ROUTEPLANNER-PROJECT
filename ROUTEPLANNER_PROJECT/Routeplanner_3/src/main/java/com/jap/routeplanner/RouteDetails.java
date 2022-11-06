package com.jap.routeplanner;

public class RouteDetails {
    private String fromCity;
    private String toCity;
    private int distance;
    private String time;
    private String Airfare;

    public RouteDetails(String fromCity, String toCity, int distance, String time, String airfare) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
        this.time = time;
        Airfare = airfare;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAirfare() {
        return Airfare;
    }

    public void setAirfare(String airfare) {
        Airfare = airfare;
    }

    @Override
    public String toString() {
        return "RouteDetails {" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                ", Airfare='" + Airfare + '\'' +
                '}';
    }
}
