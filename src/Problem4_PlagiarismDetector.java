import java.util.*;

public class Problem4_PlagiarismDetector {

    public static void main(String[] args) {
        String doc1 = "this is a simple test document";
        String doc2 = "this is a simple document";

        System.out.println(checkSimilarity(doc1, doc2));
    }

    public static double checkSimilarity(String d1, String d2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(d1.split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(d2.split(" ")));

        set1.retainAll(set2);

        return (double) set1.size() / Math.max(d1.split(" ").length, d2.split(" ").length) * 100;
    }
}