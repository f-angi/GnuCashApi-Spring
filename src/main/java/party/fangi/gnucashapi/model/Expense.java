package party.fangi.gnucashapi.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Expense {

    private String id;

    private String description;

    private String accountFrom;

    private String accountTo;

    private float amount;

    private LocalDate date;

}