package party.fangi.gnucashapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AmountPerPeriod {

    private final Date period;

    private final Long amount;

}