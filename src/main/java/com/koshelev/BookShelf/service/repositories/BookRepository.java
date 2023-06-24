package com.koshelev.BookShelf.service.repositories;

import com.koshelev.BookShelf.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        List<Book> findBooksByBookShelfId(long bookShelf_id);
}
