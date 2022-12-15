package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Customers {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "name", nullable = false, length = 2048)
    private String name;
    @Basic
    @Column(name = "id", nullable = false, length = 2048)
    private String id;
    @Basic
    @Column(name = "notes", nullable = false, length = 2048)
    private String notes;
    @Basic
    @Column(name = "active", nullable = false)
    private int active;
    @Basic
    @Column(name = "discount_num", nullable = false)
    private long discountNum;
    @Basic
    @Column(name = "discount_denom", nullable = false)
    private long discountDenom;
    @Basic
    @Column(name = "credit_num", nullable = false)
    private long creditNum;
    @Basic
    @Column(name = "credit_denom", nullable = false)
    private long creditDenom;
    @Basic
    @Column(name = "currency", nullable = false, length = 32)
    private String currency;
    @Basic
    @Column(name = "tax_override", nullable = false)
    private int taxOverride;
    @Basic
    @Column(name = "addr_name", nullable = true, length = 1024)
    private String addrName;
    @Basic
    @Column(name = "addr_addr1", nullable = true, length = 1024)
    private String addrAddr1;
    @Basic
    @Column(name = "addr_addr2", nullable = true, length = 1024)
    private String addrAddr2;
    @Basic
    @Column(name = "addr_addr3", nullable = true, length = 1024)
    private String addrAddr3;
    @Basic
    @Column(name = "addr_addr4", nullable = true, length = 1024)
    private String addrAddr4;
    @Basic
    @Column(name = "addr_phone", nullable = true, length = 128)
    private String addrPhone;
    @Basic
    @Column(name = "addr_fax", nullable = true, length = 128)
    private String addrFax;
    @Basic
    @Column(name = "addr_email", nullable = true, length = 256)
    private String addrEmail;
    @Basic
    @Column(name = "shipaddr_name", nullable = true, length = 1024)
    private String shipaddrName;
    @Basic
    @Column(name = "shipaddr_addr1", nullable = true, length = 1024)
    private String shipaddrAddr1;
    @Basic
    @Column(name = "shipaddr_addr2", nullable = true, length = 1024)
    private String shipaddrAddr2;
    @Basic
    @Column(name = "shipaddr_addr3", nullable = true, length = 1024)
    private String shipaddrAddr3;
    @Basic
    @Column(name = "shipaddr_addr4", nullable = true, length = 1024)
    private String shipaddrAddr4;
    @Basic
    @Column(name = "shipaddr_phone", nullable = true, length = 128)
    private String shipaddrPhone;
    @Basic
    @Column(name = "shipaddr_fax", nullable = true, length = 128)
    private String shipaddrFax;
    @Basic
    @Column(name = "shipaddr_email", nullable = true, length = 256)
    private String shipaddrEmail;
    @Basic
    @Column(name = "terms", nullable = true, length = 32)
    private String terms;
    @Basic
    @Column(name = "tax_included", nullable = true)
    private Integer taxIncluded;
    @Basic
    @Column(name = "taxtable", nullable = true, length = 32)
    private String taxtable;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public long getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(long discountNum) {
        this.discountNum = discountNum;
    }

    public long getDiscountDenom() {
        return discountDenom;
    }

    public void setDiscountDenom(long discountDenom) {
        this.discountDenom = discountDenom;
    }

    public long getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(long creditNum) {
        this.creditNum = creditNum;
    }

    public long getCreditDenom() {
        return creditDenom;
    }

    public void setCreditDenom(long creditDenom) {
        this.creditDenom = creditDenom;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getTaxOverride() {
        return taxOverride;
    }

    public void setTaxOverride(int taxOverride) {
        this.taxOverride = taxOverride;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getAddrAddr1() {
        return addrAddr1;
    }

    public void setAddrAddr1(String addrAddr1) {
        this.addrAddr1 = addrAddr1;
    }

    public String getAddrAddr2() {
        return addrAddr2;
    }

    public void setAddrAddr2(String addrAddr2) {
        this.addrAddr2 = addrAddr2;
    }

    public String getAddrAddr3() {
        return addrAddr3;
    }

    public void setAddrAddr3(String addrAddr3) {
        this.addrAddr3 = addrAddr3;
    }

    public String getAddrAddr4() {
        return addrAddr4;
    }

    public void setAddrAddr4(String addrAddr4) {
        this.addrAddr4 = addrAddr4;
    }

    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone;
    }

    public String getAddrFax() {
        return addrFax;
    }

    public void setAddrFax(String addrFax) {
        this.addrFax = addrFax;
    }

    public String getAddrEmail() {
        return addrEmail;
    }

    public void setAddrEmail(String addrEmail) {
        this.addrEmail = addrEmail;
    }

    public String getShipaddrName() {
        return shipaddrName;
    }

    public void setShipaddrName(String shipaddrName) {
        this.shipaddrName = shipaddrName;
    }

    public String getShipaddrAddr1() {
        return shipaddrAddr1;
    }

    public void setShipaddrAddr1(String shipaddrAddr1) {
        this.shipaddrAddr1 = shipaddrAddr1;
    }

    public String getShipaddrAddr2() {
        return shipaddrAddr2;
    }

    public void setShipaddrAddr2(String shipaddrAddr2) {
        this.shipaddrAddr2 = shipaddrAddr2;
    }

    public String getShipaddrAddr3() {
        return shipaddrAddr3;
    }

    public void setShipaddrAddr3(String shipaddrAddr3) {
        this.shipaddrAddr3 = shipaddrAddr3;
    }

    public String getShipaddrAddr4() {
        return shipaddrAddr4;
    }

    public void setShipaddrAddr4(String shipaddrAddr4) {
        this.shipaddrAddr4 = shipaddrAddr4;
    }

    public String getShipaddrPhone() {
        return shipaddrPhone;
    }

    public void setShipaddrPhone(String shipaddrPhone) {
        this.shipaddrPhone = shipaddrPhone;
    }

    public String getShipaddrFax() {
        return shipaddrFax;
    }

    public void setShipaddrFax(String shipaddrFax) {
        this.shipaddrFax = shipaddrFax;
    }

    public String getShipaddrEmail() {
        return shipaddrEmail;
    }

    public void setShipaddrEmail(String shipaddrEmail) {
        this.shipaddrEmail = shipaddrEmail;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Integer getTaxIncluded() {
        return taxIncluded;
    }

    public void setTaxIncluded(Integer taxIncluded) {
        this.taxIncluded = taxIncluded;
    }

    public String getTaxtable() {
        return taxtable;
    }

    public void setTaxtable(String taxtable) {
        this.taxtable = taxtable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return active == customers.active && discountNum == customers.discountNum && discountDenom == customers.discountDenom && creditNum == customers.creditNum && creditDenom == customers.creditDenom && taxOverride == customers.taxOverride && Objects.equals(guid, customers.guid) && Objects.equals(name, customers.name) && Objects.equals(id, customers.id) && Objects.equals(notes, customers.notes) && Objects.equals(currency, customers.currency) && Objects.equals(addrName, customers.addrName) && Objects.equals(addrAddr1, customers.addrAddr1) && Objects.equals(addrAddr2, customers.addrAddr2) && Objects.equals(addrAddr3, customers.addrAddr3) && Objects.equals(addrAddr4, customers.addrAddr4) && Objects.equals(addrPhone, customers.addrPhone) && Objects.equals(addrFax, customers.addrFax) && Objects.equals(addrEmail, customers.addrEmail) && Objects.equals(shipaddrName, customers.shipaddrName) && Objects.equals(shipaddrAddr1, customers.shipaddrAddr1) && Objects.equals(shipaddrAddr2, customers.shipaddrAddr2) && Objects.equals(shipaddrAddr3, customers.shipaddrAddr3) && Objects.equals(shipaddrAddr4, customers.shipaddrAddr4) && Objects.equals(shipaddrPhone, customers.shipaddrPhone) && Objects.equals(shipaddrFax, customers.shipaddrFax) && Objects.equals(shipaddrEmail, customers.shipaddrEmail) && Objects.equals(terms, customers.terms) && Objects.equals(taxIncluded, customers.taxIncluded) && Objects.equals(taxtable, customers.taxtable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, id, notes, active, discountNum, discountDenom, creditNum, creditDenom, currency, taxOverride, addrName, addrAddr1, addrAddr2, addrAddr3, addrAddr4, addrPhone, addrFax, addrEmail, shipaddrName, shipaddrAddr1, shipaddrAddr2, shipaddrAddr3, shipaddrAddr4, shipaddrPhone, shipaddrFax, shipaddrEmail, terms, taxIncluded, taxtable);
    }
}