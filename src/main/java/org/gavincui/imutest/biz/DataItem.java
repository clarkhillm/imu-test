package org.gavincui.imutest.biz;

import java.util.Date;

public class DataItem {
    private String devId;
    private double value;
    private Date datetime;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((devId == null) ? 0 : devId.hashCode());
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataItem other = (DataItem) obj;
        if (devId == null) {
            if (other.devId != null)
                return false;
        } else if (!devId.equals(other.devId))
            return false;
        if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
            return false;
        if (datetime == null) {
            if (other.datetime != null)
                return false;
        } else if (!datetime.equals(other.datetime))
            return false;
        return true;
    }

    



}
