package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Entries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "date_entered", nullable = true)
    private Timestamp dateEntered;
    @Basic
    @Column(name = "description", nullable = true, length = 2048)
    private String description;
    @Basic
    @Column(name = "action", nullable = true, length = 2048)
    private String action;
    @Basic
    @Column(name = "notes", nullable = true, length = 2048)
    private String notes;
    @Basic
    @Column(name = "quantity_num", nullable = true)
    private Long quantityNum;
    @Basic
    @Column(name = "quantity_denom", nullable = true)
    private Long quantityDenom;
    @Basic
    @Column(name = "i_acct", nullable = true, length = 32)
    private String iAcct;
    @Basic
    @Column(name = "i_price_num", nullable = true)
    private Long iPriceNum;
    @Basic
    @Column(name = "i_price_denom", nullable = true)
    private Long iPriceDenom;
    @Basic
    @Column(name = "i_discount_num", nullable = true)
    private Long iDiscountNum;
    @Basic
    @Column(name = "i_discount_denom", nullable = true)
    private Long iDiscountDenom;
    @Basic
    @Column(name = "invoice", nullable = true, length = 32)
    private String invoice;
    @Basic
    @Column(name = "i_disc_type", nullable = true, length = 2048)
    private String iDiscType;
    @Basic
    @Column(name = "i_disc_how", nullable = true, length = 2048)
    private String iDiscHow;
    @Basic
    @Column(name = "i_taxable", nullable = true)
    private Integer iTaxable;
    @Basic
    @Column(name = "i_taxincluded", nullable = true)
    private Integer iTaxincluded;
    @Basic
    @Column(name = "i_taxtable", nullable = true, length = 32)
    private String iTaxtable;
    @Basic
    @Column(name = "b_acct", nullable = true, length = 32)
    private String bAcct;
    @Basic
    @Column(name = "b_price_num", nullable = true)
    private Long bPriceNum;
    @Basic
    @Column(name = "b_price_denom", nullable = true)
    private Long bPriceDenom;
    @Basic
    @Column(name = "bill", nullable = true, length = 32)
    private String bill;
    @Basic
    @Column(name = "b_taxable", nullable = true)
    private Integer bTaxable;
    @Basic
    @Column(name = "b_taxincluded", nullable = true)
    private Integer bTaxincluded;
    @Basic
    @Column(name = "b_taxtable", nullable = true, length = 32)
    private String bTaxtable;
    @Basic
    @Column(name = "b_paytype", nullable = true)
    private Integer bPaytype;
    @Basic
    @Column(name = "billable", nullable = true)
    private Integer billable;
    @Basic
    @Column(name = "billto_type", nullable = true)
    private Integer billtoType;
    @Basic
    @Column(name = "billto_guid", nullable = true, length = 32)
    private String billtoGuid;
    @Basic
    @Column(name = "order_guid", nullable = true, length = 32)
    private String orderGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Timestamp dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getQuantityNum() {
        return quantityNum;
    }

    public void setQuantityNum(Long quantityNum) {
        this.quantityNum = quantityNum;
    }

    public Long getQuantityDenom() {
        return quantityDenom;
    }

    public void setQuantityDenom(Long quantityDenom) {
        this.quantityDenom = quantityDenom;
    }

    public String getiAcct() {
        return iAcct;
    }

    public void setiAcct(String iAcct) {
        this.iAcct = iAcct;
    }

    public Long getiPriceNum() {
        return iPriceNum;
    }

    public void setiPriceNum(Long iPriceNum) {
        this.iPriceNum = iPriceNum;
    }

    public Long getiPriceDenom() {
        return iPriceDenom;
    }

    public void setiPriceDenom(Long iPriceDenom) {
        this.iPriceDenom = iPriceDenom;
    }

    public Long getiDiscountNum() {
        return iDiscountNum;
    }

    public void setiDiscountNum(Long iDiscountNum) {
        this.iDiscountNum = iDiscountNum;
    }

    public Long getiDiscountDenom() {
        return iDiscountDenom;
    }

    public void setiDiscountDenom(Long iDiscountDenom) {
        this.iDiscountDenom = iDiscountDenom;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getiDiscType() {
        return iDiscType;
    }

    public void setiDiscType(String iDiscType) {
        this.iDiscType = iDiscType;
    }

    public String getiDiscHow() {
        return iDiscHow;
    }

    public void setiDiscHow(String iDiscHow) {
        this.iDiscHow = iDiscHow;
    }

    public Integer getiTaxable() {
        return iTaxable;
    }

    public void setiTaxable(Integer iTaxable) {
        this.iTaxable = iTaxable;
    }

    public Integer getiTaxincluded() {
        return iTaxincluded;
    }

    public void setiTaxincluded(Integer iTaxincluded) {
        this.iTaxincluded = iTaxincluded;
    }

    public String getiTaxtable() {
        return iTaxtable;
    }

    public void setiTaxtable(String iTaxtable) {
        this.iTaxtable = iTaxtable;
    }

    public String getbAcct() {
        return bAcct;
    }

    public void setbAcct(String bAcct) {
        this.bAcct = bAcct;
    }

    public Long getbPriceNum() {
        return bPriceNum;
    }

    public void setbPriceNum(Long bPriceNum) {
        this.bPriceNum = bPriceNum;
    }

    public Long getbPriceDenom() {
        return bPriceDenom;
    }

    public void setbPriceDenom(Long bPriceDenom) {
        this.bPriceDenom = bPriceDenom;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public Integer getbTaxable() {
        return bTaxable;
    }

    public void setbTaxable(Integer bTaxable) {
        this.bTaxable = bTaxable;
    }

    public Integer getbTaxincluded() {
        return bTaxincluded;
    }

    public void setbTaxincluded(Integer bTaxincluded) {
        this.bTaxincluded = bTaxincluded;
    }

    public String getbTaxtable() {
        return bTaxtable;
    }

    public void setbTaxtable(String bTaxtable) {
        this.bTaxtable = bTaxtable;
    }

    public Integer getbPaytype() {
        return bPaytype;
    }

    public void setbPaytype(Integer bPaytype) {
        this.bPaytype = bPaytype;
    }

    public Integer getBillable() {
        return billable;
    }

    public void setBillable(Integer billable) {
        this.billable = billable;
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

    public String getOrderGuid() {
        return orderGuid;
    }

    public void setOrderGuid(String orderGuid) {
        this.orderGuid = orderGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entries entries = (Entries) o;
        return Objects.equals(guid, entries.guid) && Objects.equals(date, entries.date) && Objects.equals(dateEntered, entries.dateEntered) && Objects.equals(description, entries.description) && Objects.equals(action, entries.action) && Objects.equals(notes, entries.notes) && Objects.equals(quantityNum, entries.quantityNum) && Objects.equals(quantityDenom, entries.quantityDenom) && Objects.equals(iAcct, entries.iAcct) && Objects.equals(iPriceNum, entries.iPriceNum) && Objects.equals(iPriceDenom, entries.iPriceDenom) && Objects.equals(iDiscountNum, entries.iDiscountNum) && Objects.equals(iDiscountDenom, entries.iDiscountDenom) && Objects.equals(invoice, entries.invoice) && Objects.equals(iDiscType, entries.iDiscType) && Objects.equals(iDiscHow, entries.iDiscHow) && Objects.equals(iTaxable, entries.iTaxable) && Objects.equals(iTaxincluded, entries.iTaxincluded) && Objects.equals(iTaxtable, entries.iTaxtable) && Objects.equals(bAcct, entries.bAcct) && Objects.equals(bPriceNum, entries.bPriceNum) && Objects.equals(bPriceDenom, entries.bPriceDenom) && Objects.equals(bill, entries.bill) && Objects.equals(bTaxable, entries.bTaxable) && Objects.equals(bTaxincluded, entries.bTaxincluded) && Objects.equals(bTaxtable, entries.bTaxtable) && Objects.equals(bPaytype, entries.bPaytype) && Objects.equals(billable, entries.billable) && Objects.equals(billtoType, entries.billtoType) && Objects.equals(billtoGuid, entries.billtoGuid) && Objects.equals(orderGuid, entries.orderGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, date, dateEntered, description, action, notes, quantityNum, quantityDenom, iAcct, iPriceNum, iPriceDenom, iDiscountNum, iDiscountDenom, invoice, iDiscType, iDiscHow, iTaxable, iTaxincluded, iTaxtable, bAcct, bPriceNum, bPriceDenom, bill, bTaxable, bTaxincluded, bTaxtable, bPaytype, billable, billtoType, billtoGuid, orderGuid);
    }
}
