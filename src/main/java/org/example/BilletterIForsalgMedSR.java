package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BilletterIForsalgMedSR implements Billet {
    private String id;
    private double pris;
    private LocalDate dato;
    private double rabat;
    private String studiekortNummer;

    public BilletterIForsalgMedSR(String id, double pris, LocalDate dato, double rabat, String studiekortNummer) {
        this.id = id;
        this.pris = pris;
        this.dato = dato;
        this.rabat = rabat;
        this.studiekortNummer = studiekortNummer;
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
        return rabat;
    }

    public String toString() {
        return "Billetter i forsalg med studierabat: " + "ID: " + id + ". " + "Prisen hvis du køber færre end 10 dage før eventstart: " + pris + ". " + "Eventet starter d. " + dato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ". " + "Hvis du køber mere end 10 dage før eventstart er prisen: " + (pris-(pris*rabat) + ". " + "Dit studiekortnummer er: " + studiekortNummer);
    }

    public String getStudiekortNummer() {
        return studiekortNummer;
    }
}