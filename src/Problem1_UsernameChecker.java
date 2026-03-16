import java.util.*;

public class Problem1_UsernameChecker {

    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    public static void main(String[] args) {
        users.put("john_doe", 1);
        users.put("admin", 2);

        System.out.println(checkAvailability("john_doe"));
        System.out.println(suggestAlternatives("john_doe"));
    }

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(username + i);
        }
        return list;
    }
}