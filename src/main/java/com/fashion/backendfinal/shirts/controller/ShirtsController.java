package com.fashion.backendfinal.shirts.controller;

import com.fashion.backendfinal.baseResponse.BaseResponse;
import com.fashion.backendfinal.shirts.pojo.ShirtsFilter;
import com.fashion.backendfinal.shirts.service.ShirtService;
import com.fashion.backendfinal.entities.shirts.Shirts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/shirts")
public class ShirtsController {

    @Autowired
    ShirtService shirtService;


    @RequestMapping(method = RequestMethod.POST,value = "/addShirts")
    public @ResponseBody BaseResponse addShirts(@RequestBody Shirts[] shirts)
    {
       List<Shirts> shirtsList = Arrays.asList(shirts);
       shirtService.addShirt(shirtsList);
       return new BaseResponse(HttpStatus.OK.value(),"SUCCESS");
    }

    @RequestMapping(value = "/getShirts")
    public @ResponseBody BaseResponse getAllShirts()
    {
        return new BaseResponse(HttpStatus.OK.value(),"SUCCESS",shirtService.getAllShirts());
    }

    @RequestMapping(value = "/getShirts/Id/{id}")
    public @ResponseBody BaseResponse getShirtsById(@PathVariable Integer id)
    {
        return new BaseResponse(HttpStatus.OK.value(),"SUCCESS",shirtService.getShirtById(id));
    }



    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public @ResponseBody BaseResponse getFilter( @RequestBody ShirtsFilter filter)
    {
        return new BaseResponse(HttpStatus.OK.value(),"SUCCESS",shirtService.getFilter(filter));
    }



}
