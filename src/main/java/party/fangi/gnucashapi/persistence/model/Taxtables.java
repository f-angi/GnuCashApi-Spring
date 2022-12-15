package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Taxtables {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "refcount", nullable = false)
    private long refcount;
    @Basic
    @Column(name = "invisible", nullable = false)
    private int invisible;
    @Basic
    @Column(name = "parent", nullable = true, length = 32)
    private String parent;

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

    public long getRefcount() {
        return refcount;
    }

    public void setRefcount(long refcount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxtables taxtables = (Taxtables) o;
        return refcount == taxtables.refcount && invisible == taxtables.invisible && Objects.equals(guid, taxtables.guid) && Objects.equals(name, taxtables.name) && Objects.equals(parent, taxtables.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, refcount, invisible, parent);
    }
}