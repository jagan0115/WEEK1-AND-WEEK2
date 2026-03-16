import java.util.*;

public class Problem5_AnalyticsDashboard {

    static HashMap<String, Integer> pageViews = new HashMap<>();
    static HashMap<String, Set<String>> uniqueUsers = new HashMap<>();

    public static void main(String[] args) {
        process("/home", "u1");
        process("/home", "u2");
        process("/home", "u1");

        dashboard();
    }

    public static void process(String page, String user) {
        pageViews.put(page, pageViews.getOrDefault(page, 0) + 1);

        uniqueUsers.putIfAbsent(page, new HashSet<>());
        uniqueUsers.get(page).add(user);
    }

    public static void dashboard() {
        for (String page : pageViews.keySet()) {
            System.out.println(page + " Views: " + pageViews.get(page)
                    + " Unique: " + uniqueUsers.get(page).size());
        }
    }
}