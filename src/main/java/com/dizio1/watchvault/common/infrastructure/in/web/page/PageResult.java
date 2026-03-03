package com.dizio1.watchvault.common.infrastructure.in.web.page;

import java.util.List;

public record PageResult<T>(
        List<T> content,
        Long totalElements,
        Integer totalPages,
        Integer number,
        Integer size
) {
}
