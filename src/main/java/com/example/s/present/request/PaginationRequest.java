package com.example.s.present.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaginationRequest {
    @Min(0)
    Integer page;
    @Getter
    @Min(0)
    Integer size;


    public PaginationRequest() {
//        page = 1;
//        size = 10;
    }

}
