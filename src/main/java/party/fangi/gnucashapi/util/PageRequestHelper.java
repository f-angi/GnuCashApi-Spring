package party.fangi.gnucashapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
        final int pageNumber = sort.getPageNumber() == null ? 0 : sort.getPageNumber();
        final int pageSize = sort.getPageSize() == null ? defaultPageSize : sort.getPageSize();
        final Direction sortDirection = sort.getSortDirection() == null ? Direction.fromString(defaultSortDirection) : sort.getSortDirection();
        final String sortField = sort.getSortField() == null ? defaultSortField : sort.getSortField();

        return PageRequest.of(pageNumber, pageSize, sortDirection, sortField);
    }
}
