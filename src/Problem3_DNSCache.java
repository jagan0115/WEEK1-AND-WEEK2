import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

public class Problem3_DNSCache {

    static HashMap<String, DNSEntry> cache = new HashMap<>();
    static int hits = 0, misses = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        Thread.sleep(6000);
        System.out.println(resolve("google.com"));
        stats();
    }

    public static String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry e = cache.get(domain);
            if (System.currentTimeMillis() < e.expiry) {
                hits++;
                return "HIT: " + e.ip;
            }
        }
        misses++;
        String ip = "172.217.0." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(ip, 5));
        return "MISS: " + ip;
    }

    public static void stats() {
        int total = hits + misses;
        System.out.println("Hit Rate: " + (hits * 100.0 / total) + "%");
    }
}