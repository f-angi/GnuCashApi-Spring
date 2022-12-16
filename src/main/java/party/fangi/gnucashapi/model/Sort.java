package party.fangi.gnucashapi.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Sort {
    private Integer pageNumber;
    private Integer pageSize;
    private String sortField;
    private String sortDirection;
}