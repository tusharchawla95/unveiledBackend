package com.fashion.backendfinal.user.service;
import com.fashion.backendfinal.category.service.CategoryService;
import com.fashion.backendfinal.user.dao.UserDAO;
import com.fashion.backendfinal.entities.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService extends CategoryService {

    @Autowired
    private UserDAO userDAO;

    ArrayList<User> list = new ArrayList<User>();


    public UserService()
    {
        list.add(new User(1,"Tushar","tushar@gmail.com","Tushar","8556064202") );
        list.add(new User(2,"Arpit","arpit@gmail.com","Arpit","7009748460") );

    }

    public List<User> getAllUsers()
    {
        return list;
    }
    public void addUser(String name, String email, String pass, String mobile)
    {

        userDAO.addData(name,email,pass,mobile);
       list.add(new User(1,name,email,pass,mobile));
    }

    public User getUserByEmail(String email)
    {
        return list.stream().filter(t->t.getEmail().equals(email)).findFirst().get();
    }
}
