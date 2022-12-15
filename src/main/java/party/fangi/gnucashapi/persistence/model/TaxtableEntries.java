package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "taxtable_entries", schema = "public", catalog = "gnucash")
public class TaxtableEntries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "taxtable", nullable = false, length = 32)
    private String taxtable;
    @Basic
    @Column(name = "account", nullable = false, length = 32)
    private String account;
    @Basic
    @Column(name = "amount_num", nullable = false)
    private long amountNum;
    @Basic
    @Column(name = "amount_denom", nullable = false)
    private long amountDenom;
    @Basic
    @Column(name = "type", nullable = false)
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxtable() {
        return taxtable;
    }

    public void setTaxtable(String taxtable) {
        this.taxtable = taxtable;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getAmountNum() {
        return amountNum;
    }

    public void setAmountNum(long amountNum) {
        this.amountNum = amountNum;
    }

    public long getAmountDenom() {
        return amountDenom;
    }

    public void setAmountDenom(long amountDenom) {
        this.amountDenom = amountDenom;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxtableEntries that = (TaxtableEntries) o;
        return id == that.id && amountNum == that.amountNum && amountDenom == that.amountDenom && type == that.type && Objects.equals(taxtable, that.taxtable) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxtable, account, amountNum, amountDenom, type);
    }
}