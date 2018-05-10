package com.wallstreet.rest;

import java.util.ArrayList;

public class EarlyRedemptionFeature {
    private String calltype;

    public String getCalltype() { return this.calltype; }

    public void setCalltype(String calltype) { this.calltype = calltype; }

    private ArrayList<Period> period;

    public ArrayList<Period> getPeriod() { return this.period; }

    public void setPeriod(ArrayList<Period> period) { this.period = period; }
}
