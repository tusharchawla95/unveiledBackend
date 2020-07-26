package com.fashion.backendfinal.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class DataEntryRequest {
    @NotNull(message = "key cannot be null")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "value cannot be null")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "value cannot be null")
    @JsonProperty("pass")
    private String pass;

    @NotNull(message = "value cannot be null")
    @JsonProperty("mobile")
    private String mobile;
}
