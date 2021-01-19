package com.doodleblue.cybrilla.Bank.model;

public class Balance {
    private Double savings;
    public Double current;

    public Balance() {
    }

    public Balance(Double savings, Double current) {
        this.savings = savings;
        this.current = current;
    }

    public Double getSavings() {
        return savings;
    }

    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }
}
