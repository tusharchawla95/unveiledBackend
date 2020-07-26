package com.fashion.backendfinal.shirts.service;


import com.fashion.backendfinal.category.service.CategoryService;
import com.fashion.backendfinal.entities.shirts.Shirts;
import com.fashion.backendfinal.shirts.dao.ShirtsDAO;
import com.fashion.backendfinal.shirts.pojo.ShirtsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShirtService extends CategoryService {


    @Autowired
    ShirtsDAO shirtsDAO;

    @Cacheable("shirts")
    public List<Shirts> getAllShirts() {
        return shirtsDAO.getAllShirts();
    }

    public void addShirt(List<Shirts> shirts) {

        shirtsDAO.addShirts(shirts);


    }

    @Cacheable("shirtId")
    public Shirts getShirtById(Integer shirtId) {
        return shirtsDAO.getShirtById(shirtId);
    }


    public List<Shirts> getFilter(ShirtsFilter filter)
    {
        return shirtsDAO.getFilter(filter);
    }

      //  return shirtItems.stream().filter(t -> t.getSize().equalsIgnoreCase(shirtSize)).collect(Collectors.toList());

}
