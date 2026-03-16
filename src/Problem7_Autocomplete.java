import java.util.*;

public class Problem7_Autocomplete {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("java", 10);
        map.put("javascript", 8);
        map.put("japan", 5);

        System.out.println(search("ja"));
    }

    public static List<String> search(String prefix) {
        List<String> res = new ArrayList<>();

        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                res.add(key);
            }
        }
        return res;
    }
}