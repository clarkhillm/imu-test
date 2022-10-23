package org.gavincui.imutest.dao.dev.pair;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.gavincui.imutest.biz.InterfaceSetId;

@Entity
@Table
public class DevPair implements InterfaceSetId {
    @Id
    @Column
    private String id;
    @Column
    private String pairName;
    @Column
    private String devLeft;
    @Column
    private String devRight;
    @Column
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevLeft() {
        return devLeft;
    }

    public void setDevLeft(String devLeft) {
        this.devLeft = devLeft;
    }

    public String getDevRight() {
        return devRight;
    }

    public void setDevRight(String devRight) {
        this.devRight = devRight;
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
