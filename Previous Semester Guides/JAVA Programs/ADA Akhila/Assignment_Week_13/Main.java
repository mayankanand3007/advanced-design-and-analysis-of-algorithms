import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Graph {
    ArrayList<Integer> V;
    ArrayList<GraphEdge> E;

    public Graph(int numVertices) {
        V = new ArrayList<>();
        E = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            V.add(i);
        }
    }

    public void addEdge(int i, int j) {
        E.add(new GraphEdge(i, j));
    }

    public ArrayList<ArrayList<Integer>> connected_components() {
        ArrayList<Integer> labels = new ArrayList<>();
        for (int v : V) {
            labels.add(v); // Equivalent to MAKE-SET
        }

        for (GraphEdge edge : E) {
            int label_i = labels.get(edge.i); // Equivalent to FIND-SET(edge.i)
            int label_j = labels.get(edge.j); // Equivalent to FIND-SET(edge.j)

            if (label_i != label_j) {
                int minLabel = Math.min(label_i, label_j);
                // Updating labels to use the smaller label (UNION operation)
                for (int k = 0; k < labels.size(); k++) {
                    if (labels.get(k) == label_i || labels.get(k) == label_j) {
                        labels.set(k, minLabel);
                    }
                }
            }
        }

        // Creating a list of components
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        Set<Integer> uniqueLabels = new HashSet<>(labels);

        for (int label : uniqueLabels) {
            ArrayList<Integer> component = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                if (labels.get(i) == label) {
                    component.add(i);
                }
            }
            components.add(component);
        }

        return components;
    }
}

class GraphEdge {
    int i;
    int j;

    public GraphEdge(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);
        graph.addEdge(4, 5);

        System.out.println("Connected components: " + graph.connected_components().toString());
    }
}
