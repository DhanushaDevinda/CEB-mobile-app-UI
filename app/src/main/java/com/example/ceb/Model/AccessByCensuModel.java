package com.example.ceb.Model;

public class AccessByCensuModel {

    private String _id;
    private String device;
    private String qty;
    private String hours;
    private String power;
    private String kDay;

    public String getkDay() {
        return kDay;
    }

    public void setkDay(String kDay) {
        this.kDay = kDay;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
