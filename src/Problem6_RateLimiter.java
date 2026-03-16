import java.util.*;

class TokenBucket {
    int tokens;
    long lastTime;

    TokenBucket(int tokens) {
        this.tokens = tokens;
        this.lastTime = System.currentTimeMillis();
    }
}

public class Problem6_RateLimiter {

    static HashMap<String, TokenBucket> map = new HashMap<>();
    static final int LIMIT = 5;

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(check("user1"));
        }
    }

    public static boolean check(String user) {
        map.putIfAbsent(user, new TokenBucket(LIMIT));
        TokenBucket tb = map.get(user);

        if (tb.tokens > 0) {
            tb.tokens--;
            return true;
        }
        return false;
    }
}