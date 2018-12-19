package com.cit360projectmark4.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "scabs", schema = "scabs_webapp", catalog = "")
public class ScabsEntity {
    private int scabId;
    private String scabName;
    private int defaultStr;
    private int defaultLuck;

    @Id
    @Column(name = "scab_id", nullable = false)
    public int getScabId() {
        return scabId;
    }

    public void setScabId(int scabId) {
        this.scabId = scabId;
    }

    @Basic
    @Column(name = "scab_name", nullable = false, length = 45)
    public String getScabName() {
        return scabName;
    }

    public void setScabName(String scabName) {
        this.scabName = scabName;
    }

    @Basic
    @Column(name = "default_str", nullable = false)
    public int getDefaultStr() {
        return defaultStr;
    }

    public void setDefaultStr(int defaultStr) {
        this.defaultStr = defaultStr;
    }

    @Basic
    @Column(name = "default_luck", nullable = false)
    public int getDefaultLuck() {
        return defaultLuck;
    }

    public void setDefaultLuck(int defaultLuck) {
        this.defaultLuck = defaultLuck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScabsEntity that = (ScabsEntity) o;
        return scabId == that.scabId &&
                defaultStr == that.defaultStr &&
                defaultLuck == that.defaultLuck &&
                Objects.equals(scabName, that.scabName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scabId, scabName, defaultStr, defaultLuck);
    }
}
