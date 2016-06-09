package com.alatfa.gps.repositories;

import com.alatfa.gps.model.GeoZoneAlert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "GeoZoneAlerts", path = "GeoZoneAlerts")
public interface GeoZoneAlertRepository extends MongoRepository<GeoZoneAlert, String> {
    public List<GeoZoneAlert> findByVehicule_Id(@Param("idVehicule") String idVehicule);
}