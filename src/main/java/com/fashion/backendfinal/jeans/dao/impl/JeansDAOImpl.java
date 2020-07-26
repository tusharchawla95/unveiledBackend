package com.fashion.backendfinal.jeans.dao.impl;

import com.fashion.backendfinal.entities.jeans.Jeans;
import com.fashion.backendfinal.entities.jeans.JeansSize;
import com.fashion.backendfinal.jeans.dao.JeansDAO;
import com.fashion.backendfinal.jeans.pojo.JeansFilter;
import com.fashion.backendfinal.repositories.jeans.JeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JeansDAOImpl implements JeansDAO {
    @Autowired
    JeansRepository jeansRepository;

    @Autowired
    EntityManager em;

    @Override
    public void addJeans(List<Jeans> jeans) {
        jeansRepository.saveAll(jeans);

    }

    @Override
    public List<Jeans> getAllJeans() {
        return jeansRepository.findAll();


    }

    @Override
    public Jeans getJeansById(Integer id) {
        return jeansRepository.getJeansById(id);
    }


    @Override
    public List<Jeans> getFilter(JeansFilter filter) {

        List<Predicate> filterPredicates = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Jeans> cq = cb.createQuery(Jeans.class);

        Root<Jeans> jeans = cq.from(Jeans.class);
       


           filterPredicates.add(cb.equal(jeans.get("jeansSize.size_S"), "true"));


//        if(filter.getSize_L()=="true")
//            filterPredicates.add(cb.equal(jeans.get(new JeansSize().getSize_L()), filter.getSize_L()));
//        if(filter.getSize_XL()=="true")
//            filterPredicates.add(cb.equal(jeans.get(new JeansSize().getSize_XL()), filter.getSize_XL()));
//        if(filter.getSize_XXL()=="true")
//            filterPredicates.add(cb.equal(jeans.get(new JeansSize().getSize_XXL()), filter.getSize_XXL()));
//        if (filter.getColour() != null)
//            filterPredicates.add(cb.equal(jeans.get("colour"), filter.getColour()));
//        if (filter.getBrand() != null)
//            filterPredicates.add(cb.equal(jeans.get("brand"), filter.getBrand()));
//        if (filter.getGender() != null)
//            filterPredicates.add(cb.equal(jeans.get("gender"), filter.getGender()));


        cq.select(jeans).where(cb.and(filterPredicates.toArray(new Predicate[0])));

        TypedQuery<Jeans> query = em.createQuery(cq);
        return query.getResultList();
    }




}
