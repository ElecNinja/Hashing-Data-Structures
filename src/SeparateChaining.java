
public class SeparateChaining {
        private linkedlist[] table;
        private int size;

        public SeparateChaining(int size) {
            this.size = size;
            table = new linkedlist[size];
            for (int i = 0; i < size; i++) {
                table[i] = new linkedlist();
            }
        }

        public void insert(String key) {
            int index = HashUtils.hash(key, size);
            table[index].insertAtEnd(key);
        }
    }

