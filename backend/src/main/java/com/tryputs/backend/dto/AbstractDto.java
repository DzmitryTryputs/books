package com.tryputs.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
}
