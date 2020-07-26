package com.fashion.backendfinal.category.service;

import com.fashion.backendfinal.entities.jeans.Jeans;
import com.fashion.backendfinal.entities.jeans.JeansSize;
import com.fashion.backendfinal.entities.shirts.Shirts;
import com.fashion.backendfinal.entities.shoes.Shoes;
import com.fashion.backendfinal.jeans.dao.JeansDAO;

import com.fashion.backendfinal.jeans.pojo.JeansFilter;
import com.fashion.backendfinal.jeans.service.JeansService;
import com.fashion.backendfinal.shirts.dao.ShirtsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CategoryService {
    @Autowired
    JeansDAO jeansDAO;

    @Autowired
    ShirtsDAO shirtsDAO;

    public static ArrayList<Jeans> jeansItems = new ArrayList<Jeans>();

    public static ArrayList<Shirts> shirtItems = new ArrayList<Shirts>();

    public static ArrayList<Shoes> shoesItems = new ArrayList<Shoes>();

    @Cacheable("category")
    public Map<String, Object> getAllCategory() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("Jeans", jeansDAO.getAllJeans());
        map.put("Shirts", shirtsDAO.getAllShirts());

        return map;
    }


}
