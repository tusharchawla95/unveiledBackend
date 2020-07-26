package com.fashion.backendfinal.jeans.controller;

import com.fashion.backendfinal.baseResponse.BaseResponse;
import com.fashion.backendfinal.category.service.CategoryService;
import com.fashion.backendfinal.entities.jeans.JeansSize;
import com.fashion.backendfinal.jeans.pojo.JeansFilter;
import com.fashion.backendfinal.jeans.service.JeansService;
import com.fashion.backendfinal.entities.jeans.Jeans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/jeans")
public class JeansController {

    @Autowired
    JeansService jeansService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/addJeans", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    BaseResponse addJeans(@RequestBody Jeans[] jeans) {
        List<Jeans> jeansList = Arrays.asList(jeans);

     jeansService.addJeans(jeansList);

        return new BaseResponse(HttpStatus.OK.value(), "Success");
    }


    @RequestMapping(value = "/getJeans", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    BaseResponse getJeans() {
        return new BaseResponse(HttpStatus.OK.value(), "SUCCESS", jeansService.getAllJeans());
    }

    @RequestMapping(value = "/getJeans/Id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    BaseResponse getJeansById(@PathVariable Integer id) {

        return new BaseResponse(HttpStatus.OK.value(), "SUCCESS", jeansService.getJeansById(id));
    }


    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    BaseResponse getFilteredJeans(@RequestBody JeansFilter filter) {
        return new BaseResponse(HttpStatus.OK.value(), "SUCCESS", jeansService.getFilteredJeans(filter));
    }


}
