package com.cit360projectmark4.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "captured", schema = "scabs_webapp", catalog = "")
public class CapturedEntity {
    private int capturedId;
    private String owner;
    private String scab;
    private int capturedStr;
    private int capturedLuck;

    @Id
    @Column(name = "captured_id", nullable = false)
    public int getCapturedId() {
        return capturedId;
    }

    public void setCapturedId(int capturedId) {
        this.capturedId = capturedId;
    }

    @Basic
    @Column(name = "owner", nullable = false, length = 45)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "scab", nullable = false, length = 45)
    public String getScab() {
        return scab;
    }

    public void setScab(String scab) {
        this.scab = scab;
    }

    @Basic
    @Column(name = "captured_str", nullable = false)
    public int getCapturedStr() {
        return capturedStr;
    }

    public void setCapturedStr(int capturedStr) {
        this.capturedStr = capturedStr;
    }

    @Basic
    @Column(name = "captured_luck", nullable = false)
    public int getCapturedLuck() {
        return capturedLuck;
    }

    public void setCapturedLuck(int capturedLuck) {
        this.capturedLuck = capturedLuck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapturedEntity that = (CapturedEntity) o;
        return capturedId == that.capturedId &&
                capturedStr == that.capturedStr &&
                capturedLuck == that.capturedLuck &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(scab, that.scab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capturedId, owner, scab, capturedStr, capturedLuck);
    }
}
