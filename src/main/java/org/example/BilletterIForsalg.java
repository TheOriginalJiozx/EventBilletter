package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BilletterIForsalg implements Billet {
    private String id;
    private double pris;
    private LocalDate dato;

    public BilletterIForsalg(String id, double pris, LocalDate dato) {
        this.id = id;
        this.pris = pris;
        this.dato = dato;
    }

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
        return 0;
    }

    public String toString() {
        return "Billetter i forsalg: " + id + " " + pris + " " + dato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}