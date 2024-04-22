package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Billetter billetter = new Billetter("Billetter til salg");

        SolgteBilletter solgteBilletter = new SolgteBilletter();

        String id1 = Billetter.generateRandomID();
        LocalDate date1 = LocalDate.of(2024, 5, 25); // Actual date
        BilletterIDøren billetterIDøren = new BilletterIDøren(id1, 150.0, date1);

        String id2 = Billetter.generateRandomID();
        LocalDate date2 = LocalDate.of(2024, 5, 25); // Actual date
        BilletterIForsalg billetterIForsalg = new BilletterIForsalg(id2, 120.0, date2);

        String id3 = Billetter.generateRandomID();
        LocalDate date3 = LocalDate.of(2024, 5, 25); // Actual date
        BilletterIForsalgMedSR billetterIForsalgMedSR = new BilletterIForsalgMedSR(id3, 90.0, date3, 0.15, "omal0001");

        solgteBilletter.tilføjSolgtBillet(billetterIForsalgMedSR);

        billetter.tilføjBillet(billetterIDøren);
        billetter.tilføjBillet(billetterIForsalg);
        billetter.tilføjBillet(billetterIForsalgMedSR);

        System.out.println(billetter);

        System.out.println("Antal af hver slags billetter solgt:");
        System.out.println(solgteBilletter.antalAfBilletterToString());
        System.out.println("Studiekortnumre for solgte billetter med rabat:");
        System.out.println(solgteBilletter.hentAlleStudiekortId());
    }
}