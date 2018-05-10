package com.wallstreet.rest;

import java.util.ArrayList;

public class Equities<T>
{
    private String etickers;

    public String getEtickers() { return this.etickers; }

    public void setEtickers(String etickers) { this.etickers = etickers; }

    private ArrayList<String> riskfreeRateEquities;

    public ArrayList<String> getRiskfreeRateEquities() { return this.riskfreeRateEquities; }

    public void setRiskfreeRateEquities(ArrayList<String> riskfreeRateEquities) { this.riskfreeRateEquities = riskfreeRateEquities; }

    private ArrayList<T> underlyingCurrency;

    public ArrayList<T> getUnderlyingCurrency() { return this.underlyingCurrency; }

    public void setUnderlyingCurrency(ArrayList<T> underlyingCurrency) { this.underlyingCurrency = underlyingCurrency; }

}
