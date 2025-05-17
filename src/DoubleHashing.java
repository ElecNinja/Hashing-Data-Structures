import java.util.List;

public class DoubleHashing {
    static void hashing(String[] table, List<String> arr, int[] collisions) {
        int tsize = table.length;

        for (String value : arr) {
            int h1 = HashUtils.hash(value, tsize);
            int h2 = secondHash(value, tsize);
            if (h2 == 0) h2 = 1; // avoid zero step

            if (table[h1] == null) {
                table[h1] = value;
                collisions[h1] = 0;
            } else {
                for (int i = 1; i < tsize; i++) {
                    int idx = (h1 + i * h2) % tsize;
                    if (table[idx] == null) {
                        table[idx] = value;
                        collisions[idx] = i;
                        break;
                    }
                }
            }
        }
    }

    private static int secondHash(String key, int tableSize) {
        int hash = HashUtils.hash(key, tableSize);
        return 97 - (hash % 97); // classic secondary hash, prime smaller than table size
    }
}
