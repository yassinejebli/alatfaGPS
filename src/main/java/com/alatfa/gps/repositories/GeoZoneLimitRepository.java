package com.alatfa.gps.repositories;

import com.alatfa.gps.model.GeoZoneLimit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "GeoZoneLimits", path = "GeoZoneLimits")
public interface GeoZoneLimitRepository extends MongoRepository<GeoZoneLimit, String> {
    public GeoZoneLimit findByVehicule_Id(@Param("idVehicule") String idVehicule);
}