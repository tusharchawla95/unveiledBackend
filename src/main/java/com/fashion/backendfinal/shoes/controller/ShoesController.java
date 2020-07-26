package com.fashion.backendfinal.shoes.controller;

import com.fashion.backendfinal.shoes.service.ShoesService;
import com.fashion.backendfinal.entities.shoes.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ShoesController {

    @Autowired
    ShoesService shoesService;


    @RequestMapping(method = RequestMethod.POST,value = "/addShoes")
    public void addShoes(@RequestBody Shoes[] shoes)
    {
        for(int i=0;i<shoes.length;i++)
            shoesService.addShoes(shoes[i]);
    }


    @RequestMapping("/getShoes")
    public List<Shoes> getAllShoes()
    {
        return shoesService.getAllShoes();
    }

    @RequestMapping("/getShoes/Id/{id}")
    public Shoes getShoesById(@PathVariable Integer id)
    {
        return shoesService.getShoesById(id);
    }

    @RequestMapping("/getShoes/Size/{size}")
    public List<Shoes> getShoesBySize(@PathVariable String size)
    {
        return shoesService.getShoesBySize(size);
    }

    @RequestMapping("/getShoes/Colour/{colour}")
    public List<Shoes> getShoesByColour(@PathVariable String colour)
    {
        return shoesService.getShoesByColour(colour);
    }

    @RequestMapping("/getShoes/Brand/{brand}")
    public List<Shoes> getShoesByBrand(@PathVariable String brand)
    {
        return shoesService.getShoesByBrand(brand);
    }

}
