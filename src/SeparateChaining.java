
public class SeparateChaining {
    final linkedlist[] table;
    private final int size;
    int collisionCount = 0;

    public SeparateChaining(int size) {
        this.size = size;
        table = new linkedlist[size];

        for (int i = 0; i < size; i++) {
            table[i] = new linkedlist();
        }
    }
        public void insert(String key){
            int i = HashUtils.hash(key, size);
            int posInChain = table[i].count() + 1;
            System.out.println("Hash of " + key + " = " + i);
            if(!table[i].isEmpty()){
                collisionCount++;
                System.out.println("Collision at " + i + " for " + key);
                table[i].insertAtEnd(key);
                System.out.println("Inserted " + key + " at index " + i + " in position " + posInChain + " of the chain");
            }
            table[i].insertAtEnd(key);
            System.out.println("Inserted " + key + " at index " + i);

        }
    public int getCollisionCount () {
        return collisionCount;
    }

}

