package Homework_7;

public class Main {
    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(10);

        graph.addVertex("Moscow");
        graph.addVertex("Tula");
        graph.addVertex("Lipeck");
        graph.addVertex("Voronezh");
        graph.addVertex("Ryazan'");
        graph.addVertex("Tambov");
        graph.addVertex("Saratov");
        graph.addVertex("Kaluga");
        graph.addVertex("Orel");
        graph.addVertex("Kursk");

        graph.addEdge(3, "Moscow", "Tula");
        graph.addEdge(3, "Moscow", "Ryazan'");
        graph.addEdge(3, "Moscow", "Kaluga");
        graph.addEdge(4, "Tula", "Lipeck");
        graph.addEdge(7, "Lipeck", "Voronezh");
        graph.addEdge(2, "Ryazan'", "Tambov");
        graph.addEdge(2, "Tambov", "Saratov");
        graph.addEdge(3, "Saratov", "Voronezh");
//        graph.addEdge(1, "Saratov", "Orel");
        graph.addEdge(2, "Kaluga", "Orel");
        graph.addEdge(1, "Orel", "Kursk");
        graph.addEdge(5, "Kursk", "Voronezh");

        graph.optimalWay("Moscow", "Voronezh");
        System.out.println(graph.getListOfPaths());

    }
}
