package com.alatfa.gps.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 *
 */

@Document
public class Position {

    @Id
    private String id;
    private double latitude;
    private double longitude;
    private double vitesse;
    private Date date;
    private Vehicule vehicule;
    private double NiveauCarburant;




    public Position() {
    }

    public double getNiveauCarburant() {
        return NiveauCarburant;
    }

    public void setNiveauCarburant(double niveauCarburant) {
        NiveauCarburant = niveauCarburant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }


    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", vitesse=" + vitesse +
                ", date=" + date +
                ", vehicule=" + vehicule +
                ", NiveauCarburant=" + NiveauCarburant +
                '}';
    }
}
