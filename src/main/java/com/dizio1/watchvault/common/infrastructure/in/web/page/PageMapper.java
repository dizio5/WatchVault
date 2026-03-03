package com.dizio1.watchvault.common.infrastructure.in.web.page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PageMapper {

    public PageQuery toModel(Pageable pageable) {
        return new PageQuery(pageable.getPageNumber(), pageable.getPageSize());
    }
}