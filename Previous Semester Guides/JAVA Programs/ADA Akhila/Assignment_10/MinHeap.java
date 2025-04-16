import java.util.ArrayList;
import java.util.List;

public class MinHeap<K extends Comparable<K>, V> {
    private List<Data<K, V>> elements;

    public MinHeap() {
        elements = new ArrayList<>();
    }

    public static class Data<K extends Comparable<K>, V> {
        K key;
        V value;

        public Data(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void insert(K key, V value) {
        Data<K, V> newData = new Data<>(key, value);
        elements.add(newData);
        int currentIndex = elements.size() - 1;
        int parentIndex = (currentIndex - 1) / 2;

        while (currentIndex > 0 && elements.get(currentIndex).key.compareTo(elements.get(parentIndex).key) < 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    private void swap(int index1, int index2) {
        Data<K, V> temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    private Data<K, V> removeMin() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        Data<K, V> min = elements.get(0);
        int lastIndex = elements.size() - 1;
        elements.set(0, elements.get(lastIndex));
        elements.remove(lastIndex);

        int currentIndex = 0;
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        while (leftChildIndex < elements.size()) {
            int minChildIndex = leftChildIndex;

            if (rightChildIndex < elements.size() && elements.get(rightChildIndex).key.compareTo(elements.get(leftChildIndex).key) < 0) {
                minChildIndex = rightChildIndex;
            }

            if (elements.get(currentIndex).key.compareTo(elements.get(minChildIndex).key) <= 0) {
                break;
            }

            swap(currentIndex, minChildIndex);
            currentIndex = minChildIndex;
            leftChildIndex = 2 * currentIndex + 1;
            rightChildIndex = 2 * currentIndex + 2;
        }

        return min;
    }

    public List<Data<K, V>> sort() {
        List<Data<K, V>> sortedList = new ArrayList<>(elements.size());

        while (!elements.isEmpty()) {
            Data<K, V> min = removeMin();
            sortedList.add(min);
        }

        return sortedList;
    }
}
