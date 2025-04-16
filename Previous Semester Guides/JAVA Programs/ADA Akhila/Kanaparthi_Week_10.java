import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MinHeapMain {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };
        Comparator<String> comparator1= new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        };
        MinHeap<Integer, String> heap1 = new MinHeap<>(10, comparator);
        heap1.insert(9, "A");
        heap1.insert(1, "A");
        heap1.insert(6, "B");
        heap1.insert(4, "B");
        heap1.insert(2, "C");
        heap1.insert(3, "C");
        heap1.insert(5, "D");
        heap1.insert(9, "D");
        heap1.insert(5, "E");
        System.out.println("Using Banner Id as keys:");
        heap1.sort();
        MinHeap<String, Integer> heap2 = new MinHeap<String, Integer>(10,comparator1);
        heap2.insert("A", 9);
        heap2.insert("A" ,1);
        heap2.insert("B", 6);
        heap2.insert("B", 4);
        heap2.insert("C", 2);
        heap2.insert("C", 3);
        heap2.insert("D", 5);
        heap2.insert("D", 9);
        heap2.insert("E", 5);
        System.out.println("Using Alphabets as keys:");
        heap2.sort();
    }

    static class Data<Key, Value> {
        Key key;
        Value value;

        Data(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    static class MinHeap<Key, Value> {
        Data<Key, Value>[] a;
        int size;
        Comparator<Key> comparator;

        MinHeap(int maxN, Comparator<Key> comparator) {
            this.a = (Data<Key, Value>[]) new Data[maxN + 1];
            this.size = 0;
            this.comparator = comparator;
        }

        int left(int i) {
            return i * 2;
        }

        int right(int i) {
            return i * 2 + 1;
        }

        int parent(int i) {
            return i / 2;
        }

        void heapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l <= size && comparator.compare(a[l].key, a[i].key) < 0) {
                smallest = l;
            }
            if (r <= size && comparator.compare(a[r].key, a[smallest].key) < 0) {
                smallest = r;
            }
            if (smallest != i) {
                Data<Key, Value> temp = a[i];
                a[i] = a[smallest];
                a[smallest] = temp;
                heapify(smallest);
            }
        }

        void insert(Key key, Value value) {
            a[++size] = new Data<>(key, value);
            int i = size;
            while (i > 1 && comparator.compare(a[i].key, a[parent(i)].key) < 0) {
                Data<Key, Value> temp = a[i];
                a[i] = a[parent(i)];
                a[parent(i)] = temp;
                i = parent(i);
            }
        }

        public void heap(){
            for(int i=1;i<=size;i++){
                System.out.println("value "+a[i].value+" With Key "+a[i].key);
            }
        }
        public List<Data<Key, Value>> sort() {
            List<Data<Key, Value>> sortedList = new ArrayList<>();
            while (size > 0) {
                Data<Key, Value> min = a[1];
                a[1] = a[size];
                a[size--] = null;
                sortedList.add(min);
                System.out.println("value "+min.value+" With Key "+min.key);
                heapify(1);
            }
            return sortedList;
        }

    }
}