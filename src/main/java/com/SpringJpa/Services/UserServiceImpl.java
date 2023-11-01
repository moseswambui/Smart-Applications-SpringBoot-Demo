package com.SpringJpa.Services;


import com.SpringJpa.Entities.Users;
import com.SpringJpa.Exceptions.EtAuthException;
import com.SpringJpa.Repositories.UserRepository;
import org.hibernate.type.descriptor.converter.internal.EnumHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public Users validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Users registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid Email Format");
        Integer count = userRepository.getCountByEmail(email);

        if (count > 0)
            throw new EtAuthException("Email Already In Use");

        Integer userId = userRepository.create(firstName, lastName, email, password);

        return userRepository.findById(userId);
    }
}
