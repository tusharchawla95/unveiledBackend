package com.fashion.backendfinal.entities.jeans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;


@Entity
@Table(name = "jeans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jeans implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Integer id;
    @Column(name = "colour", nullable = false)
    String colour;
    @Column(name = "brand", nullable = false)
    String brand;
    @Column(name = "fit", nullable = false)
    String fit;
    @Column(name = "gender", nullable = false)
    String gender;
    @Column(name = "price", nullable = false)
    double price;
    @JsonProperty("image_url")
    @Column(name = "image_url", nullable = false)
    String image;
    @JsonProperty("name_tag")
    @Column(name = "name_tag", nullable = false)
    String nameTag;
    @JsonProperty("product_name")
    @Column(name = "product_name", nullable = false)
    String productName;
    @JsonProperty("product_desc")
    @Column(name = "product_desc", nullable = false)
    String productDesc;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "jeans_id")
    @JsonProperty("jeans_size")
    JeansSize jeansSize;


}
