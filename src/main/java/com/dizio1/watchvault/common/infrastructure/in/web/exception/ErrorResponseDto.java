package com.dizio1.watchvault.common.infrastructure.in.web.exception;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        LocalDateTime timestamp,
        Integer status,
        String type,
        String msg
) {
}
