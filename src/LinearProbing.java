import java.util.List;

public class LinearProbing {
    static void hashing(String[] table, List<String> arr, int[] collisions) {
        int tsize = table.length;

        for (String value : arr) {
            int hash = HashUtils.hash(value, tsize);

            if (table[hash] == null) {
                table[hash] = value;
                collisions[hash] = 0;
            } else {
                for (int j = 1; j <= tsize; j++) {
                    int t = (hash + j) % tsize;
                    if (table[t] == null) {
                        table[t] = value;
                        collisions[t] = j;
                        break;
                    }
                }
            }
        }
    }
}
