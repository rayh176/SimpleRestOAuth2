package com.wallstreet.rest;

import java.util.ArrayList;

public class Reference
{
    private ArrayList<String> initialLookback;

    private String initialLookbackSummary;

    private String finalLookbackSummary;

    private ArrayList<String> finalLookback;

    public ArrayList<String> getInitialLookback() { return this.initialLookback; }

    public void setInitialLookback(ArrayList<String> initialLookback) { this.initialLookback = initialLookback; }

    public String getInitialLookbackSummary() { return this.initialLookbackSummary; }

    public void setInitialLookbackSummary(String initialLookbackSummary) { this.initialLookbackSummary = initialLookbackSummary; }

    public ArrayList<String> getFinalLookback() { return this.finalLookback; }

    public void setFinalLookback(ArrayList<String> finalLookback) { this.finalLookback = finalLookback; }

    public String getFinalLookbackSummary() { return this.finalLookbackSummary; }

    public void setFinalLookbackSummary(String finalLookbackSummary) { this.finalLookbackSummary = finalLookbackSummary; }
}