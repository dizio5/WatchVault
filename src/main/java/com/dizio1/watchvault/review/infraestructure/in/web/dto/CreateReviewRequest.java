package com.dizio1.watchvault.review.infraestructure.in.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateReviewRequest(
        @NotBlank String showType,
        @NotBlank String title,
        String description,
        @NotNull @Min(1) @Max(10) Integer rating
) {
}
