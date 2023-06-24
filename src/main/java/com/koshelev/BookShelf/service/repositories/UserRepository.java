package com.koshelev.BookShelf.service.repositories;

import com.koshelev.BookShelf.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);

}