/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.model;

/**
 *
 * @author alexis
 */
public class User {
    
    private String name;
    private String firstname;
    private String houseNum;
    private String mobileNum;
    private String proNum;
    private String adress;
    private String city;
    private String postalCode;
    private String email;

    public User(String name, String firstname, String houseNum, String mobileNum, String proNum, String adress, String city, String postalCode, String email) {
        this.name = name;
        this.firstname = firstname;
        this.houseNum = houseNum;
        this.mobileNum = mobileNum;
        this.proNum = proNum;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getProNum() {
        return proNum;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
