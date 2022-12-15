package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Versions {
    @Id
    @Column(name = "table_name", nullable = false, length = 50)
    private String tableName;
    @Basic
    @Column(name = "table_version", nullable = false)
    private int tableVersion;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getTableVersion() {
        return tableVersion;
    }

    public void setTableVersion(int tableVersion) {
        this.tableVersion = tableVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Versions versions = (Versions) o;
        return tableVersion == versions.tableVersion && Objects.equals(tableName, versions.tableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, tableVersion);
    }
}