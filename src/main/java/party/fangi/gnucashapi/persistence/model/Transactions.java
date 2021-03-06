package party.fangi.gnucashapi.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Transactions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "currency_guid", nullable = false, length = 32)
    private String currencyGuid;
    @Basic
    @Column(name = "num", nullable = false, length = 2048)
    private String num;
    @Basic
    @Column(name = "post_date", nullable = true)
    private Timestamp postDate;
    @Basic
    @Column(name = "enter_date", nullable = true)
    private Timestamp enterDate;
    @Basic
    @Column(name = "description", nullable = true, length = 2048)
    private String description;

    @OneToMany(mappedBy = "transaction")
    private List<Splits> split;
}
