import java.util.Iterator;
import java.util.LinkedList;
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        int inicial = 0;
        System.out.println("DFS desde: "+inicial);
        g.DFS(inicial);
    }
    static class Graph{
        int V;
        LinkedList<Integer> adj[];

        public Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        void addEdge(int v,int w){
            adj[v].add(w);
        }
        void DFSUtil(int v, boolean visited[]){
            visited[v]=true;
            System.out.print(v+" ");
            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if (!visited[n]) {
                    DFSUtil(n, visited);
                }
            }  
        }
        void DFS(int v){
            boolean visited[] = new boolean[V];
            DFSUtil(v, visited);
        }
        
    }

}
