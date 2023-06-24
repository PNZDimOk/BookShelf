package com.koshelev.BookShelf.controllers;

import com.koshelev.BookShelf.models.Book;
import com.koshelev.BookShelf.models.BookShelf;
import com.koshelev.BookShelf.models.User;
import com.koshelev.BookShelf.service.BookService;
import com.koshelev.BookShelf.service.BookShelfService;
import com.koshelev.BookShelf.service.UserService;
import com.koshelev.BookShelf.service.dto.BookShelfDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{user_id}/bookshelves")
public class BookShelfController {
    private final UserService userService;
    private final BookService bookService;
    private final BookShelfService bookShelfService;

    public BookShelfController(UserService userService, BookService bookService, BookShelfService bookShelfService) {
        this.userService = userService;
        this.bookService = bookService;
        this.bookShelfService = bookShelfService;
    }

    @GetMapping
    public List<BookShelf> getBookShelves(@PathVariable("user_id") long user_id) {
        return bookShelfService.findBookShelvesForUser(user_id);
    }

    @GetMapping("/{id}")
    public BookShelf getBookShelf(@PathVariable("id")long id){
        return bookShelfService.findBookShelf(id);
    }


    @PostMapping
    public ResponseEntity<HttpStatus> createBookShelf(@RequestBody BookShelfDTO bookShelfDTO,
                                                      @PathVariable("user_id")long user_id){
        BookShelf bookShelf = new BookShelf();
        User user = userService.findUser(user_id);
        bookShelf.setName(bookShelfDTO.getName());
        bookShelf.setUser(user);
        bookShelfService.saveBookShelf(bookShelf);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateBookShelf(@RequestBody BookShelf bookShelf){
        bookShelfService.saveBookShelf(bookShelf);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBookShelf(@PathVariable("id") long id){
        bookShelfService.deleteBookShelf(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
