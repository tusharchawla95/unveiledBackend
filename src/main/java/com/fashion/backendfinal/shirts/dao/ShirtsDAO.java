package com.fashion.backendfinal.shirts.dao;

import com.fashion.backendfinal.entities.shirts.Shirts;
import com.fashion.backendfinal.shirts.pojo.ShirtsFilter;

import java.util.List;

public interface ShirtsDAO
{

    void addShirts(List<Shirts> shirt);
    List<Shirts> getAllShirts();
    Shirts getShirtById(Integer id);
    List<Shirts> getFilter(ShirtsFilter filter);


}
