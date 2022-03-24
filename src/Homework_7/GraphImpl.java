package Homework_7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final List<PathOfWay> listOfPaths;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.listOfPaths = new ArrayList<>();
    }

    public List<PathOfWay> getListOfPaths() {
        return listOfPaths;
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(int length, String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = length;
        adjMatrix[endIndex][startIndex] = length;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(int length, String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(length, startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(length, startLabel, other);
        }

        return result;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " " + vertex.getMark());
        stack.push(vertex);
        vertex.setIsVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setIsVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }

    public void optimalWay(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        Vertex vertexNext;
        ArrayList<Vertex> vertices;

        if (startIndex == -1 || endIndex == -1 || startIndex == endIndex) {
            throw new IllegalArgumentException("incorrect input data");
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertexNext = getNearUnvisitedVertex(stack.peek());
            if (vertexNext != null) {
                visitVertex(stack, vertexNext);
                vertices = new ArrayList<>();
                vertices.add(vertex);
                vertices.add(vertexNext);
                PathOfWay newPath = new PathOfWay(0);
                newPath.setPathList(vertices);
                newPath.setPathLength(newPath.getPathLength() + adjMatrix[indexOf(vertex.getLabel())][indexOf(vertexNext.getLabel())]);
                listOfPaths.add(newPath);
                if (!vertexNext.getLabel().equals(endLabel)) {
                    vertex = vertexNext;
                } else {
                    vertexNext.setIsVisited(false);
                    vertex = vertexList.get(startIndex);
                    stack.clear();
                    stack.push(vertex);
                }
            } else {
                stack.pop();
            }
        }
    }
}
