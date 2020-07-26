package com.fashion.backendfinal.user.controller;

import com.fashion.backendfinal.baseResponse.BaseResponse;
import com.fashion.backendfinal.user.pojo.DataEntryRequest;
import com.fashion.backendfinal.entities.user.User;
import com.fashion.backendfinal.user.pojo.UserAuth;
import com.fashion.backendfinal.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    UserService userService;

    private String sessionIdentifier = null;

    @RequestMapping("/getAllUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping(
            value = "/addUser",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody
    BaseResponse addUser(@Valid @RequestBody DataEntryRequest dataEntryRequest) {
        log.info("Create config Request for : " + dataEntryRequest);
        userService.addUser(dataEntryRequest.getName(), dataEntryRequest.getEmail(), dataEntryRequest.getPass(), dataEntryRequest.getMobile());
        return new BaseResponse(HttpStatus.OK.value(), "Success");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkAuth")
    public User checkAuth(@RequestBody UserAuth userAuth, HttpServletRequest request) {
        sessionIdentifier = userAuth.getEmail();
        User currentUser = userService.getUserByEmail(userAuth.getEmail());
        request.getSession().setAttribute(sessionIdentifier, currentUser);
        return currentUser;
    }

    @RequestMapping("/userLoginInfo")
    @SuppressWarnings("unchecked")
    public User userLoginInfo(HttpSession session) {
        return (User) session.getAttribute(sessionIdentifier);
    }


}
