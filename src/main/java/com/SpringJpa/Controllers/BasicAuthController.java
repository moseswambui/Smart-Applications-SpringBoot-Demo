package com.SpringJpa.Controllers;

import com.SpringJpa.Entities.BasicAuthUser;
import com.SpringJpa.Repositories.BasicAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@RequestMapping("/user/auth")
public class BasicAuthController {

    public static final String SECRET_KEY = "TheSecretKey2468";

    @Autowired
    private BasicAuthUserRepository repository;

    @GetMapping(value = "/time", produces = MediaType.TEXT_PLAIN_VALUE)
    public  String time(){
        return "Now is" + LocalTime.now();
    }

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody(required = true)BasicAuthUser userRequest)
            throws Exception{
        var user = new BasicAuthUser();
        //var encryptedUsername = EncryDecryptUtil.encryptAes(userRequest.getUsername(), SECRET_KEY);

    }
}
