package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "budget_amounts", schema = "public", catalog = "gnucash")
public class BudgetAmounts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "budget_guid", nullable = false, length = 32)
    private String budgetGuid;
    @Basic
    @Column(name = "account_guid", nullable = false, length = 32)
    private String accountGuid;
    @Basic
    @Column(name = "period_num", nullable = false)
    private int periodNum;
    @Basic
    @Column(name = "amount_num", nullable = false)
    private long amountNum;
    @Basic
    @Column(name = "amount_denom", nullable = false)
    private long amountDenom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBudgetGuid() {
        return budgetGuid;
    }

    public void setBudgetGuid(String budgetGuid) {
        this.budgetGuid = budgetGuid;
    }

    public String getAccountGuid() {
        return accountGuid;
    }

    public void setAccountGuid(String accountGuid) {
        this.accountGuid = accountGuid;
    }

    public int getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetAmounts that = (BudgetAmounts) o;
        return id == that.id && periodNum == that.periodNum && amountNum == that.amountNum && amountDenom == that.amountDenom && Objects.equals(budgetGuid, that.budgetGuid) && Objects.equals(accountGuid, that.accountGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, budgetGuid, accountGuid, periodNum, amountNum, amountDenom);
    }
}