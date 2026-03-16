import java.util.*;

public class Problem4_PlagiarismDetector {

    public static void main(String[] args) {
        String d1 = "this is a simple test document";
        String d2 = "this is a simple document";

        System.out.println("Similarity: " + similarity(d1, d2) + "%");
    }

    public static double similarity(String a, String b) {
        String[] w1 = a.split(" ");
        String[] w2 = b.split(" ");

        Set<String> set = new HashSet<>(Arrays.asList(w1));
        int match = 0;

        for (String w : w2) {
            if (set.contains(w)) match++;
        }

        return (match * 100.0) / Math.max(w1.length, w2.length);
    }
}