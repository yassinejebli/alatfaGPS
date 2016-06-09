package com.alatfa.gps.model;

/**
 * Created by UNKNOWN on 29/05/2016.
 */
//helper
public class Coordonnee {

    private double lat;
    private double lng;

    public Coordonnee(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
