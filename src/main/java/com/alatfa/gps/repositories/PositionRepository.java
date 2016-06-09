package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Position;
import com.alatfa.gps.model.Position;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "Positions", path = "Positions")
public interface PositionRepository extends MongoRepository<Position, String> {
    List<Position> findByVehicule_IdAndDateBetween(@Param("idVehicule") String idVehicule, @Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    public Position findTopByOrderByDateDesc();
    public Position findTopByVehicule_IdOrderByDateDesc(@Param("idVehicule") String idVehicule);

}