package party.fangi.gnucashapi.persistence.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Books {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "root_account_guid", nullable = false, length = 32)
    private String rootAccountGuid;
    @Basic
    @Column(name = "root_template_guid", nullable = false, length = 32)
    private String rootTemplateGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRootAccountGuid() {
        return rootAccountGuid;
    }

    public void setRootAccountGuid(String rootAccountGuid) {
        this.rootAccountGuid = rootAccountGuid;
    }

    public String getRootTemplateGuid() {
        return rootTemplateGuid;
    }

    public void setRootTemplateGuid(String rootTemplateGuid) {
        this.rootTemplateGuid = rootTemplateGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(guid, books.guid) && Objects.equals(rootAccountGuid, books.rootAccountGuid) && Objects.equals(rootTemplateGuid, books.rootTemplateGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, rootAccountGuid, rootTemplateGuid);
    }
}