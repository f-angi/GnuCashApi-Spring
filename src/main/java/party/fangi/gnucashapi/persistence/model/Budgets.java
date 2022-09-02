package party.fangi.gnucashapi.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Budgets {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "name", nullable = false, length = 2048)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 2048)
    private String description;
    @Basic
    @Column(name = "num_periods", nullable = false)
    private int numPeriods;

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

    public int getNumPeriods() {
        return numPeriods;
    }

    public void setNumPeriods(int numPeriods) {
        this.numPeriods = numPeriods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budgets budgets = (Budgets) o;
        return numPeriods == budgets.numPeriods && Objects.equals(guid, budgets.guid) && Objects.equals(name, budgets.name) && Objects.equals(description, budgets.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, description, numPeriods);
    }
}