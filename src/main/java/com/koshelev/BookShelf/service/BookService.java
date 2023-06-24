package com.koshelev.BookShelf.service;

import com.koshelev.BookShelf.models.Book;
import com.koshelev.BookShelf.models.BookShelf;
import com.koshelev.BookShelf.service.repositories.BookRepository;
import com.koshelev.BookShelf.service.repositories.BookShelfRepository;
import com.koshelev.BookShelf.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookShelfRepository bookShelfRepository;

    @Autowired
    public BookService(UserRepository userRepository, BookRepository bookRepository, BookShelfRepository bookShelfRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookShelfRepository = bookShelfRepository;
    }

    public List<Book> findBooks(){
        return bookRepository.findAll();
    }

    public Book findBook(long id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findBooksOnShelf(long id){
        return bookRepository.findBooksByBookShelfId(id);
    }

    @Transactional
    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }

}
