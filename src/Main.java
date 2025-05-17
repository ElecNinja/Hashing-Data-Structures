import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int tableSize = 97;
       try{
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter the size of the hash table (default is 97): ");
           String input = scanner.nextLine();
              if (!input.isEmpty()) {
                tableSize = Integer.parseInt(input);
              }
         } catch (NumberFormatException e) {
            System.out.println("Invalid input. Using default size of 97.");
       }

        List<String> words = readWordsFromFile("words.txt");

        String[] linearTable = new String[tableSize];
        int[] linearCollisions = new int[tableSize];

        String[] quadraticTable = new String[tableSize];
        int[] quadraticCollisions = new int[tableSize];

        String[] doubleTable = new String[tableSize];
        int[] doubleCollisions = new int[tableSize];

        System.out.println("===== Linear Probing =====");
        LinearProbing.hashing(linearTable, words, linearCollisions);
        System.out.println("==== Hashing Table ====");
        printTable(linearTable, linearCollisions);
        System.out.println("Collisions in Linear Probing: " + Arrays.stream(linearCollisions).sum() + "\n");

        System.out.println("\n===== Quadratic Probing =====");
        QuadraticProbing.hashing(quadraticTable, words, quadraticCollisions);
        System.out.println("==== Hashing Table ====");
        printTable(quadraticTable, quadraticCollisions);
        System.out.println("Collisions in Quadratic Probing: " + Arrays.stream(quadraticCollisions).sum() + "\n");

        System.out.println("\n===== Double Hashing =====");
        DoubleHashing.hashing(doubleTable, words, doubleCollisions);
        System.out.println("==== Hashing Table ====");
        printTable(doubleTable, doubleCollisions);
        System.out.println("Collisions in Double Hashing: " + Arrays.stream(doubleCollisions).sum() + "\n");

        System.out.println("\n===== Separate Chaining =====");
        SeparateChaining separate = new SeparateChaining(tableSize);
        for (String word : words) {
            separate.insert(word);
        }
        for (int i = 0; i < tableSize; i++) {
            if (!separate.table[i].isEmpty()) {
                System.out.print(i + ": ");
                separate.table[i].display();
                System.out.println();
            }
        }
        System.out.println("Total Collisions in Separate Chaining: " + separate.getCollisionCount());

    }

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                words.add(scanner.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return words;
    }

    public static void printTable(String[] table, int[] collisions) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.println(i + ": " + table[i] + " (Collisions: " + collisions[i] + ")");
            }
        }
    }
}
