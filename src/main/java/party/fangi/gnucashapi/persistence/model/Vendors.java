package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Vendors {
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
    @Column(name = "currency", nullable = false, length = 32)
    private String currency;
    @Basic
    @Column(name = "active", nullable = false)
    private int active;
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
    @Column(name = "terms", nullable = true, length = 32)
    private String terms;
    @Basic
    @Column(name = "tax_inc", nullable = true, length = 2048)
    private String taxInc;
    @Basic
    @Column(name = "tax_table", nullable = true, length = 32)
    private String taxTable;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getTaxInc() {
        return taxInc;
    }

    public void setTaxInc(String taxInc) {
        this.taxInc = taxInc;
    }

    public String getTaxTable() {
        return taxTable;
    }

    public void setTaxTable(String taxTable) {
        this.taxTable = taxTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendors vendors = (Vendors) o;
        return active == vendors.active && taxOverride == vendors.taxOverride && Objects.equals(guid, vendors.guid) && Objects.equals(name, vendors.name) && Objects.equals(id, vendors.id) && Objects.equals(notes, vendors.notes) && Objects.equals(currency, vendors.currency) && Objects.equals(addrName, vendors.addrName) && Objects.equals(addrAddr1, vendors.addrAddr1) && Objects.equals(addrAddr2, vendors.addrAddr2) && Objects.equals(addrAddr3, vendors.addrAddr3) && Objects.equals(addrAddr4, vendors.addrAddr4) && Objects.equals(addrPhone, vendors.addrPhone) && Objects.equals(addrFax, vendors.addrFax) && Objects.equals(addrEmail, vendors.addrEmail) && Objects.equals(terms, vendors.terms) && Objects.equals(taxInc, vendors.taxInc) && Objects.equals(taxTable, vendors.taxTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, id, notes, currency, active, taxOverride, addrName, addrAddr1, addrAddr2, addrAddr3, addrAddr4, addrPhone, addrFax, addrEmail, terms, taxInc, taxTable);
    }
}