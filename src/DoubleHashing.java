public class DoubleHashing {
    public static final int DEFAULT_CAPACITY = 53;
    public final int capacity;
    public final String[] table;
    public final boolean[] isDeleted;
    public int size;
    public int collisions;

    public DoubleHashing(int capacity) {
        this.capacity = capacity;
        this.table = new String[capacity];
        this.isDeleted = new boolean[capacity];
        this.size = 0;
        this.collisions = 0;
    }

    public int hashFun1(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    
    public int hashFun2(String key) {
        int h = Math.abs(key.hashCode());
        return 97 * (h % 97);
    }

    // Insert element into the hash table
    public void insert(String key) {
        if (size >= capacity) {
            System.out.println("Table is full");
            return;
        }

        int h1 = hashFun1(key);
        int h2 = hashFun2(key);
        int index = h1;
        int i = 1;

        while (table[index] != null && !isDeleted[index]) {
            if (table[index].equals(key)) {
                return; // Key already exists
            }
            collisions++;
            index = (h1 + i * h2) % capacity; // Standard double hashing formula
            i++;
        }

        table[index] = key;
        isDeleted[index] = false;
        size++;
    }

    // Check if key exists
    public boolean isContains(String key) {
        return findIndex(key) != -1;
    }

    // Delete an element
    public void delete(String key) {
        int index = findIndex(key);
        if (index != -1) {
            isDeleted[index] = true;
            size--;
        }
    }

    // Internal: find index of a key
    public int findIndex(String key) {
        int h1 = hashFun1(key);
        int h2 = hashFun2(key);
        int index = h1;
        int i = 1;

        while (table[index] != null) {
            if (!isDeleted[index] && table[index].equals(key)) {
                return index;
            }
            index = (h1 + i * h2) % capacity;
            i++;
        }
        return -1;
    }

    public int getCollisions() {
        return collisions;
    }

    public int getSize() {
        return size;
    }
}
