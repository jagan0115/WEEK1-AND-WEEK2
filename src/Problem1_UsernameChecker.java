import java.util.*;

public class Problem1_UsernameChecker {

    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    public static void main(String[] args) {
        users.put("john_doe", 1);
        users.put("admin", 2);

        String username = "john_doe";

        if (checkAvailability(username)) {
            System.out.println("Available");
        } else {
            System.out.println("Not Available");
            System.out.println("Suggestions: " + suggestAlternatives(username));
        }

        System.out.println("Most Attempted: " + getMostAttempted());
    }

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(username + i);
            list.add(username + "_" + i);
        }
        return list;
    }

    public static String getMostAttempted() {
        return attempts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");
    }
}