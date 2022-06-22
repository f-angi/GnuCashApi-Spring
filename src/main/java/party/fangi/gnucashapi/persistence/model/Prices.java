package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Prices {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "commodity_guid", nullable = false, length = 32)
    private String commodityGuid;
    @Basic
    @Column(name = "currency_guid", nullable = false, length = 32)
    private String currencyGuid;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "source", nullable = true, length = 2048)
    private String source;
    @Basic
    @Column(name = "type", nullable = true, length = 2048)
    private String type;
    @Basic
    @Column(name = "value_num", nullable = false)
    private long valueNum;
    @Basic
    @Column(name = "value_denom", nullable = false)
    private long valueDenom;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCommodityGuid() {
        return commodityGuid;
    }

    public void setCommodityGuid(String commodityGuid) {
        this.commodityGuid = commodityGuid;
    }

    public String getCurrencyGuid() {
        return currencyGuid;
    }

    public void setCurrencyGuid(String currencyGuid) {
        this.currencyGuid = currencyGuid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getValueNum() {
        return valueNum;
    }

    public void setValueNum(long valueNum) {
        this.valueNum = valueNum;
    }

    public long getValueDenom() {
        return valueDenom;
    }

    public void setValueDenom(long valueDenom) {
        this.valueDenom = valueDenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prices prices = (Prices) o;
        return valueNum == prices.valueNum && valueDenom == prices.valueDenom && Objects.equals(guid, prices.guid) && Objects.equals(commodityGuid, prices.commodityGuid) && Objects.equals(currencyGuid, prices.currencyGuid) && Objects.equals(date, prices.date) && Objects.equals(source, prices.source) && Objects.equals(type, prices.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, commodityGuid, currencyGuid, date, source, type, valueNum, valueDenom);
    }
}
