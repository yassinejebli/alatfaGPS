package com.alatfa.gps.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 *
 */

@Document
public class Mission {

    @Id
    private String id;
    private String name;
    private PointInteret pointInteretDepart;
    private PointInteret pointInteretFin;
    private Date dateDepart;

    private double kilometrageEstime;//distance entre un point d'interet est un autre ex : Sté AL ATFA et Station service total massira
    private String numBons;//ou num des factures séparé par virgule , mais aprés l'hébergement de l'application de gestion commerciale que j'ai crée je vais utiliser restTemplate pour recuperer les factures et les BLs depuis la 2éme app
    private Date dateFin;//affecté automatiquement lorsque le véhicule arrive au point d'intéret => fin du mission
    private boolean accomplie;
    private Vehicule vehicule;
    private Date dateFinExacte;

    public Date getDateFinExacte() {
        return dateFinExacte;
    }

    public void setDateFinExacte(Date dateFinExacte) {
        this.dateFinExacte = dateFinExacte;
    }

    public Mission() {
    }


    public boolean isAccomplie() {
        return accomplie;
    }

    public void setAccomplie(boolean accomplie) {
        this.accomplie = accomplie;
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

    public PointInteret getPointInteretDepart() {
        return pointInteretDepart;
    }

    public void setPointInteretDepart(PointInteret pointInteretDepart) {
        this.pointInteretDepart = pointInteretDepart;
    }

    public PointInteret getPointInteretFin() {
        return pointInteretFin;
    }

    public void setPointInteretFin(PointInteret pointInteretFin) {
        this.pointInteretFin = pointInteretFin;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public double getKilometrageEstime() {
        return kilometrageEstime;
    }

    public void setKilometrageEstime(double kilometrageEstime) {
        this.kilometrageEstime = kilometrageEstime;
    }

    public String getNumBons() {
        return numBons;
    }

    public void setNumBons(String numBons) {
        this.numBons = numBons;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }


    @Override
    public String toString() {
        return "Mission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pointInteretDepart=" + pointInteretDepart +
                ", pointInteretFin=" + pointInteretFin +
                ", dateDepart=" + dateDepart +
                ", kilometrageEstime=" + kilometrageEstime +
                ", numBons='" + numBons + '\'' +
                ", dateFin=" + dateFin +
                ", accomplie=" + accomplie +
                ", vehicule=" + vehicule +
                '}';
    }
}
