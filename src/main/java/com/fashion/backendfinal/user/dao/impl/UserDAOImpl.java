package com.fashion.backendfinal.user.dao.impl;

import com.fashion.backendfinal.user.dao.UserDAO;
import com.fashion.backendfinal.entities.user.User;

import com.fashion.backendfinal.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addData(String name, String email, String pass, String mobile) {

     userRepository.save(User.builder().name(name).email(email).pass(pass).mobile(mobile).build());

    }
}
