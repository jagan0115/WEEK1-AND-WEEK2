import java.util.*;

public class Problem5_AnalyticsDashboard {

    static HashMap<String, Integer> pageViews = new HashMap<>();

    public static void main(String[] args) {
        processEvent("/home");
        processEvent("/home");
        processEvent("/about");

        System.out.println(pageViews);
    }

    public static void processEvent(String page) {
        pageViews.put(page, pageViews.getOrDefault(page, 0) + 1);
    }
}