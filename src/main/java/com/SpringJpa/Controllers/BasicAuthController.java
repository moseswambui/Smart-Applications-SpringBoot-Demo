package com.SpringJpa.Controllers;

import com.SpringJpa.Entities.BasicAuthUser;
import com.SpringJpa.Entities.Users;
import com.SpringJpa.Repositories.BasicAuthUserRepository;
import com.SpringJpa.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user/auth")
public class BasicAuthController {

    public static final String SECRET_KEY = "TheSecretKey2468";

    @Autowired
    UserService userService;

    @GetMapping(value = "/time", produces = MediaType.TEXT_PLAIN_VALUE)
    public  String time(){
        return "Now is" + LocalTime.now();
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String , String>> loginUser(@RequestBody Map<String, Object> userMap){
        String email =(String) userMap.get("email");
        String password =(String) userMap.get("password");

        Users users = userService.validateUser(email, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "logged in successfully");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        Users users = userService.registerUser(firstName, lastName, email, password);
        Map<String, String> map = new HashMap<>();

        map.put("message", "Registered Successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
