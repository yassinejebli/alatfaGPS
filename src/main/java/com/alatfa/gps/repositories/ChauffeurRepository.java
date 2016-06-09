package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Chauffeur;
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
@RepositoryRestResource(collectionResourceRel = "Chauffeurs", path = "Chauffeurs")
public interface ChauffeurRepository extends MongoRepository<Chauffeur, String> {
    public Page<Chauffeur> findAllByNameContains(@Param("name") String name, Pageable pageable);

}