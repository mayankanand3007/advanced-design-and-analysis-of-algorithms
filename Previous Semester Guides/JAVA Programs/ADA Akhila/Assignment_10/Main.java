import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        int[] BannerID = {9, 1, 6, 4, 2, 1, 0, 0, 9};

        MinHeap<Integer, String> minHeap = new MinHeap<>();
        for (int i = 0; i < BannerID.length; i++) {
            minHeap.insert(BannerID[i], Alphabets[i / 2]);
        }
        List<MinHeap.Data<Integer, String>> sorted = minHeap.sort();
        System.out.println("Test 1: Sorted list");
        for (MinHeap.Data<Integer, String> data : sorted) {
            System.out.println("Key: " + data.key + ", Value: " + data.value);
        }

        System.out.println();
        MinHeap<String, Integer> minHeap2 = new MinHeap<>();
        for (MinHeap.Data<Integer, String> data : sorted) {
            minHeap2.insert(data.value, data.key);
        }
        List<MinHeap.Data<String, Integer>> sorted2 = minHeap2.sort();
        System.out.println("Test 2: After swapped keys and values");
        for (MinHeap.Data<String, Integer> data : sorted2) {
            System.out.println("Key: " + data.key + ", Value: " + data.value);
        }
    }
}
