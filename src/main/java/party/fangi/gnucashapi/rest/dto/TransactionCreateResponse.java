package party.fangi.gnucashapi.rest.dto;

import lombok.Data;

@Data
public class TransactionCreateResponse {

    private String guid;

    public static TransactionCreateResponse of(String guid) {
        final var transactionCreateResponse = new TransactionCreateResponse();
        transactionCreateResponse.setGuid(guid);
        return transactionCreateResponse;
    }
}
