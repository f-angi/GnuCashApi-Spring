package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Schedxactions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guid", nullable = false, length = 32)
    private String guid;
    @Basic
    @Column(name = "name", nullable = true, length = 2048)
    private String name;
    @Basic
    @Column(name = "enabled", nullable = false)
    private int enabled;
    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Basic
    @Column(name = "last_occur", nullable = true)
    private Date lastOccur;
    @Basic
    @Column(name = "num_occur", nullable = false)
    private int numOccur;
    @Basic
    @Column(name = "rem_occur", nullable = false)
    private int remOccur;
    @Basic
    @Column(name = "auto_create", nullable = false)
    private int autoCreate;
    @Basic
    @Column(name = "auto_notify", nullable = false)
    private int autoNotify;
    @Basic
    @Column(name = "adv_creation", nullable = false)
    private int advCreation;
    @Basic
    @Column(name = "adv_notify", nullable = false)
    private int advNotify;
    @Basic
    @Column(name = "instance_count", nullable = false)
    private int instanceCount;
    @Basic
    @Column(name = "template_act_guid", nullable = false, length = 32)
    private String templateActGuid;

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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLastOccur() {
        return lastOccur;
    }

    public void setLastOccur(Date lastOccur) {
        this.lastOccur = lastOccur;
    }

    public int getNumOccur() {
        return numOccur;
    }

    public void setNumOccur(int numOccur) {
        this.numOccur = numOccur;
    }

    public int getRemOccur() {
        return remOccur;
    }

    public void setRemOccur(int remOccur) {
        this.remOccur = remOccur;
    }

    public int getAutoCreate() {
        return autoCreate;
    }

    public void setAutoCreate(int autoCreate) {
        this.autoCreate = autoCreate;
    }

    public int getAutoNotify() {
        return autoNotify;
    }

    public void setAutoNotify(int autoNotify) {
        this.autoNotify = autoNotify;
    }

    public int getAdvCreation() {
        return advCreation;
    }

    public void setAdvCreation(int advCreation) {
        this.advCreation = advCreation;
    }

    public int getAdvNotify() {
        return advNotify;
    }

    public void setAdvNotify(int advNotify) {
        this.advNotify = advNotify;
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public void setInstanceCount(int instanceCount) {
        this.instanceCount = instanceCount;
    }

    public String getTemplateActGuid() {
        return templateActGuid;
    }

    public void setTemplateActGuid(String templateActGuid) {
        this.templateActGuid = templateActGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedxactions that = (Schedxactions) o;
        return enabled == that.enabled && numOccur == that.numOccur && remOccur == that.remOccur && autoCreate == that.autoCreate && autoNotify == that.autoNotify && advCreation == that.advCreation && advNotify == that.advNotify && instanceCount == that.instanceCount && Objects.equals(guid, that.guid) && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(lastOccur, that.lastOccur) && Objects.equals(templateActGuid, that.templateActGuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, enabled, startDate, endDate, lastOccur, numOccur, remOccur, autoCreate, autoNotify, advCreation, advNotify, instanceCount, templateActGuid);
    }
}
