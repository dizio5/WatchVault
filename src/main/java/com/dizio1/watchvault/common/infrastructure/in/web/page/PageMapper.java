package com.dizio1.watchvault.common.infrastructure.in.web.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {

    public Pageable toPageable(PaginationRequest request) {
        return PageRequest.of(request.page(), request.size());
    }

    public PaginationRequest toModel(Pageable pageable) {
        return new PaginationRequest(pageable.getPageNumber(), pageable.getPageSize());
    }
}