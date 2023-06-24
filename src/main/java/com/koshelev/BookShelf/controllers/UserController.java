package com.koshelev.BookShelf.controllers;

import com.koshelev.BookShelf.models.BookShelf;
import com.koshelev.BookShelf.models.User;
import com.koshelev.BookShelf.service.BookService;
import com.koshelev.BookShelf.service.BookShelfService;
import com.koshelev.BookShelf.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final BookService bookService;
    private final BookShelfService bookShelfService;

    public UserController(UserService userService, BookService bookService, BookShelfService bookShelfService) {
        this.userService = userService;
        this.bookService = bookService;
        this.bookShelfService = bookShelfService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return userService.findUser(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
