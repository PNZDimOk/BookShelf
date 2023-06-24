package com.koshelev.BookShelf.service.repositories;

import com.koshelev.BookShelf.models.BookShelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookShelfRepository extends JpaRepository<BookShelf, Long> {
    List<BookShelf> findByUserId(long user_id);
}
