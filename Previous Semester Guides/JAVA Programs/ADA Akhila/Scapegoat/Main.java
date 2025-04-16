import java.io.*;
import java.util.*;
import com.company.ScapegoatTree;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class Main {

    public static void main(String[] args) throws IOException {
        // Load data from JSON file
        File file = new File("src/WildKrattsDB.json");
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Episode>>() {}.getType();
        Map<String, Episode> episodes = gson.fromJson(new java.io.FileReader(file), type);

        // Create a new ScapegoatTree
        ScapegoatTree<String, Episode> tree = new ScapegoatTree<>();

        // Insert data into the tree
        for (Map.Entry<String, Episode> entry : episodes.entrySet()) {
            tree.insert(entry.getKey(), entry.getValue());
        }

        // Test toString method
        System.out.println("\nString representation of tree:");
        System.out.println(tree);
        System.out.println("\n\n");

        //  Pre-order and post-order are private methods

        // Test successor method
        System.out.println("Successor of S02E06: " + tree.successor("S02E06"));
        System.out.println("Successor of S01E20: " + tree.successor("S01E20"));
        System.out.println("Successor of S01E14: " + tree.successor("S01E14"));
        System.out.println("\n\n");
//
        // Test predecessor method
        System.out.println("Predecessor of S02E06: " + tree.predecessor("S02E06"));
        System.out.println("Predecessor of S01E32: " + tree.predecessor("S01E32"));
        System.out.println("Predecessor of S01E19: " + tree.predecessor("S01E19"));
    }

    public class Episode {
        private int season;
        private int episode;
        private String title;
        private String format;

        public Episode(int season, int episode, String title, String format) {
            this.season = season;
            this.episode = episode;
            this.title = title;
            this.format = format;
        }

        @Override
        public String toString() {
            return "Episode {" +
                    "season = " + season +
                    ", episode = " + episode +
                    ", title = '" + title + '\'' +
                    ", format = '" + format + '\'' +
                    '}';
        }
    }
}
