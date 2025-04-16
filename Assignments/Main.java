import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println();
        csvReader airports = new csvReader();
        List<pair<String,String>> codes = airports.read("./src/airportCodes.csv");
        System.out.printf("read %d airport locations%n", codes.size());
        hashTable ht = new hashTable();
        codes.forEach(airport -> ht.insert(airport.key, airport.value));
        System.out.println("Collisions: " + ht.collisions("BUG"));
        System.out.println("Collisions: " + ht.collisions("MIR"));
        System.out.println("Collisions: " + ht.collisions("CTS"));
        System.out.println("Collisions: " + ht.collisions("ANU"));
    }
}