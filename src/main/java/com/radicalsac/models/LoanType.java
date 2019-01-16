/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radicalsac.models;

/**
 *
 * @author emmanuel.idoko
 */
public class LoanType {

    private int id;
    private String name;
    private String description;
    private long interestRate;
    private int numberOfGuarantors;

    public LoanType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(long interestRate) {
        this.interestRate = interestRate;
    }

    public int getNumberOfGuarantors() {
        return numberOfGuarantors;
    }

    public void setNumberOfGuarantors(int numberOfGuarantors) {
        this.numberOfGuarantors = numberOfGuarantors;
    }

}
