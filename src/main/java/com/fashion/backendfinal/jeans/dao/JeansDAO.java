package com.fashion.backendfinal.jeans.dao;

import com.fashion.backendfinal.entities.jeans.Jeans;
import com.fashion.backendfinal.jeans.pojo.JeansFilter;

import java.util.List;

public interface JeansDAO {
    void addJeans(List<Jeans> jeans);

    List<Jeans> getAllJeans();

    Jeans getJeansById(Integer id);

    List<Jeans> getFilter(JeansFilter filter);

}
