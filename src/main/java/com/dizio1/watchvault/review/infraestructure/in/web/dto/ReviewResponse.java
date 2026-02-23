package com.dizio1.watchvault.review.infraestructure.in.web.dto;

import com.dizio1.watchvault.review.domain.ShowType;

import java.time.LocalDate;

public record ReviewResponse(
        ShowType showType,
        String title,
        String description,
        Integer stars,
        LocalDate reviewedAt
) {
}
