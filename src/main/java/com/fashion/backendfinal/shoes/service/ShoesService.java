package com.fashion.backendfinal.shoes.service;

import com.fashion.backendfinal.category.service.CategoryService;
import com.fashion.backendfinal.entities.shoes.Shoes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoesService extends CategoryService {
    public void addShoes(Shoes shoes) {
        shoesItems.add(shoes);
    }



    public List<Shoes> getAllShoes() {
        return shoesItems;
    }

    public Shoes getShoesById(Integer shoesId) {
        return shoesItems.stream().filter(t -> t.getId().equals(shoesId)).findFirst().get();
    }

    public List<Shoes> getShoesBySize(String shoesSize) {
        return shoesItems.stream().filter(t -> t.getSize().equalsIgnoreCase(shoesSize)).collect(Collectors.toList());
    }

    public List<Shoes> getShoesByColour(String shoesColour) {
        return shoesItems.stream().filter(t -> t.getColour().equalsIgnoreCase(shoesColour)).collect(Collectors.toList());
    }

    public List<Shoes> getShoesByBrand(String shoesBrand)
    {
        return shoesItems.stream().filter(t->t.getBrand().equalsIgnoreCase(shoesBrand)).collect(Collectors.toList());
    }
}
