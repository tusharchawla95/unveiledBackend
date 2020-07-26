package com.fashion.backendfinal.category.controller;

import com.fashion.backendfinal.baseResponse.BaseResponse;
import com.fashion.backendfinal.category.service.CategoryService;
import com.fashion.backendfinal.entities.jeans.Jeans;
import com.fashion.backendfinal.entities.shirts.Shirts;

import com.fashion.backendfinal.jeans.service.JeansService;
import com.fashion.backendfinal.shirts.service.ShirtService;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping("/category")
    public @ResponseBody  BaseResponse getAllCategory(){

        return new BaseResponse(HttpStatus.OK.value(),"SUCCESS",categoryService.getAllCategory());
    }


    @RequestMapping("/test")
    public @ResponseBody  BaseResponse getSMS(){

        HttpResponse<String> response = Unirest.post("https://nexmo-nexmo-number-insight-v1.p.rapidapi.com/basic/json?number=8556064202")
                .header("x-rapidapi-host", "nexmo-nexmo-number-insight-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "0864914ae8msh4c405414d03bdf8p13bc15jsna7271d0c1234")
                .header("content-type", "application/x-www-form-urlencoded")
                .asString();

        System.out.println(response.getBody());
        return new BaseResponse(HttpStatus.OK.value(),"SUCCESS",response.getBody());
    }

}
