import java.util.*;

public class Problem10_MultiLevelCache {

    static LinkedHashMap<String, String> L1 = new LinkedHashMap<>(5, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry e) {
            return size() > 3;
        }
    };

    static HashMap<String, String> L2 = new HashMap<>();

    public static void main(String[] args) {
        L2.put("v1", "data1");

        get("v1");
        get("v1");
    }

    public static void get(String key) {
        if (L1.containsKey(key)) {
            System.out.println("L1 HIT");
        } else if (L2.containsKey(key)) {
            System.out.println("L2 HIT → moved to L1");
            L1.put(key, L2.get(key));
        } else {
            System.out.println("DB HIT");
        }
    }
}