package party.fangi.gnucashapi.persistence.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Splits {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @ManyToOne
    @JoinColumn(name = "tx_guid")
    @NotNull
    private Transactions transaction;
    @ManyToOne
    @JoinColumn(name = "account_guid")
    @NotNull
    private Accounts account;
    @Basic
    @Column(name = "memo", nullable = false, length = 2048)
    private String memo;
    @Basic
    @Column(name = "action", nullable = false, length = 2048)
    private String action;
    @Basic
    @Column(name = "reconcile_state", nullable = false, length = 1)
    private String reconcileState;
    @Basic
    @Column(name = "reconcile_date", nullable = true)
    private Timestamp reconcileDate;
    @Basic
    @Column(name = "value_num", nullable = false)
    private long valueNum;
    @Basic
    @Column(name = "value_denom", nullable = false)
    private long valueDenom;
    @Basic
    @Column(name = "quantity_num", nullable = false)
    private long quantityNum;
    @Basic
    @Column(name = "quantity_denom", nullable = false)
    private long quantityDenom;
    @Basic
    @Column(name = "lot_guid", nullable = true, length = 32)
    private String lotGuid;

}
