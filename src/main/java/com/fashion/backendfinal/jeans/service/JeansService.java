package com.fashion.backendfinal.jeans.service;

import com.fashion.backendfinal.category.service.CategoryService;
import com.fashion.backendfinal.entities.jeans.Jeans;

import com.fashion.backendfinal.entities.jeans.JeansSize;
import com.fashion.backendfinal.jeans.dao.JeansDAO;

import com.fashion.backendfinal.jeans.pojo.JeansFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JeansService extends CategoryService implements Cloneable {

    @Autowired
    JeansDAO jeansDAO;

    @Cacheable("jeans")
    public List<Jeans> getAllJeans() {
        return jeansDAO.getAllJeans();
    }

    public void addJeans(List<Jeans> jeans) {

        jeansDAO.addJeans(jeans);
    }

    @Cacheable("jeansId")
    public Jeans getJeansById(Integer jeansId) {
        return jeansDAO.getJeansById(jeansId);
        //return jeansItems.stream().filter(t->t.getId().equals(jeansId)).findFirst().get();

    }

    //return jeansItems.stream().filter(t->t.getSize().equalsIgnoreCase(jeansSize)).collect(Collectors.toList());


    public List<Jeans> getFilteredJeans(JeansFilter filter) {

        return jeansDAO.getFilter(filter);

    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Jeans> list = jeansItems;
        return list;

    }
}
