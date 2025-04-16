import java.util.ArrayList;
import java.util.List;

public class MinHeap<K extends Comparable<K>, V> {
    private List<Data<K, V>> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public MinHeap(List<Data<K, V>> input) {
        heap = input;
        buildHeap();
    }

    public void insert(Data<K, V> data) {
        heap.add(data);
        int i = heap.size() - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && heap.get(parent).getKey().compareTo(data.getKey()) > 0) {
            heap.set(i, heap.get(parent));
            i = parent;
            parent = (i - 1) / 2;
        }
        heap.set(i, data);
    }

    public Data<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Data<K, V> min = heap.get(0);
        Data<K, V> last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }
        return min;
    }

    public List<Data<K, V>> sort() {
        List<Data<K, V>> sortedList = new ArrayList<>();
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            sortedList.add(removeMin());
        }
        return sortedList;
    }

    private void buildHeap() {
        int size = heap.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heap.size() && heap.get(left).getKey().compareTo(heap.get(smallest).getKey()) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).getKey().compareTo(heap.get(smallest).getKey()) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            Data<K, V> temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            heapify(smallest);
        }
    }
}
