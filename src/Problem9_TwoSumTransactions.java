import java.util.*;

public class Problem9_TwoSumTransactions {

    public static void main(String[] args) {
        int[] arr = {300, 200, 500};

        findTwoSum(arr, 500);
    }

    public static void findTwoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(target - num)) {
                System.out.println("Pair: " + num + " and " + (target - num));
            }
            map.put(num, 1);
        }
    }
}