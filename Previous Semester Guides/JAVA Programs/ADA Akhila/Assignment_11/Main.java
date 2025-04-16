public class Main {
    public static void main(String[] args) {
        // Test with Integer data type
        PriorityQueue<Integer> intPQ = new PriorityQueue<>();

        for (int i = 1; i <= 10; i++) {
            intPQ.insert(i, (i * 2) % 10);
        }

        System.out.println("Deleted minimum priority elements with Integer data type:");
        System.out.println("Deleted element: " + intPQ.deleteMin());
        System.out.println(intPQ.decreasePriority(10, 1));

        // Test with Double data type
        PriorityQueue<Double> doublePQ = new PriorityQueue<>();

        for (int i = 1; i <= 10; i++) {
            doublePQ.insert(i * 1.5, (i * 3) % 10);
        }

        System.out.println("\nDeleted minimum priority elements with Double data type:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Deleted element: " + doublePQ.deleteMin());
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        // Insert elements
        pq.insert("task1", 5);
        pq.insert("task2", 3);
        pq.insert("task3", 10);
        pq.insert("task4", 1);
        pq.insert("task5", 19);
        pq.insert("task6", 7);
        pq.insert("task7", 15);
        pq.insert("task8", 4);
        pq.insert("task9", 14);
        pq.insert("task10", 6);
        pq.insert("task11", 2);
        pq.insert("task12", 8);
        pq.insert("task13", 12);
        pq.insert("task14", 20);
        pq.insert("task15", 9);
        pq.insert("task16", 11);
        pq.insert("task17", 16);
        pq.insert("task18", 13);
        pq.insert("task19", 18);
        pq.insert("task20", 17);

        // Print and delete minimum priority elements one by one
        System.out.println("\nDeleted minimum priority elements with String data type:");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Deleted minimum priority element: " + pq.deleteMin());
        }
    }
}
