package com.dizio1.watchvault.review.infraestructure.in.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ReviewResponse(
        String showType,
        String title,
        String description,
        Integer rating,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate reviewedAt
) {
}
