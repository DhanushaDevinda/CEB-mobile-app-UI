package com.example.ceb;

public class Property {
    private String location;
    private String complaintType;
    private String name;
    private String address;
    private String land;
    private String mobile;
    private String more;

    public Property(String location, String complaintType, String name, String address, String land, String mobile, String more) {
        this.location = location;
        this.complaintType = complaintType;
        this.name = name;
        this.address = address;
        this.land = land;
        this.mobile = mobile;
        this.more = more;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
