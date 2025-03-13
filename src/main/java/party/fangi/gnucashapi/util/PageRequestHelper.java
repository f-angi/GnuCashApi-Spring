package party.fangi.gnucashapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import party.fangi.gnucashapi.model.Sort;

@Component
public class PageRequestHelper {

    @Value("${application.pagination.page.size}")
    private int defaultPageSize;

    @Value("${application.pagination.sort.field}")
    private String defaultSortField;

    @Value("${application.pagination.sort.direction}")
    private String defaultSortDirection;

    public PageRequest mapSearchToPageRequest(Sort sort) {
        int pageSize = sort.getPageSize() == null ? defaultPageSize : sort.getPageSize();
        int pageNumber = sort.getPageNumber() == null ? 0 : sort.getPageNumber();
        String sortField = sort.getSortField() == null ? defaultSortField : sort.getSortField();

        org.springframework.data.domain.Sort.Direction sortDirection;
        try {
            sortDirection = org.springframework.data.domain.Sort.Direction.valueOf(sort.getSortDirection().toUpperCase());
        } catch (Exception e) {
            sortDirection = org.springframework.data.domain.Sort.Direction.valueOf(defaultSortDirection.toUpperCase());
        }

        return PageRequest.of(pageNumber, pageSize, sortDirection, sortField);
    }
}
