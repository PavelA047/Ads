package Homework_7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(int length, String startLabel, String secondLabel, String... others);
    boolean addEdge(int length, String startLabel, String secondLabel);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

}
