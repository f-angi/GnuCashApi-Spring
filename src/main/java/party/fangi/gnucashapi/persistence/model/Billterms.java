package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Billterms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "name", nullable = false, length = 2048)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 2048)
    private String description;
    @Basic
    @Column(name = "refcount", nullable = false)
    private int refcount;
    @Basic
    @Column(name = "invisible", nullable = false)
    private int invisible;
    @Basic
    @Column(name = "parent", nullable = true, length = 32)
    private String parent;
    @Basic
    @Column(name = "type", nullable = false, length = 2048)
    private String type;
    @Basic
    @Column(name = "duedays", nullable = true)
    private Integer duedays;
    @Basic
    @Column(name = "discountdays", nullable = true)
    private Integer discountdays;
    @Basic
    @Column(name = "discount_num", nullable = true)
    private Long discountNum;
    @Basic
    @Column(name = "discount_denom", nullable = true)
    private Long discountDenom;
    @Basic
    @Column(name = "cutoff", nullable = true)
    private Integer cutoff;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRefcount() {
        return refcount;
    }

    public void setRefcount(int refcount) {
        this.refcount = refcount;
    }

    public int getInvisible() {
        return invisible;
    }

    public void setInvisible(int invisible) {
        this.invisible = invisible;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDuedays() {
        return duedays;
    }

    public void setDuedays(Integer duedays) {
        this.duedays = duedays;
    }

    public Integer getDiscountdays() {
        return discountdays;
    }

    public void setDiscountdays(Integer discountdays) {
        this.discountdays = discountdays;
    }

    public Long getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(Long discountNum) {
        this.discountNum = discountNum;
    }

    public Long getDiscountDenom() {
        return discountDenom;
    }

    public void setDiscountDenom(Long discountDenom) {
        this.discountDenom = discountDenom;
    }

    public Integer getCutoff() {
        return cutoff;
    }

    public void setCutoff(Integer cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billterms billterms = (Billterms) o;
        return refcount == billterms.refcount && invisible == billterms.invisible && Objects.equals(guid, billterms.guid) && Objects.equals(name, billterms.name) && Objects.equals(description, billterms.description) && Objects.equals(parent, billterms.parent) && Objects.equals(type, billterms.type) && Objects.equals(duedays, billterms.duedays) && Objects.equals(discountdays, billterms.discountdays) && Objects.equals(discountNum, billterms.discountNum) && Objects.equals(discountDenom, billterms.discountDenom) && Objects.equals(cutoff, billterms.cutoff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, description, refcount, invisible, parent, type, duedays, discountdays, discountNum, discountDenom, cutoff);
    }
}
