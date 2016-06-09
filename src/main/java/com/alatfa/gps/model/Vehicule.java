package com.alatfa.gps.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */

@Document
public class Vehicule {

    @Id
    private String id;

    //@Indexed(unique = true)
    private String matricule;
    private String intitule;
    private String image;
    private String modele;
    private String marque;
    private double kilometrage;
    private double limitVitesse;
    private boolean active;
    private int puissance;
    private EquipementGps equipementGps;
    private Chauffeur chauffeur;

    public double getLimitVitesse() {
        return limitVitesse;
    }

    public void setLimitVitesse(double limitVitesse) {
        this.limitVitesse = limitVitesse;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }



    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public EquipementGps getEquipementGps() {
        return equipementGps;
    }

    public void setEquipementGps(EquipementGps equipementGps) {
        this.equipementGps = equipementGps;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Vehicule() {

    }

    public Vehicule(String id, String matricule, String intitule, String image, String modele, boolean active, int puissance) {

        this.id = id;
        this.matricule = matricule;
        this.intitule = intitule;
        this.image = image;
        this.modele = modele;
        this.active = active;
        this.puissance = puissance;
    }
}
