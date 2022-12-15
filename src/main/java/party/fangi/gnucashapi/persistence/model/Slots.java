package party.fangi.gnucashapi.persistence.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Slots {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "obj_guid", nullable = false, length = 32)
    private String objGuid;
    @Basic
    @Column(name = "name", nullable = false, length = 4096)
    private String name;
    @Basic
    @Column(name = "slot_type", nullable = false)
    private int slotType;
    @Basic
    @Column(name = "int64_val", nullable = true)
    private Long int64Val;
    @Basic
    @Column(name = "string_val", nullable = true, length = 4096)
    private String stringVal;
    @Basic
    @Column(name = "double_val", nullable = true, precision = 0)
    private Double doubleVal;
    @Basic
    @Column(name = "timespec_val", nullable = true)
    private Timestamp timespecVal;
    @Basic
    @Column(name = "guid_val", nullable = true, length = 32)
    private String guidVal;
    @Basic
    @Column(name = "numeric_val_num", nullable = true)
    private Long numericValNum;
    @Basic
    @Column(name = "numeric_val_denom", nullable = true)
    private Long numericValDenom;
    @Basic
    @Column(name = "gdate_val", nullable = true)
    private Date gdateVal;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSlotType() {
        return slotType;
    }

    public void setSlotType(int slotType) {
        this.slotType = slotType;
    }

    public Long getInt64Val() {
        return int64Val;
    }

    public void setInt64Val(Long int64Val) {
        this.int64Val = int64Val;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public Double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(Double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public Timestamp getTimespecVal() {
        return timespecVal;
    }

    public void setTimespecVal(Timestamp timespecVal) {
        this.timespecVal = timespecVal;
    }

    public String getGuidVal() {
        return guidVal;
    }

    public void setGuidVal(String guidVal) {
        this.guidVal = guidVal;
    }

    public Long getNumericValNum() {
        return numericValNum;
    }

    public void setNumericValNum(Long numericValNum) {
        this.numericValNum = numericValNum;
    }

    public Long getNumericValDenom() {
        return numericValDenom;
    }

    public void setNumericValDenom(Long numericValDenom) {
        this.numericValDenom = numericValDenom;
    }

    public Date getGdateVal() {
        return gdateVal;
    }

    public void setGdateVal(Date gdateVal) {
        this.gdateVal = gdateVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slots slots = (Slots) o;
        return id == slots.id && slotType == slots.slotType && Objects.equals(objGuid, slots.objGuid) && Objects.equals(name, slots.name) && Objects.equals(int64Val, slots.int64Val) && Objects.equals(stringVal, slots.stringVal) && Objects.equals(doubleVal, slots.doubleVal) && Objects.equals(timespecVal, slots.timespecVal) && Objects.equals(guidVal, slots.guidVal) && Objects.equals(numericValNum, slots.numericValNum) && Objects.equals(numericValDenom, slots.numericValDenom) && Objects.equals(gdateVal, slots.gdateVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objGuid, name, slotType, int64Val, stringVal, doubleVal, timespecVal, guidVal, numericValNum, numericValDenom, gdateVal);
    }
}