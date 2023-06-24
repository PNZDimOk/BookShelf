package com.koshelev.BookShelf.controllers;

import com.koshelev.BookShelf.models.Book;
import com.koshelev.BookShelf.models.BookShelf;
import com.koshelev.BookShelf.models.User;
import com.koshelev.BookShelf.service.BookService;
import com.koshelev.BookShelf.service.BookShelfService;
import com.koshelev.BookShelf.service.UserService;
import com.koshelev.BookShelf.service.dto.BookDTO;
import com.koshelev.BookShelf.service.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{user_id}/bookshelves/{bookshelf_id}/books")
public class BookController {
    private final UserService userService;
    private final BookService bookService;
    private final BookShelfService bookShelfService;
    private final BookRepository bookRepository;

    public BookController(UserService userService, BookService bookService, BookShelfService bookShelfService,
                          BookRepository bookRepository) {
        this.userService = userService;
        this.bookService = bookService;
        this.bookShelfService = bookShelfService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks(@PathVariable("bookshelf_id") long bookshelf_id){
        return bookService.findBooksOnShelf(bookshelf_id);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id")long id){
        return bookService.findBook(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createBook(@RequestBody BookDTO bookDTO,
                                                 @PathVariable("user_id")long user_id,
                                                 @PathVariable("bookshelf_id")long bookshelf_id){
        BookShelf bookShelf = bookShelfService.findBookShelf(bookshelf_id);
        User user = userService.findUser(user_id);
        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setUser(user);
        book.setBookShelf(bookShelf);
        bookService.saveBook(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateBook(@RequestBody Book book){
        bookService.saveBook(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
