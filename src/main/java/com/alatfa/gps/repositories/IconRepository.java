package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Icon;
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
@RepositoryRestResource(collectionResourceRel = "Icons", path = "Icons")
public interface IconRepository extends MongoRepository<Icon, String> {
    public Page<Icon> findAllByNameContains(@Param("name") String name, Pageable pageable);

}