package com.fashion.backendfinal.repositories.shirts;

import com.fashion.backendfinal.entities.jeans.Jeans;
import com.fashion.backendfinal.entities.shirts.Shirts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShirtsRepository extends JpaRepository<Shirts,Integer> {

    @Query(value = "select * from shirts where id = :id"
            , nativeQuery = true)
    Shirts getShirtById(@Param("id") Integer id);




}
