import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainScape {

    public static void main(String[] args) {
//        ScapegoatTree<String, Object> sgt2 = new ScapegoatTree<>();
//        Gson gson = new Gson();
//        try (Reader reader = new FileReader("src/com/company/WildKrattsDB.json")) {
//            Map<?, ?> map = gson.fromJson(reader, Map.class);
//            for (Map.Entry<?, ?> entry : map.entrySet()) {
//                sgt2.insert(entry.getKey().toString(), entry.getValue());
////                System.out.println(entry.getKey() + "=" + entry.getValue());
////                System.out.println(entry.getKey() + "=" + entry.getValue());
////                System.out.println(entry.getValue().getClass().getName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(sgt2);
        ScapegoatTree<Integer, Integer> sind = new ScapegoatTree<>();
        int[] nodes = new int[]{2,1,6,5,4,3,15,12,9,7,11,10,13,14,16,17,18};
        for (int key: nodes) {
            sind.insertWithoutRebalancing(key,key);
        }
        System.out.println(sind);
        sind.deleteWithoutRebalancing(12);
        sind.delete(1);
        System.out.println(sind);
		sind.inOrder();
		sind.preOrder();
		sind.postOrder();
		sind.successor(10);
		sind.predecessor(12);
		System.out.println(sind);
    }
}
