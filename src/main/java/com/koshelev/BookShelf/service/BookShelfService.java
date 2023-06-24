package com.koshelev.BookShelf.service;

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
public class BookShelfService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookShelfRepository bookShelfRepository;

    @Autowired
    public BookShelfService(UserRepository userRepository, BookRepository bookRepository, BookShelfRepository bookShelfRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookShelfRepository = bookShelfRepository;
    }

    public List<BookShelf> showBookShelves(){
        return bookShelfRepository.findAll();
    }
    public BookShelf findBookShelf(long id){
        return bookShelfRepository.findById(id).orElse(null);
    }

    public List<BookShelf> findBookShelvesForUser(long user_id){
        return bookShelfRepository.findByUserId(user_id);
    }

    @Transactional
    public void saveBookShelf(BookShelf bookShelf){
        bookShelfRepository.save(bookShelf);
    }

    @Transactional
    public void deleteBookShelf(long id){
        bookShelfRepository.deleteById(id);
    }


}
