package com.SpringJpa.Repositories;

import com.SpringJpa.Entities.Users;
import com.SpringJpa.Exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;

    Users findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    Users findById(Integer userId);
}
