package party.fangi.gnucashapi.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionRequest {
    private LocalDate date;
    private String description;
    private String accountFrom;
    private String accountTo;
    private float amount;
}
