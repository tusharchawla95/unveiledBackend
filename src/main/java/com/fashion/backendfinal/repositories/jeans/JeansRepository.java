package com.fashion.backendfinal.repositories.jeans;

import com.fashion.backendfinal.entities.jeans.Jeans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JeansRepository extends JpaRepository<Jeans, Integer> {

    @Query(value = "select * from jeans where id = :id"
            , nativeQuery = true)
    Jeans getJeansById(@Param("id") Integer id);


}
