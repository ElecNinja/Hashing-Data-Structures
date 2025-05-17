
public class SeparateChaining {
    private linkedlist[] table;
    private int size;
    private int collisionCount;

    public SeparateChaining(int size) {
        this.size = size;
        table = new linkedlist[size];

        for (int i = 0; i < size; i++) {
            table[i] = new linkedlist();


        }
    }
        public void insert(String key){
            int i = HashUtils.hash(key, size);
            table[i].insertAtEnd(key);
            if (table[i].count() > 0) {
                collisionCount++;
            }

            table[i].insertAtEnd(key);
        }

    public int getCollisionCount () {
        return collisionCount;
    }

}

