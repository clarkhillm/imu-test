package org.gavincui.imutest.dao.dev.setting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.gavincui.imutest.biz.InterfaceSetId;

@Entity
@Table
public class DevSetting implements InterfaceSetId {
    @Id
    @Column
    private String id;
    @Column
    private String devId;
    @Column
    private String measurement;
    @Column
    private double zeroMetric;
    @Column
    private double positiveMetric;
    @Column
    private double negativeMetric;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public double getZeroMetric() {
        return zeroMetric;
    }

    public void setZeroMetric(double zeroMetric) {
        this.zeroMetric = zeroMetric;
    }

    public double getPositiveMetric() {
        return positiveMetric;
    }

    public void setPositiveMetric(double positiveMetric) {
        this.positiveMetric = positiveMetric;
    }

    public double getNegativeMetric() {
        return negativeMetric;
    }

    public void setNegativeMetric(double negativeMetric) {
        this.negativeMetric = negativeMetric;
    }

}
