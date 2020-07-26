package com.fashion.backendfinal.entities.jeans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Table(name = "jeans_size")
public class JeansSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "jeans_id")
    Integer id;
    @Column(name = "small", nullable = false)
    String size_S;
    @Column(name = "medium", nullable = false)
    String size_M;
    @Column(name = "large", nullable = false)
    String size_L;
    @Column(name = "extra_large", nullable = false)
    String size_XL;
    @Column(name = "extra_extra_large", nullable = false)
    String size_XXL;

}
