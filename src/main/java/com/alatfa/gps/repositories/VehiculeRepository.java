package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Vehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "Vehicules", path = "Vehicules")
public interface VehiculeRepository extends MongoRepository<Vehicule, String> {
    public Page<Vehicule> findAllByIntituleContains(@Param("intitule") String intitule, Pageable pageable);

    public Vehicule findByEquipementGps_imei(@Param("imei") String imei);
}