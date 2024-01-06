//package com.example.projectshopping.service;
//
//
//
//import com.example.projectshopping.model.entities.user.User;
//import com.example.projectshopping.model.form.LoginForm;
//import com.example.projectshopping.model.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org .springframework.security.authentication.AuthenticationManager;
//import org .springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org .springframework.stereotype.Service;
//
//@Service
//public class LoginService {
//
//
//    private UserRepository userRepository;
//
//
//    private AuthenticationManager authenticationManager;
//
//
//    private PasswordEncoder passwordEncoder;
//
//    public LoginService(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.authenticationManager = authenticationManager;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public boolean login(LoginForm form) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return authentication != null;
//    }
//}