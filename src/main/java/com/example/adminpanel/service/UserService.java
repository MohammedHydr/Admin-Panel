package com.example.adminpanel.service;

import com.example.adminpanel.entity.User;
import com.example.adminpanel.exceptions.NoSuchElementFoundException;
import com.example.adminpanel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    public UserService(EntityManager entityManager, UserRepository userRepository) {
        this.entityManager = entityManager;
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() throws NoSuchElementFoundException {
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

//    public User getUser(User user) {
//        TypedQuery<User> typedQuery = entityManager.createQuery(
//                "Select u FROM User u  WHERE u.password = :password AND u.email = :email", User.class);
//        try {
//            User newUser = typedQuery.setParameter("password", user.getPassword()).setParameter("email", user.getEmail()).getSingleResult();
//            return newUser;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    public User getUser(User user){
        return userRepository.findByEmail(user.getEmail());
    }

}
