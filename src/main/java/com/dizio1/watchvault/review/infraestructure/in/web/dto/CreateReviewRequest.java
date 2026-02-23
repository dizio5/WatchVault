package com.dizio1.watchvault.review.infraestructure.in.web.dto;

public record CreateReviewRequest(
        String showType,
        String show,
        String description,
        Integer stars
) {
}
