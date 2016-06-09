package com.alatfa.gps.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */

@Document
public class EquipementGps {

    @Id
    private String id;

    private String name;
    private String imei;
    private String marque;
    private String numCarteSim;
    private double distanceEnvoi;
    private double secondsEnvoi;

    public double getDistanceEnvoi() {
        return distanceEnvoi;
    }

    public void setDistanceEnvoi(double distanceEnvoi) {
        this.distanceEnvoi = distanceEnvoi;
    }

    public double getSecondsEnvoi() {
        return secondsEnvoi;
    }

    public void setSecondsEnvoi(double secondsEnvoi) {
        this.secondsEnvoi = secondsEnvoi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumCarteSim() {
        return numCarteSim;
    }

    public void setNumCarteSim(String numCarteSim) {
        this.numCarteSim = numCarteSim;
    }

    public EquipementGps() {

    }

    public EquipementGps(String id, String name, String numCarteSim) {
        this.id = id;
        this.name = name;
        this.numCarteSim = numCarteSim;
    }
}
