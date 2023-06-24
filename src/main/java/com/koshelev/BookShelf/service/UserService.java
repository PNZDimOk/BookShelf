package com.koshelev.BookShelf.service;

import com.koshelev.BookShelf.models.User;
import com.koshelev.BookShelf.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {
//    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserName(String userName){
        return userRepository.findByUsername(userName);
    }
    public User findUser(long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

//    public User register(User user){
//        Role roleUser = roleRepository.findByName("ROLE_USER");
//        List<Role> userRoles = new ArrayList<>();
//        userRoles.add(roleUser);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(userRoles);
//
//        User registeredUser = userRepository.save(user);
//        return registeredUser;
//    }
}
