package comp2011.lecB;

public class GraphInLists extends Graph {
	private int order; // the number of vertices
	private List[] aLists;

    public GraphInLists(String inputFile) { }
    public GraphInLists(int order) {}

	public GraphInLists(boolean[][] aMatrix) { }

	// You need to check whether the edge is arealdy there.
	// It's not a problem for matrix version. Why?
	public void addEdge(int a, int b) { }

	public boolean isAdjacent(int a, int b) {return false;}

	// return the degree of vertex a.
	public int degree(int a) { return -1; }

	// return the total number of edges in the graph.
	public int size() { return -1; }

	// check whether the graph contains a triangle
	// i.e., three vertices pairwise adjacent
	public boolean triangle() { return false; }

	// breadth-first search
	public void bfs(int a) { }

	// depth-first search
    public void dfs() {
        boolean[] visited = new boolean[order];
        dfs(0, visited);
    }
    public void dfs(int a, boolean[] visited) {
        visited[a] = true;
        int[] neighbors = aLists[a].toArray();
        for (int i:neighbors) {
            if (visited[i]) continue;
            System.out.println(a + " discovers " + i);
            dfs(i, visited);
        }
    }
    // iterative version of dfs.
    public void dfs(int a) {
        
    }

	// print out the adjacency list
	public void display() {
		for (int i = 0; i < order; i++) {
			System.out.println(aLists[i]);
		}
	}

	public static void main(String[] args) {
		boolean[][] m1 = { { false, false, false, true, false, false, false, false },
				{ false, false, false, true, true, false, false, false },
				{ false, false, false, false, true, false, false, false },
				{ true, true, false, false, false, true, false, false },
				{ false, true, true, false, false, false, true, false },
				{ false, false, false, true, false, false, true, true },
				{ false, false, false, false, true, true, false, true },
				{ false, false, false, false, false, true, true, false } };
		GraphInLists graph1 = new GraphInLists(m1);
		System.out.println("Breadth-first search: ");
		graph1.bfs();
		System.out.println("Depth-first search: ");
		graph1.dfs();

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
		GraphInLists graph2 = new GraphInLists(m2);
		System.out.println("Breadth-first search: ");
		graph2.bfs();
		System.out.println("Depth-first search: ");
		graph2.dfs();

		GraphInLists graph = new GraphInLists(8);
		System.out.println("The degree of vertex " + 2 + " is " + graph.degree(2) + ".");
		System.out.println(
				"Vertices " + 2 + " and " + 4 + " are" + (graph.isAdjacent(2, 4) ? "" : " not") + " adjacent.");
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.display();
		graph.bfs();
		graph.dfs();
		System.out.println(
				"Vertices " + 2 + " and " + 4 + " are" + (graph.isAdjacent(2, 4) ? "" : " not") + " adjacent.");
		System.out.println("The degree of vertex " + 2 + " is " + graph.degree(2) + ".");
		System.out.println("The graph has " + graph.size() + " edges.");
		// System.out.println(graph.draw());
	}
}
