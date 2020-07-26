package com.fashion.backendfinal.jeans.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JeansFilter extends Object{
    String size_S;
    String size_M;
    String size_L;
    String size_XL;
    String size_XXL;
    String colour;
    String brand;
    String gender;
    double price;
}
