import java.util.*;

public class Problem10_MultiLevelCache {

    static LinkedHashMap<String, String> L1 = new LinkedHashMap<>();
    static HashMap<String, String> L2 = new HashMap<>();

    public static void main(String[] args) {
        L2.put("video1", "data");

        getVideo("video1");
        getVideo("video1");
    }

    public static void getVideo(String id) {
        if (L1.containsKey(id)) {
            System.out.println("L1 HIT");
        } else if (L2.containsKey(id)) {
            System.out.println("L2 HIT → moved to L1");
            L1.put(id, L2.get(id));
        } else {
            System.out.println("DB HIT");
        }
    }
}