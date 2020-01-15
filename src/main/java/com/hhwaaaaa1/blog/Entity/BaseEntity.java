package com.hhwaaaaa1.blog.Entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "mod_no")
    private long modNo;

    @Column(name = "mod_dts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDts;

    @Column(name = "reg_no")
    private long regNo;

    @Column(name = "reg_dts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDts;


    public long getModNo() {
        return modNo;
    }

    public void setModNo(long modNo) {
        this.modNo = modNo;
    }

    public Date getModDts() {
        return modDts;
    }

    public void setModDts(Date modDts) {
        this.modDts = modDts;
    }

    public long getRegNo() {
        return regNo;
    }

    public void setRegNo(long regNo) {
        this.regNo = regNo;
    }

    public Date getRegDts() {
        return regDts;
    }

    public void setRegDts(Date regDts) {
        this.regDts = regDts;
    }
}
