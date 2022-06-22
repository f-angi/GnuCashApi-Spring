package party.fangi.gnucashapi.persistence.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Recurrences {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "obj_guid", nullable = false, length = 32)
    private String objGuid;
    @Basic
    @Column(name = "recurrence_mult", nullable = false)
    private int recurrenceMult;
    @Basic
    @Column(name = "recurrence_period_type", nullable = false, length = 2048)
    private String recurrencePeriodType;
    @Basic
    @Column(name = "recurrence_period_start", nullable = false)
    private Date recurrencePeriodStart;
    @Basic
    @Column(name = "recurrence_weekend_adjust", nullable = false, length = 2048)
    private String recurrenceWeekendAdjust;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjGuid() {
        return objGuid;
    }

    public void setObjGuid(String objGuid) {
        this.objGuid = objGuid;
    }

    public int getRecurrenceMult() {
        return recurrenceMult;
    }

    public void setRecurrenceMult(int recurrenceMult) {
        this.recurrenceMult = recurrenceMult;
    }

    public String getRecurrencePeriodType() {
        return recurrencePeriodType;
    }

    public void setRecurrencePeriodType(String recurrencePeriodType) {
        this.recurrencePeriodType = recurrencePeriodType;
    }

    public Date getRecurrencePeriodStart() {
        return recurrencePeriodStart;
    }

    public void setRecurrencePeriodStart(Date recurrencePeriodStart) {
        this.recurrencePeriodStart = recurrencePeriodStart;
    }

    public String getRecurrenceWeekendAdjust() {
        return recurrenceWeekendAdjust;
    }

    public void setRecurrenceWeekendAdjust(String recurrenceWeekendAdjust) {
        this.recurrenceWeekendAdjust = recurrenceWeekendAdjust;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recurrences that = (Recurrences) o;
        return id == that.id && recurrenceMult == that.recurrenceMult && Objects.equals(objGuid, that.objGuid) && Objects.equals(recurrencePeriodType, that.recurrencePeriodType) && Objects.equals(recurrencePeriodStart, that.recurrencePeriodStart) && Objects.equals(recurrenceWeekendAdjust, that.recurrenceWeekendAdjust);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objGuid, recurrenceMult, recurrencePeriodType, recurrencePeriodStart, recurrenceWeekendAdjust);
    }
}
