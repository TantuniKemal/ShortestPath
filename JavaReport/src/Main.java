import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // upload CSV file
       String fileCSV = "C:\\Java Projelerim IDE\\JavaReport\\src\\TurkishCities.csv";
       CSVto2DArray csvConverter = new CSVto2DArray(fileCSV);
       // take input start and target point
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter start and end point to find shortest path");
       String start = scanner.nextLine();
       String target = scanner.next();
       scanner.close();

        Graph graph = new Graph(csvConverter.csvCities(fileCSV), csvConverter.csvMatrix(fileCSV));
        graph.setupGraph();
        // Measure whole DFS action in nanoseconds
        long starTime= System.nanoTime();
        graph.preDFS(start, target);
        long endTime= System.nanoTime();
        long dfsTime= endTime - starTime;
        System.out.println("DFS Time: "+ dfsTime+" nanoseconds.");
    }
}