package com.fashion.backendfinal.shirts.dao.impl;

import com.fashion.backendfinal.entities.jeans.Jeans;
import com.fashion.backendfinal.entities.shirts.Shirts;
import com.fashion.backendfinal.repositories.shirts.ShirtsRepository;
import com.fashion.backendfinal.shirts.dao.ShirtsDAO;
import com.fashion.backendfinal.shirts.pojo.ShirtsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShirtsDAOImpl implements ShirtsDAO {

    @Autowired
    ShirtsRepository shirtsRepository;

    @Autowired
    EntityManager em;


    @Override
    public void addShirts(List<Shirts> shirts) {

        shirtsRepository.saveAll(shirts);
    }

    @Override
    public List<Shirts> getAllShirts() {
       return shirtsRepository.findAll();
    }

    @Override
    public Shirts getShirtById(Integer id) {
        return shirtsRepository.getShirtById(id);
    }

    @Override
    public List<Shirts> getFilter(ShirtsFilter filter) {
        List<Predicate> filterPredicates = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Shirts> cq = cb.createQuery(Shirts.class);

        Root<Shirts> shirts = cq.from(Shirts.class);

           // filterPredicates.add(cb.equal(shirts.get("size"), filter.getSize()));
        if (filter.getSize() != null) {
           // filterPredicates.add(cb.equal(shirts.get("size"), filter.getSize()));
             filterPredicates.add(cb.like(shirts.get("size"),"%"+filter.getSize()+"%"));
        }
        if (filter.getColour() != null)
            filterPredicates.add(cb.equal(shirts.get("colour"), filter.getColour()));
        if (filter.getBrand() != null)
            filterPredicates.add(cb.equal(shirts.get("brand"), filter.getBrand()));
        if (filter.getGender() != null)
            filterPredicates.add(cb.equal(shirts.get("gender"), filter.getGender()));


        cq.select(shirts).where(cb.and(filterPredicates.toArray(new Predicate[0])));

        TypedQuery<Shirts> query = em.createQuery(cq);
        return query.getResultList();
    }
}
