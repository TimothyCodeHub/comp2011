package comp2011.lecA;

public abstract class Graph {
	abstract public void addEdge(int a, int b);
	abstract public boolean isAdjacent(int a, int b);
	abstract public int degree(int a);
	abstract public int size();
	abstract public boolean triangle();
    abstract public void bfs(int a);
    abstract public void dfs(int a);

    public void bfs() { bfs(0); }
    public void dfs() { dfs(0); }
}
