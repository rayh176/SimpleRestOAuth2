package com.wallstreet.rest;

import java.util.ArrayList;

public class Period
{
    private ArrayList<String> observation;

    public ArrayList<String> getObservation() { return this.observation; }

    public void setObservation(ArrayList<String> observation) { this.observation = observation; }

    private Barrier barrier;

    public Barrier getBarrier() { return this.barrier; }

    public void setBarrier(Barrier barrier) { this.barrier = barrier; }

    private Evaluation evaluation;

    public Evaluation getEvaluation() { return this.evaluation; }

    public void setEvaluation(Evaluation evaluation) { this.evaluation = evaluation; }

    private Redemption redemption;

    public Redemption getRedemption() { return this.redemption; }

    public void setRedemption(Redemption redemption) { this.redemption = redemption; }
}
