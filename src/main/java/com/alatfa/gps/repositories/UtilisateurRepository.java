package com.alatfa.gps.repositories;

import com.alatfa.gps.model.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "Utilisateurs", path = "Utilisateurs")
public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
    public Page<Utilisateur> findAllByNameContains(@Param("name") String name, Pageable pageable);

    public Utilisateur findByLogin(@Param("login") String login);
    public Utilisateur findByLoginAndPassword(@Param("login") String login,@Param("password") String password);

    public String findRole_NameByLogin(String login);
}