public class Main {
    public static void main(String[] args) {
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

        System.out.println("Data in queue:");
        System.out.println(pq);

        System.out.println("Minimum Element: " + pq.deleteMin());
        System.out.println("Ddelete minimum element in the queue:");
        System.out.println(pq);

        pq.decreasePriority("task20", 11);
        System.out.println("Decrease the priority of the queue:");
        System.out.println(pq);
    }
}
