import java.util.*;

class Bucket {
    int tokens;
    long last;

    Bucket(int t) {
        tokens = t;
        last = System.currentTimeMillis();
    }
}

public class Problem6_RateLimiter {

    static HashMap<String, Bucket> map = new HashMap<>();
    static int LIMIT = 5;

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(check("user1"));
        }
    }

    public static boolean check(String user) {
        map.putIfAbsent(user, new Bucket(LIMIT));
        Bucket b = map.get(user);

        if (b.tokens > 0) {
            b.tokens--;
            return true;
        }
        return false;
    }
}