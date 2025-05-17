import java.util.List;

public class QuadraticProbing {
    static void hashing(String[] table, List<String> arr, int[] collisions) {
        int tsize = table.length;

        for (String value : arr) {
            int hash = HashUtils.hash(value, tsize);
            System.out.println("Hash of " + value + " = " + hash);

            if (table[hash] == null) {
                table[hash] = value;
                collisions[hash] = 0;
                System.out.println("Inserted " + value + " at " + hash);
            } else {
                for (int j = 1; j <= tsize; j++) {
                    int t = (hash + j * j * j) % tsize;
                    if (table[t] == null) {
                        table[t] = value;
                        collisions[t] = j;
                        System.out.println("Collision at " + hash + " for " + value + ", inserting at " + t);
                        break;
                    }
                }
            }
        }
    }
}
