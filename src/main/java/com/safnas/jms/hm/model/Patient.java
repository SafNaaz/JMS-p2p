package com.safnas.jms.hm.model;

import java.io.Serializable;

public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String insuraceProvider;
    private Double copay;
    private Double amountToBePayed;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the insuraceProvider
     */
    public String getInsuraceProvider() {
        return insuraceProvider;
    }

    /**
     * @param insuraceProvider the insuraceProvider to set
     */
    public void setInsuraceProvider(String insuraceProvider) {
        this.insuraceProvider = insuraceProvider;
    }

    /**
     * @return the copay
     */
    public Double getCopay() {
        return copay;
    }

    /**
     * @param copay the copay to set
     */
    public void setCopay(Double copay) {
        this.copay = copay;
    }

    /**
     * @return the amountToBePayed
     */
    public Double getAmountToBePayed() {
        return amountToBePayed;
    }

    /**
     * @param amountToBePayed the amountToBePayed to set
     */
    public void setAmountToBePayed(Double amountToBePayed) {
        this.amountToBePayed = amountToBePayed;
    }

    
    
}
