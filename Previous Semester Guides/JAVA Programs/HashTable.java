import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

class HashTable {
    private int size;
    private ArrayList<LinkedList<String>> table;

    public HashTable(int size) {
        this.size = size;
        table = new ArrayList<LinkedList<String>>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<String>());
        }
    }

    public void add(String key) {
        int index = hash(key);
        table.get(index).add(key);
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i)) % size;
        }
        return hash;
    }

    public int collisions(String key) {
        int index = hash(key);
        return table.get(index).size();
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String csvFile = "airports.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] airport = line.split(cvsSplitBy);
                hashTable.add(airport[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] keys = {"ORD", "LAX", "JFK", "SFO"};
        for (String key : keys) {
            System.out.println("Airport Code: " + key + " | Collisions: " + hashTable.collisions(key));
        }
    }
}
