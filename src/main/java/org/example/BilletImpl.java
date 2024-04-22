package org.example;

public class BilletImpl implements Billet {
    private String id;
    private double pris;
    private double rabat;

    // Constructor
    public BilletImpl(String id, double pris, double rabat) {
        this.id = id;
        this.pris = pris;
        this.rabat = rabat;
    }

    // Implement interface methods
    @Override
    public String id() {
        return id;
    }

    @Override
    public double pris() {
        return pris;
    }

    @Override
    public double rabat() {
        return rabat;
    }

    public void add(BilletImpl billetImpl) {

    }
}