package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Commodities {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "namespace", nullable = false, length = 2048)
    private String namespace;
    @Basic
    @Column(name = "mnemonic", nullable = false, length = 2048)
    private String mnemonic;
    @Basic
    @Column(name = "fullname", nullable = true, length = 2048)
    private String fullname;
    @Basic
    @Column(name = "cusip", nullable = true, length = 2048)
    private String cusip;
    @Basic
    @Column(name = "fraction", nullable = false)
    private int fraction;
    @Basic
    @Column(name = "quote_flag", nullable = false)
    private int quoteFlag;
    @Basic
    @Column(name = "quote_source", nullable = true, length = 2048)
    private String quoteSource;
    @Basic
    @Column(name = "quote_tz", nullable = true, length = 2048)
    private String quoteTz;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public int getQuoteFlag() {
        return quoteFlag;
    }

    public void setQuoteFlag(int quoteFlag) {
        this.quoteFlag = quoteFlag;
    }

    public String getQuoteSource() {
        return quoteSource;
    }

    public void setQuoteSource(String quoteSource) {
        this.quoteSource = quoteSource;
    }

    public String getQuoteTz() {
        return quoteTz;
    }

    public void setQuoteTz(String quoteTz) {
        this.quoteTz = quoteTz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodities that = (Commodities) o;
        return fraction == that.fraction && quoteFlag == that.quoteFlag && Objects.equals(guid, that.guid) && Objects.equals(namespace, that.namespace) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(fullname, that.fullname) && Objects.equals(cusip, that.cusip) && Objects.equals(quoteSource, that.quoteSource) && Objects.equals(quoteTz, that.quoteTz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, namespace, mnemonic, fullname, cusip, fraction, quoteFlag, quoteSource, quoteTz);
    }
}
