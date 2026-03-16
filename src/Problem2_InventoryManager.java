import java.util.*;

public class Problem2_InventoryManager {

    static HashMap<String, Integer> stock = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    public static void main(String[] args) {
        stock.put("IPHONE", 2);

        purchaseItem("IPHONE", 101);
        purchaseItem("IPHONE", 102);
        purchaseItem("IPHONE", 103);
    }

    public static synchronized void purchaseItem(String product, int userId) {
        int available = stock.getOrDefault(product, 0);

        if (available > 0) {
            stock.put(product, available - 1);
            System.out.println("Success for user " + userId);
        } else {
            waitingList.add(userId);
            System.out.println("Added to waiting list: " + userId);
        }
    }
}