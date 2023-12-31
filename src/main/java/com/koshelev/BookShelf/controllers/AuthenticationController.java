//package com.koshelev.BookShelf.controllers;
//
//import com.koshelev.BookShelf.models.User;
//import com.koshelev.BookShelf.security.jwt.JwtTokenProvider;
//import com.koshelev.BookShelf.service.UserService;
//import com.koshelev.BookShelf.service.dto.AuthenticationRequestDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Lazy
//@RestController
//@RequestMapping(value = "auth/")
//public class AuthenticationController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    private final UserService userService;
//
//    @Autowired
//    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userService = userService;
//    }
//
//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
//        try {
//            String username = requestDto.getUsername();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
//            User user = userService.findByUserName(username);
//
//            if (user == null) {
//                throw new UsernameNotFoundException("User with username: " + username + " not found");
//            }
//
//            String token = jwtTokenProvider.createToken(username, user.getRoles());
//
//            Map<Object, Object> response = new HashMap<>();
//            response.put("username", username);
//            response.put("token", token);
//
//            return ResponseEntity.ok(response);
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//}
