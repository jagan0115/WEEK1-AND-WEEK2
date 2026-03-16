public class Problem8_ParkingSystem {

    static String[] parking = new String[10];

    public static void main(String[] args) {
        park("ABC123");
        park("XYZ999");
    }

    public static void park(String plate) {
        int hash = Math.abs(plate.hashCode()) % parking.length;

        int start = hash;
        while (parking[hash] != null) {
            hash = (hash + 1) % parking.length;
            if (hash == start) {
                System.out.println("Full");
                return;
            }
        }

        parking[hash] = plate;
        System.out.println("Parked at " + hash);
    }
}