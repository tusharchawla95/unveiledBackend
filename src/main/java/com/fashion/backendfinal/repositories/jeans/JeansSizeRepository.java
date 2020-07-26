package com.fashion.backendfinal.repositories.jeans;

import com.fashion.backendfinal.entities.jeans.JeansSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeansSizeRepository extends JpaRepository<JeansSize,Integer> {

}
