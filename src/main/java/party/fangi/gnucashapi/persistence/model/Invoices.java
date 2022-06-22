package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Invoices {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "id", nullable = false, length = 2048)
    private String id;
    @Basic
    @Column(name = "date_opened", nullable = true)
    private Timestamp dateOpened;
    @Basic
    @Column(name = "date_posted", nullable = true)
    private Timestamp datePosted;
    @Basic
    @Column(name = "notes", nullable = false, length = 2048)
    private String notes;
    @Basic
    @Column(name = "active", nullable = false)
    private int active;
    @Basic
    @Column(name = "currency", nullable = false, length = 32)
    private String currency;
    @Basic
    @Column(name = "owner_type", nullable = true)
    private Integer ownerType;
    @Basic
    @Column(name = "owner_guid", nullable = true, length = 32)
    private String ownerGuid;
    @Basic
    @Column(name = "terms", nullable = true, length = 32)
    private String terms;
    @Basic
    @Column(name = "billing_id", nullable = true, length = 2048)
    private String billingId;
    @Basic
    @Column(name = "post_txn", nullable = true, length = 32)
    private String postTxn;
    @Basic
    @Column(name = "post_lot", nullable = true, length = 32)
    private String postLot;
    @Basic
    @Column(name = "post_acc", nullable = true, length = 32)
    private String postAcc;
    @Basic
    @Column(name = "billto_type", nullable = true)
    private Integer billtoType;
    @Basic
    @Column(name = "billto_guid", nullable = true, length = 32)
    private String billtoGuid;
    @Basic
    @Column(name = "charge_amt_num", nullable = true)
    private Long chargeAmtNum;
    @Basic
    @Column(name = "charge_amt_denom", nullable = true)
    private Long chargeAmtDenom;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Timestamp dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Timestamp getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Timestamp datePosted) {
        this.datePosted = datePosted;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerGuid() {
        return ownerGuid;
    }

    public void setOwnerGuid(String ownerGuid) {
        this.ownerGuid = ownerGuid;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getPostTxn() {
        return postTxn;
    }

    public void setPostTxn(String postTxn) {
        this.postTxn = postTxn;
    }

    public String getPostLot() {
        return postLot;
    }

    public void setPostLot(String postLot) {
        this.postLot = postLot;
    }

    public String getPostAcc() {
        return postAcc;
    }

    public void setPostAcc(String postAcc) {
        this.postAcc = postAcc;
    }

    public Integer getBilltoType() {
        return billtoType;
    }

    public void setBilltoType(Integer billtoType) {
        this.billtoType = billtoType;
    }

    public String getBilltoGuid() {
        return billtoGuid;
    }

    public void setBilltoGuid(String billtoGuid) {
        this.billtoGuid = billtoGuid;
    }

    public Long getChargeAmtNum() {
        return chargeAmtNum;
    }

    public void setChargeAmtNum(Long chargeAmtNum) {
        this.chargeAmtNum = chargeAmtNum;
    }

    public Long getChargeAmtDenom() {
        return chargeAmtDenom;
    }

    public void setChargeAmtDenom(Long chargeAmtDenom) {
        this.chargeAmtDenom = chargeAmtDenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoices invoices = (Invoices) o;
        return active == invoices.active && Objects.equals(guid, invoices.guid) && Objects.equals(id, invoices.id) && Objects.equals(dateOpened, invoices.dateOpened) && Objects.equals(datePosted, invoices.datePosted) && Objects.equals(notes, invoices.notes) && Objects.equals(currency, invoices.currency) && Objects.equals(ownerType, invoices.ownerType) && Objects.equals(ownerGuid, invoices.ownerGuid) && Objects.equals(terms, invoices.terms) && Objects.equals(billingId, invoices.billingId) && Objects.equals(postTxn, invoices.postTxn) && Objects.equals(postLot, invoices.postLot) && Objects.equals(postAcc, invoices.postAcc) && Objects.equals(billtoType, invoices.billtoType) && Objects.equals(billtoGuid, invoices.billtoGuid) && Objects.equals(chargeAmtNum, invoices.chargeAmtNum) && Objects.equals(chargeAmtDenom, invoices.chargeAmtDenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, id, dateOpened, datePosted, notes, active, currency, ownerType, ownerGuid, terms, billingId, postTxn, postLot, postAcc, billtoType, billtoGuid, chargeAmtNum, chargeAmtDenom);
    }
}
