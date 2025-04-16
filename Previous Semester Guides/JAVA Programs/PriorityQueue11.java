import java.util.LinkedList;

public class PriorityQueue<T> {

    private LinkedList<Node<T>> list;

    private static class Node<T> {
        T data;
        int priority;

        Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    public PriorityQueue() {
        this.list = new LinkedList<Node<T>>();
    }

    public void insert(T data, int priority) {
        Node<T> newNode = new Node<T>(data, priority);
        int i;
        for (i = 0; i < list.size(); i++) {
            if (priority < list.get(i).priority) {
                break;
            }
        }
        list.add(i, newNode);
    }

    public void insert(T data) {
        insert(data, 19);
    }

    public T deleteMin() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst().data;
    }

    public void decreasePriority(T data, int k) {
        for (Node<T> node : list) {
            if (node.data.equals(data)) {
                node.priority -= k;
                sort();
                return;
            }
        }
    }

    private void sort() {
        list.sort((n1, n2) -> n1.priority - n2.priority);
    }

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<String>();

        priorityQueue1.insert("KLM", 5);
        priorityQueue1.insert("reebock", 7);
        priorityQueue1.insert("inorbit's", 3);
        priorityQueue1.insert("puma", 2);
        priorityQueue1.insert("tommy");
        priorityQueue1.insert("zudio");



        System.out.println("Priority Queue:");
        for (Node<String> node : priorityQueue1.list) {
            System.out.println("Data: " + node.data + ", Priority: " + node.priority);
        }

        System.out.println("\nPriority Queue after Deleting min value:");
        priorityQueue1.deleteMin();

        for (Node<String> node : priorityQueue1.list) {
            System.out.println( "Data: " + node.data + ", Priority: " + node.priority);
        }

        System.out.println("\nPriority Queue after Decreasing priority of Levi's by 2:");
        priorityQueue1.decreasePriority("inorbit's", 2);
        for (Node<String> node : priorityQueue1.list) {
            System.out.println("Data: " + node.data + ", Priority: " + node.priority);
        }
        System.out.println("\nMore Test Cases:");

        PriorityQueue<String> priorityQueue2 = new PriorityQueue<String>();

        priorityQueue2.insert("Apple", 5);
        priorityQueue2.insert("iphone", 7);
        priorityQueue2.insert("sony", 3);
        priorityQueue2.insert("Apple", 2);
        //inserting with default priority 19
        priorityQueue2.insert("google");
        priorityQueue2.insert("infosys");


        System.out.println("\nPriority Queue:");
        for (Node<String> node : priorityQueue2.list) {
            System.out.println("Data: " + node.data + ", Priority: " + node.priority);
        }

        System.out.println("\nPriority Queue after Deleting min value");
        priorityQueue2.deleteMin();

        for (Node<String> node : priorityQueue2.list) {
            System.out.println( "Data: " + node.data + ", Priority: " + node.priority);
        }

        System.out.println("\nPriority Queue after Decreasing priority of sony by 2...");
        priorityQueue2.decreasePriority("sony", 2);
        for (Node<String> node : priorityQueue2.list) {
            System.out.println("Data: " + node.data + ", Priority: " + node.priority);
        }


    }
}