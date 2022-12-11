package org.gavincui.imutest.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.gavincui.imutest.biz.IDaoInit;

import java.util.Date;

@Entity
@Table
public class Line implements IDaoInit {
    @Id
    @Column
    private String id;

    @Column
    private String name;
    @Column
    private String code;
    @Column
    private Date dtCreated;
    @Column
    private Date dtUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Date getDtUpdated() {
        return dtUpdated;
    }

    public void setDtUpdated(Date dtUpdated) {
        this.dtUpdated = dtUpdated;
    }

}
