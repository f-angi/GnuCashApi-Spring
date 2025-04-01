package party.fangi.gnucashapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Sort.Direction;

@Builder
@Data
public class Sort {
    private Integer pageNumber;
    private Integer pageSize;
    private String sortField;
    private Direction sortDirection;
}
