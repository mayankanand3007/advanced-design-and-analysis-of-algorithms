import java.util.LinkedList;

public class PriorityQueue<T> {
    private class Node {
        T data;
        int priority;

        public Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private LinkedList<Node> queue;

    public PriorityQueue() {
        queue = new LinkedList<>();
    }

    public void insert(T data, int priority) {
        Node newNode = new Node(data, priority);
        int index = 0;
        while (index < queue.size() && queue.get(index).priority <= priority) {
            index++;
        }
        queue.add(index, newNode);
    }

    public void insert(T data) {
        insert(data, 19);
    }

    public T deleteMin() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst().data;
    }

    public void decreasePriority(T data, int k) {
        for (int i = 0; i < queue.size(); i++) {
            Node currentNode = queue.get(i);
            if (currentNode.data.equals(data)) {
                currentNode.priority -= k;
                Node temp = queue.remove(i);
                insert(temp.data, temp.priority);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : queue) {
            sb.append(node.data.toString()).append(" - ").append(node.priority).append("\n");
        }
        return sb.toString();
    }
}
