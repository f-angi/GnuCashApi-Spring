package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Accounts {
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "name", nullable = false, length = 2048)
    private String name;
    @Basic
    @Column(name = "account_type", nullable = false, length = 2048)
    private String accountType;
    @Basic
    @Column(name = "commodity_guid", nullable = true, length = 32)
    private String commodityGuid;
    @Basic
    @Column(name = "commodity_scu", nullable = false)
    private int commodityScu;
    @Basic
    @Column(name = "non_std_scu", nullable = false)
    private int nonStdScu;
    @Basic
    @Column(name = "parent_guid", nullable = true, length = 32)
    private String parentGuid;
    @Basic
    @Column(name = "code", nullable = true, length = 2048)
    private String code;
    @Basic
    @Column(name = "description", nullable = true, length = 2048)
    private String description;
    @Basic
    @Column(name = "hidden", nullable = true)
    private Integer hidden;
    @Basic
    @Column(name = "placeholder", nullable = true)
    private Integer placeholder;

}