package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Billetter {
    private String name;
    private ArrayList<Billet> billetter;
    private static final String BOGSTAVER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String TAL = "0123456789";
    private static final int ID_LÆNGDE = 8;

    public static String generateRandomID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Generate random characters
        for (int i = 0; i < ID_LÆNGDE / 2; i++) {
            int randomIndex = random.nextInt(BOGSTAVER.length());
            sb.append(BOGSTAVER.charAt(randomIndex));
        }

        // Generate random numbers
        for (int i = 0; i < ID_LÆNGDE / 2; i++) {
            int randomIndex = random.nextInt(TAL.length());
            sb.append(TAL.charAt(randomIndex));
        }

        // Shuffle the characters and numbers to make the ID more random
        String id = sb.toString();
        char[] idArray = id.toCharArray();
        for (int i = 0; i < idArray.length; i++) {
            int randomIndex = random.nextInt(idArray.length);
            char temp = idArray[i];
            idArray[i] = idArray[randomIndex];
            idArray[randomIndex] = temp;
        }

        return new String(idArray);
    }

    public Billetter(String name) {
        this.name = name;
        this.billetter = new ArrayList<>();
    }

    public void tilføjBillet(Billet billet) {
        billetter.add(billet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Billetter: ").append(name).append("\n");
        sb.append("Billetter til salg:\n");
        for (Billet billet : billetter) {
            sb.append(billet).append("\n");
        }
        return sb.toString();
    }
}