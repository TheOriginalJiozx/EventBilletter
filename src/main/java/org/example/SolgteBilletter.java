package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolgteBilletter {
    private List<Billet> solgteBilletter;

    public SolgteBilletter() {
        this.solgteBilletter = new ArrayList<>();
    }

    public void tilføjSolgtBillet(Billet billet) {
        solgteBilletter.add(billet);
    }

    @Override
    public String toString() {
        Collections.sort(solgteBilletter, (b1, b2) -> b1.id().compareTo(b2.id()));
        StringBuilder sb = new StringBuilder();
        for (Billet billet : solgteBilletter) {
            sb.append(billet).append("\n");
        }
        return sb.toString();
    }

    public Map<String, Integer> antalAfBilletter() {
        Map<String, Integer> antal = new HashMap<>();
        for (Billet billet : solgteBilletter) {
            String id = billet.id();
            antal.put(id, antal.getOrDefault(id, 0) + 1);
        }
        return antal;
    }

    public String antalAfBilletterToString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : antalAfBilletter().entrySet()) {
            result.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    public String hentAlleStudiekortId() {
        List<String> studiekortNumre = solgteBilletter.stream()
                .filter(billet -> billet.rabat() > 0)
                .map(billet -> ((BilletterIForsalgMedSR) billet).getStudiekortNummer())
                .sorted()
                .collect(Collectors.toList());
        return String.join(", ", studiekortNumre);
    }
}