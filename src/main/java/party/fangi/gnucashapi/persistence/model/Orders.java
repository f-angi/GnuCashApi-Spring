package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "id", nullable = false, length = 2048)
    private String id;
    @Basic
    @Column(name = "notes", nullable = false, length = 2048)
    private String notes;
    @Basic
    @Column(name = "reference", nullable = false, length = 2048)
    private String reference;
    @Basic
    @Column(name = "active", nullable = false)
    private int active;
    @Basic
    @Column(name = "date_opened", nullable = false)
    private Timestamp dateOpened;
    @Basic
    @Column(name = "date_closed", nullable = false)
    private Timestamp dateClosed;
    @Basic
    @Column(name = "owner_type", nullable = false)
    private int ownerType;
    @Basic
    @Column(name = "owner_guid", nullable = false, length = 32)
    private String ownerGuid;

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Timestamp getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Timestamp dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Timestamp getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Timestamp dateClosed) {
        this.dateClosed = dateClosed;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerGuid() {
        return ownerGuid;
    }

    public void setOwnerGuid(String ownerGuid) {
        this.ownerGuid = ownerGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return active == orders.active && ownerType == orders.ownerType && Objects.equals(guid, orders.guid) && Objects.equals(id, orders.id) && Objects.equals(notes, orders.notes) && Objects.equals(reference, orders.reference) && Objects.equals(dateOpened, orders.dateOpened) && Objects.equals(dateClosed, orders.dateClosed) && Objects.equals(ownerGuid, orders.ownerGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, id, notes, reference, active, dateOpened, dateClosed, ownerType, ownerGuid);
    }
}
