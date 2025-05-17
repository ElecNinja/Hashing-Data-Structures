
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
            if(!table[i].isEmpty()){
                collisionCount++;
            }
            table[i].insertAtEnd(key);
        }
    public int getCollisionCount () {
        return collisionCount;
    }

}

