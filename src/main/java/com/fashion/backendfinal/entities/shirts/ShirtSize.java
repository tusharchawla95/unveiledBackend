package com.fashion.backendfinal.entities.shirts;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "shirt_size")
public class ShirtSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "shirt_id")
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
