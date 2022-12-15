package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Employees {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "username", nullable = false, length = 2048)
    private String username;
    @Basic
    @Column(name = "id", nullable = false, length = 2048)
    private String id;
    @Basic
    @Column(name = "language", nullable = false, length = 2048)
    private String language;
    @Basic
    @Column(name = "acl", nullable = false, length = 2048)
    private String acl;
    @Basic
    @Column(name = "active", nullable = false)
    private int active;
    @Basic
    @Column(name = "currency", nullable = false, length = 32)
    private String currency;
    @Basic
    @Column(name = "ccard_guid", nullable = true, length = 32)
    private String ccardGuid;
    @Basic
    @Column(name = "workday_num", nullable = false)
    private long workdayNum;
    @Basic
    @Column(name = "workday_denom", nullable = false)
    private long workdayDenom;
    @Basic
    @Column(name = "rate_num", nullable = false)
    private long rateNum;
    @Basic
    @Column(name = "rate_denom", nullable = false)
    private long rateDenom;
    @Basic
    @Column(name = "addr_name", nullable = true, length = 1024)
    private String addrName;
    @Basic
    @Column(name = "addr_addr1", nullable = true, length = 1024)
    private String addrAddr1;
    @Basic
    @Column(name = "addr_addr2", nullable = true, length = 1024)
    private String addrAddr2;
    @Basic
    @Column(name = "addr_addr3", nullable = true, length = 1024)
    private String addrAddr3;
    @Basic
    @Column(name = "addr_addr4", nullable = true, length = 1024)
    private String addrAddr4;
    @Basic
    @Column(name = "addr_phone", nullable = true, length = 128)
    private String addrPhone;
    @Basic
    @Column(name = "addr_fax", nullable = true, length = 128)
    private String addrFax;
    @Basic
    @Column(name = "addr_email", nullable = true, length = 256)
    private String addrEmail;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl;
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

    public String getCcardGuid() {
        return ccardGuid;
    }

    public void setCcardGuid(String ccardGuid) {
        this.ccardGuid = ccardGuid;
    }

    public long getWorkdayNum() {
        return workdayNum;
    }

    public void setWorkdayNum(long workdayNum) {
        this.workdayNum = workdayNum;
    }

    public long getWorkdayDenom() {
        return workdayDenom;
    }

    public void setWorkdayDenom(long workdayDenom) {
        this.workdayDenom = workdayDenom;
    }

    public long getRateNum() {
        return rateNum;
    }

    public void setRateNum(long rateNum) {
        this.rateNum = rateNum;
    }

    public long getRateDenom() {
        return rateDenom;
    }

    public void setRateDenom(long rateDenom) {
        this.rateDenom = rateDenom;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getAddrAddr1() {
        return addrAddr1;
    }

    public void setAddrAddr1(String addrAddr1) {
        this.addrAddr1 = addrAddr1;
    }

    public String getAddrAddr2() {
        return addrAddr2;
    }

    public void setAddrAddr2(String addrAddr2) {
        this.addrAddr2 = addrAddr2;
    }

    public String getAddrAddr3() {
        return addrAddr3;
    }

    public void setAddrAddr3(String addrAddr3) {
        this.addrAddr3 = addrAddr3;
    }

    public String getAddrAddr4() {
        return addrAddr4;
    }

    public void setAddrAddr4(String addrAddr4) {
        this.addrAddr4 = addrAddr4;
    }

    public String getAddrPhone() {
        return addrPhone;
    }

    public void setAddrPhone(String addrPhone) {
        this.addrPhone = addrPhone;
    }

    public String getAddrFax() {
        return addrFax;
    }

    public void setAddrFax(String addrFax) {
        this.addrFax = addrFax;
    }

    public String getAddrEmail() {
        return addrEmail;
    }

    public void setAddrEmail(String addrEmail) {
        this.addrEmail = addrEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return active == employees.active && workdayNum == employees.workdayNum && workdayDenom == employees.workdayDenom && rateNum == employees.rateNum && rateDenom == employees.rateDenom && Objects.equals(guid, employees.guid) && Objects.equals(username, employees.username) && Objects.equals(id, employees.id) && Objects.equals(language, employees.language) && Objects.equals(acl, employees.acl) && Objects.equals(currency, employees.currency) && Objects.equals(ccardGuid, employees.ccardGuid) && Objects.equals(addrName, employees.addrName) && Objects.equals(addrAddr1, employees.addrAddr1) && Objects.equals(addrAddr2, employees.addrAddr2) && Objects.equals(addrAddr3, employees.addrAddr3) && Objects.equals(addrAddr4, employees.addrAddr4) && Objects.equals(addrPhone, employees.addrPhone) && Objects.equals(addrFax, employees.addrFax) && Objects.equals(addrEmail, employees.addrEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, username, id, language, acl, active, currency, ccardGuid, workdayNum, workdayDenom, rateNum, rateDenom, addrName, addrAddr1, addrAddr2, addrAddr3, addrAddr4, addrPhone, addrFax, addrEmail);
    }
}