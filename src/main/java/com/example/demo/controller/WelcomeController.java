package com.example.demo.controller;

import com.example.demo.entity.AuthRequest;
import com.example.demo.util.JwtUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String welcome() {
        return "welcome from controller";
    }

    @PostMapping("/authenticate")  // отправляем name and password и получаем ТОкен. токен всталяем в Authorization в посман и отправялем get public String welcome()
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
//                    = new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword());
//            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }


}
