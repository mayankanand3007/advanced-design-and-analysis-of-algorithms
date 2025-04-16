import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       
   Graph G = new Graph(6);
   G.addEdge(0,2);
   G.addEdge(0,3);
   G.addEdge(2,1);
   G.addEdge(4,5);
   System.out.println(G.connected_Components());

   }
}


class GraphEdge {
    public final Integer j;
    public final Integer k;

    public GraphEdge(Integer i, Integer j) {
        this.j = i;
        this.k = j;
    }

    public Integer getVertex_i() {
        return j;
    }

    public Integer getVertex_j() {
        return k;
    }
    
}


class Graph {
    
    ArrayList<GraphEdge> Edges;
    ArrayList<Integer> vertices;
    ArrayList<Set<Integer>> las; 
    
    public Set<Set<Integer>> connected_Components(){
        Set<Set<Integer>> Label = new HashSet<Set<Integer>>(); 
        for (int i = 0; i < vertices.size(); i++)
        {
            Set<Integer> sl = new HashSet<Integer>();
            
            for(int j = 0; j < Edges.size(); j++){
                int u = Edges.get(j).getVertex_i();
                int v = Edges.get(j).getVertex_j();
                if(vertices.get(i) == u )
                {
                   sl.add(u);
                   sl.add(v);
               
                   if(las.size()==0){
                        las.add(sl);
                   }
                   else{
                       int k = make_set(u);
                           if(k!=-1)
                              las.get(k).addAll(sl);
                           else
                              las.add(sl);
                        }
                       
                  }
              }
             }
           
            
        Label.addAll(las);
        return(Label);
    }
    
    public int make_set( int v) {
        for(int i = 0; i < las.size(); i++){
                 if(las.get(i).contains(v) ){
                     return(i); 
                 } 
        }
        return(-1);
    }
        
    public Graph(int Vertices) {
        vertices = new ArrayList<Integer>(Vertices);
        for (int s=0; s<Vertices; s++)
            vertices.add(s);
        Edges = new ArrayList<GraphEdge>();
        las = new ArrayList<Set<Integer>>();
    }


    public void addEdge(int h, int m) {
        if(0<=h && h<this.vertices.size() && 0<=m && m<this.vertices.size()) {
            Edges.add(new GraphEdge(h,m));
        }
    }


    

}
