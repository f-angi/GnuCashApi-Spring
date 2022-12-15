package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Jobs {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "id", nullable = false, length = 2048)
    private String id;
    @Basic
    @Column(name = "name", nullable = false, length = 2048)
    private String name;
    @Basic
    @Column(name = "reference", nullable = false, length = 2048)
    private String reference;
    @Basic
    @Column(name = "active", nullable = false)
    private int active;
    @Basic
    @Column(name = "owner_type", nullable = true)
    private Integer ownerType;
    @Basic
    @Column(name = "owner_guid", nullable = true, length = 32)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobs jobs = (Jobs) o;
        return active == jobs.active && Objects.equals(guid, jobs.guid) && Objects.equals(id, jobs.id) && Objects.equals(name, jobs.name) && Objects.equals(reference, jobs.reference) && Objects.equals(ownerType, jobs.ownerType) && Objects.equals(ownerGuid, jobs.ownerGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, id, name, reference, active, ownerType, ownerGuid);
    }
}