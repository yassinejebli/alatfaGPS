package com.alatfa.gps.repositories;

import com.alatfa.gps.model.PointInteret;
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
@RepositoryRestResource(collectionResourceRel = "PointInterets", path = "PointInterets")
public interface PointInteretRepository extends MongoRepository<PointInteret, String> {
    public Page<PointInteret> findAllByNomContains(@Param("nom") String nom, Pageable pageable);

}