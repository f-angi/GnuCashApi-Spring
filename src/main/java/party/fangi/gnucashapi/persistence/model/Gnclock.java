package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Gnclock {
    @Id
    @Basic
    @Column(name = "hostname", nullable = true, length = 255)
    private String hostname;
    @Basic
    @Column(name = "pid", nullable = true)
    private Integer pid;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gnclock gnclock = (Gnclock) o;
        return Objects.equals(hostname, gnclock.hostname) && Objects.equals(pid, gnclock.pid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostname, pid);
    }
}