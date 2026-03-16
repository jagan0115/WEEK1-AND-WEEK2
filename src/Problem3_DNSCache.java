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

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }

    public static String resolve(String domain) {
        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);
            if (System.currentTimeMillis() < entry.expiry) {
                return "Cache HIT: " + entry.ip;
            }
        }

        String ip = "172.217.0.1"; // fake DNS
        cache.put(domain, new DNSEntry(ip, 5));
        return "Cache MISS: " + ip;
    }
}
