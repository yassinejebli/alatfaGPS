package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Mission;
import com.alatfa.gps.statistics.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "Missions", path = "Missions")
public interface MissionRepository extends MongoRepository<Mission, String> {

    public List<Mission> findByDateDepart(@Param("dateDepart") Date dateDepart);

    public List<Mission> findByAccomplie(@Param("accomplie") boolean accomplie);
}