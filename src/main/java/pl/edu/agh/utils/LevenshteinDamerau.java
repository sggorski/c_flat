package pl.edu.agh.utils;

import java.util.ArrayList;
import java.util.Map;

public class LevenshteinDamerau {
    private static int distance(String a, String b) {
        //System.out.println(b);
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        for (int i = 0; i < a.length() + 1; i++) {
            table.add(new ArrayList<>());
            table.get(i).add(i);
        }
        for (int i = 1; i < b.length() + 1; i++) {
            table.get(0).add(i);
        }

        for (int i = 1; i < b.length() + 1; i++) {
            for (int j = 1; j < a.length() + 1; j++) {
                int cost = a.charAt(j-1) == b.charAt(i-1) ? 0 : 1;
                int value = Math.min(table.get(j-1).get(i-1) + cost, Math.min(table.get(j-1).get(i) + 1, table.get(j).get(i-1) + 1));
                if (i > 1 && j > 1 && a.charAt(j-2) == b.charAt(i-1) && a.charAt(j-1)==b.charAt(i-2) && value > table.get(j-2).get(i-2) + cost ) {
                    value = table.get(j-2).get(i-2) + cost;
                }


                table.get(j).add(value);

            }
        }
//        for (ArrayList<Integer> row : table) {
//            System.out.println(row);
//        }
        return table.get(a.length()).get(b.length());
    }

    public static String proposeWord(String word, ArrayList<String> grammar, int accSimilarity) {
        String currentWord = null;
        int currentCost = accSimilarity + 1;
        for (String potentialMatch : grammar){
            //System.out.println(potentialMatch);
            int newCost = distance(word, potentialMatch);
            if (newCost < currentCost) {
                currentCost = newCost;
                currentWord = potentialMatch;
                //System.out.println(currentWord);
            }
        }
        return currentWord;
    }

}
