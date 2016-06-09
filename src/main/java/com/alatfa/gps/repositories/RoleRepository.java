package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RepositoryRestResource(collectionResourceRel = "Roles", path = "Roles")
public interface RoleRepository extends MongoRepository<Role, String> {
    public Page<Role> findAllByNameContains(@Param("name") String name, Pageable pageable);

}