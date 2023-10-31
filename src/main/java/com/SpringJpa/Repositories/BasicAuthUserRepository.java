package com.SpringJpa.Repositories;

import com.SpringJpa.Entities.BasicAuthUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasicAuthUserRepository extends CrudRepository<BasicAuthUser, Integer> {

    Optional<BasicAuthUser> findByUsername(String encryptedUsername);
}
