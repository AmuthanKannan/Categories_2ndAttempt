package com.example.VyAppar;

public class Class_Address {
    private String Address;
    private int current;

    public Class_Address(String address, int current) {
        Address = address;
        this.current = current;
    }

    public Class_Address(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
