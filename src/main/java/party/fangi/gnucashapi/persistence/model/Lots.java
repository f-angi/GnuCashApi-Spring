package party.fangi.gnucashapi.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Lots {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "account_guid", nullable = true, length = 32)
    private String accountGuid;
    @Basic
    @Column(name = "is_closed", nullable = false)
    private int isClosed;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAccountGuid() {
        return accountGuid;
    }

    public void setAccountGuid(String accountGuid) {
        this.accountGuid = accountGuid;
    }

    public int getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(int isClosed) {
        this.isClosed = isClosed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lots lots = (Lots) o;
        return isClosed == lots.isClosed && Objects.equals(guid, lots.guid) && Objects.equals(accountGuid, lots.accountGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, accountGuid, isClosed);
    }
}