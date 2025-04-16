import java.util.LinkedList;

public class PriorityQueue<T> {
    private class Node {
        T data;
        int priority;

        Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private LinkedList<Node> list = new LinkedList<>();

    public void insert(T data, int priority) {
        Node newNode = new Node(data, priority);
        int index = 0;

        while (index < list.size() && list.get(index).priority <= priority) {
            index++;
        }

        list.add(index, newNode);
    }

    public void insert(T data) {
        insert(data, 19);
    }

    public T deleteMin() {
        if (list.isEmpty()) {
            return null;
        }
        T data = list.getFirst().data;
        list.removeFirst();
        return data;
    }

    public void decreasePriority(T data, int k) {
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.data.equals(data)) {
                node.priority -= k;
                list.remove(i);
                insert(node.data, node.priority);
                break;
            }
        }
    }
}
