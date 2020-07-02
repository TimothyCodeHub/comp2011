package comp2011.lecB;

import java.util.Arrays;
import comp2011.lec4.Queue;
import comp2011.lec4.Stack;

public class GraphInMatrix extends Graph{
    private int order;  // the number of vertices
    private boolean[][] aMatrix;
    
    public GraphInMatrix(String inputFile) { }
    
    public GraphInMatrix(int order) {
        this.order = order;
        aMatrix = new boolean[order][order];
        // the following is not really necessary in Java.
        for (int i = 0; i < order; i++)
            for (int j = 0; j < order; j++)
                aMatrix[i][j] = false;
    }

    public GraphInMatrix(boolean[][] aMatrix) {
        order = aMatrix.length;
        // check the matrix is a square and symmetric
        this.aMatrix = aMatrix;
    }
    
    public void addEdge(int a, int b) {
        // usually we don't allow self-loop 
        // i.e., an edge with both ends on the same vertex
        if (a == b) return;
        aMatrix[a][b] = aMatrix[b][a] = true;
    }
    
    public boolean isAdjacent(int a, int b) {
        return aMatrix[a][b];
    }

    // return the degree of vertex a.
    public int degree(int a) {
        int d = 0;
        for(int i = 0; i < order; i++)
        	d += aMatrix[a][i]?1:0;
    	return d;
    }

    // return the total number of edges in the graph.
    public int size() {
//    	int s = 0;
//        for(int i = 0; i < order; i++)
//        	s += degree(i);
//        return s / 2;
    	int s = 0;
        for(int i = 0; i < order; i++)
        	for(int j = 0; j < i; j++)
        		s += aMatrix[i][j]?1:0;
        return s;
    }

    // check whether the graph contains a triangle
    // i.e., three vertices pairwise adjacent
    public boolean triangle() {
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++)
                    if (aMatrix[i][j] && aMatrix[i][k] && aMatrix[j][k])
                        return true;
            }
        }
        return false;
    }
    
    // breadth-first search
    public void bfs(int a) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(a);
        // boolean[] visited = new boolean[order];// in Java, false by default.
        // visited[a] = true;
        int[] visited = new int[order];
        for (int i = 0; i < order; i++) visited[i]=-1;
        visited[a] = 0;
        int count = 1;
        int[] parent = new int[order];
        parent[a] = -1;
        int[] distance = new int[order];
        distance[a] = 0;
        //int countDepth = 1;
        while( !queue.isEmpty() ) {
            int v = (int) queue.dequeue();
            for (int i = 0; i < order; i++) {
                if (aMatrix[v][i] && visited[i] < 0) {
                    System.out.println(v + " discovers " + i);
                    visited[i] = count++;
                    parent[i] = v;
                    queue.enqueue(i);
                    distance[i] = distance[v] + 1;
                }
            }
        }
        System.out.println("order of visiting: " + Arrays.toString(visited));
        System.out.println("depth:"+Arrays.toString(distance));
        System.out.println("discovered by " + Arrays.toString(parent));
    }
    
	// depth-first search (iterative)
    public void dfs(int a) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(a);
        int[] checked = new int[order];
        for (int i=0; i<order;i++) checked[i] = 0;

        int[] parent = new int[order];
        parent[a] = -1;
        boolean[] visited = new boolean[order];
        while(!stack.isEmpty()) {
            int u = stack.pop();
            visited[u] = true;
            for (int i = checked[u]; i < order; i++) {
                if (!aMatrix[u][i]) continue;
                if (visited[i]) continue;
                parent[i] = u;
                System.out.println(u + " discovers " + i);
                // i has not been visited
                checked[u] = i;
                stack.push(u);
                stack.push(i);
                break; // break the for loop
            }
        }
        System.out.println("parents: " + Arrays.toString(parent));
    }

    //depth-first search (recursive)
    public void dfs() {
        boolean[] visited = new boolean[order];
        visit(0, visited);
    }
    public void visit(int a, boolean[] visited) {
        visited[a] = true;
        for (int i = 0; i < order; i++) {
            if (!aMatrix[a][i]) continue;
            if (visited[i]) continue;
            System.out.println(a + "␣discovers␣" + i);
            visit(i, visited);
        }
    }
    
    public static void main(String[] args) {
        boolean[][] m1 = {
                {false, false, false, true, false, false, false, false},
                {false, false, false, true, true, false, false, false}, 
                {false, false, false, false, true, false, false, false}, 
                {true, true, false, false, false, true, false, false}, 
                {false, true, true, false, false, false, true, false}, 
                {false, false, false, true, false, false, true, true}, 
                {false, false, false, false, true, true, false, true}, 
                {false, false, false, false, false, true, true, false}};
        GraphInMatrix graph1 = new GraphInMatrix(m1);
        System.out.println("Breadth-first search: ");  
        graph1.bfs();
        System.out.println("Depth-first search: ");   
        graph1.dfs(0);
        
        boolean[][] m2 = new boolean[8][8];
        m2[0][3] = m2[3][0] = true;
        m2[1][3] = m2[3][1] = true;
        m2[1][4] = m2[4][1] = true;
        m2[2][4] = m2[4][2] = true;
        m2[3][5] = m2[5][3] = true;
        m2[4][6] = m2[6][4] = true;
        m2[5][6] = m2[6][5] = true;
        m2[5][7] = m2[7][5] = true;
        m2[6][7] = m2[7][6] = true;
        GraphInMatrix graph2 = new GraphInMatrix(m2);
        System.out.println("Breadth-first search: ");  
        graph2.bfs();
        System.out.println("Depth-first search: ");  
        graph2.dfs();

        GraphInMatrix graph = new GraphInMatrix(8);
        System.out.println("The degree of vertex " + 2 + " is "  
        		+ graph.degree(2) + ".");
        System.out.println("Vertices " + 2 + " and " + 4 + " are" 
        		+ (graph.isAdjacent(2,4)?"":" not") + " adjacent.");
        graph.addEdge(0, 3); graph.addEdge(1, 3); graph.addEdge(1, 4); 
        graph.addEdge(2, 4); graph.addEdge(3, 5); graph.addEdge(4, 6);
        graph.addEdge(5, 6); graph.addEdge(5, 7); graph.addEdge(6, 7);
        System.out.println("Vertices " + 2 + " and " + 4 + " are" 
        		+ (graph.isAdjacent(2,4)?"":" not") + " adjacent.");
        System.out.println("The degree of vertex " + 2 + " is "  
        		+ graph.degree(2) + ".");
        System.out.println("The graph has " + graph.size() + " edges.");
        //System.out.println(graph.draw());
    }
}
