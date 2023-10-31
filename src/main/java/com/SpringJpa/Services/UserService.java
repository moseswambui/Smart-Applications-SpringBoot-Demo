package com.SpringJpa.Services;


import com.SpringJpa.Entities.Users;
import com.SpringJpa.Exceptions.EtAuthException;

public interface UserService {

    Users validateUser(String email, String password) throws EtAuthException;

    Users registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;
}
