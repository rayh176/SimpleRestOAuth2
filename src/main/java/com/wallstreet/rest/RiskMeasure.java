package com.wallstreet.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RiskMeasure {

    @JsonProperty("name")
    private String name;

    @JsonProperty("issueDate")
    private String issueDate;

    @JsonProperty("maturityDate")
    private String maturityDate;

    @JsonProperty("horizon")
    private double horizon;

    @JsonProperty("riskfreeRateSettlement")
    private String riskfreeRateSettlement;

    @JsonProperty("equities")
    private Equities equities;

    @JsonProperty("numerics")
    private String numerics;

    @JsonProperty("terminalPayoff")
    private TerminalPayoff terminalPayoff;

    @JsonProperty("exitCost")
    private double exitCost;

    @JsonProperty("ongoingTransaction")
    private int ongoingTransaction;

    @JsonProperty("ongoingInsurance")
    private int ongoingInsurance;

    @JsonProperty("ongoingOther")
    private double ongoingOther;

    @JsonProperty("performanceFee")
    private int performanceFee;

    @JsonProperty("carriedInterest")
    private int carriedInterest;

    @JsonProperty("earlyRedemptionFeature")
    private EarlyRedemptionFeature earlyRedemptionFeature;

    @JsonProperty("entryCost")
    private int entryCost;

    @JsonProperty("reversed")
    private boolean reversed;

    @JsonProperty("reference")
    private Reference reference;

    @JsonProperty("IHP1midbid")
    private double IHP1midbid;

    @JsonProperty("IHP2midbid")
    private double IHP2midbid;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public String getIssueDate() { return this.issueDate; }

    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }

    public String getMaturityDate() { return this.maturityDate; }

    public void setMaturityDate(String maturityDate) { this.maturityDate = maturityDate; }

    public double getHorizon() { return this.horizon; }

    public void setHorizon(double horizon) { this.horizon = horizon; }

    public String getRiskfreeRateSettlement() { return this.riskfreeRateSettlement; }

    public void setRiskfreeRateSettlement(String riskfreeRateSettlement) { this.riskfreeRateSettlement = riskfreeRateSettlement; }

    public Equities getEquities() { return this.equities; }

    public void setEquities(Equities equities) { this.equities = equities; }

    public String getNumerics() { return this.numerics; }

    public void setNumerics(String numerics) { this.numerics = numerics; }

    public boolean getReversed() { return this.reversed; }

    public void setReversed(boolean reversed) { this.reversed = reversed; }

    public TerminalPayoff getTerminalPayoff() { return this.terminalPayoff; }

    public void setTerminalPayoff(TerminalPayoff terminalPayoff) { this.terminalPayoff = terminalPayoff; }

    public Reference getReference() { return this.reference; }

    public void setReference(Reference reference) { this.reference = reference; }

    public EarlyRedemptionFeature getEarlyRedemptionFeature() { return this.earlyRedemptionFeature; }

    public void setEarlyRedemptionFeature(EarlyRedemptionFeature earlyRedemptionFeature) { this.earlyRedemptionFeature = earlyRedemptionFeature; }

    public int getEntryCost() { return this.entryCost; }

    public void setEntryCost(int entryCost) { this.entryCost = entryCost; }

    public double getIHP1midbid() { return this.IHP1midbid; }

    public void setIHP1midbid(double IHP1midbid) { this.IHP1midbid = IHP1midbid; }

    public double getIHP2midbid() { return this.IHP2midbid; }

    public void setIHP2midbid(double IHP2midbid) { this.IHP2midbid = IHP2midbid; }

    public double getExitCost() { return this.exitCost; }

    public void setExitCost(double exitCost) { this.exitCost = exitCost; }

    public int getOngoingTransaction() { return this.ongoingTransaction; }

    public void setOngoingTransaction(int ongoingTransaction) { this.ongoingTransaction = ongoingTransaction; }

    public int getOngoingInsurance() { return this.ongoingInsurance; }

    public void setOngoingInsurance(int ongoingInsurance) { this.ongoingInsurance = ongoingInsurance; }

    public double getOngoingOther() { return this.ongoingOther; }

    public void setOngoingOther(double ongoingOther) { this.ongoingOther = ongoingOther; }

    public int getPerformanceFee() { return this.performanceFee; }

    public void setPerformanceFee(int performanceFee) { this.performanceFee = performanceFee; }

    public int getCarriedInterest() { return this.carriedInterest; }

    public void setCarriedInterest(int carriedInterest) { this.carriedInterest = carriedInterest; }
}
