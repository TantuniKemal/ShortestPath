public class Graph {
    private static String[] cities; // node --> vertex
    private static int[][] adjMatrix; // edge
    private boolean[] visited;
    private static int currentDistance;
    private static int shortesDistance = Integer.MAX_VALUE;
    private static String shortestPath;

    // call constructor
    public Graph(String[] cities, int[][] adjMatrix) {
        this.cities = cities;
        this.adjMatrix = adjMatrix;
        this.visited = new boolean[cities.length];
    }
    // setUp graph with cities and adjMatrix
    public void setupGraph() {
        int n = cities.length;  //number of cities
        System.out.println("Cities and Connnections");
        // print for each cities node
        for (int i = 0; i < n; i++) {
            System.out.print(cities[i] + ":");
            for (int j = 0; j < n; j++) {
                // 0 itself and 99999 not neighboor
                if (adjMatrix[i][j] !=99999 && adjMatrix[i][j] != 0) {
                    System.out.print(cities[j] + " " +"("+adjMatrix[i][j]+" km) ");
                }
            }
            System.out.println();
        }
    }
    //pre DFS
    public  void preDFS(String startVertex, String targetVertex) {
        // PREPARING DFS
        int startIndex = -1;
        int targetIndex = -1;
        // find start and target cities index
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equals(startVertex)) {
                startIndex = i;
            } else if (cities[i].equals(targetVertex)) {
                targetIndex = i;
            }
        }
        if (startIndex == -1 || targetIndex == -1) {
            System.out.println("Start or end point are not in cities matrix!");
        }
        dfs(startIndex, targetIndex);
    }
    //DFS Algorithm
    private void dfs(int start, int target) {
        CustomStack<Integer> stack = new CustomStack<>();
        visited = new boolean[cities.length];
        currentDistance=0;
        // stack initialize with start
        stack.add(start);
        System.out.println("DFS ALGORITHM\nStarting at city: " + cities[start]+ " to target city: "+cities[target] );
        //call recursive
        dfsRecursive(start, target, stack);
        // shortest path String need to convert and print in cities array
        convertPath(shortestPath);
        System.out.println("Shortest Distance : "+ shortesDistance+" km.");
    }
    private void dfsRecursive(int current, int target, CustomStack<Integer> stack) {        visited[current] = true;
        // for optimize and early exit
        if (currentDistance >= shortesDistance) {
            visited[current] = false;
            return;
        }
        // current equals to target
        if (current == target) {
            // find shortest distance and path
            if(shortesDistance > currentDistance){
                shortesDistance = currentDistance;
                shortestPath = stack.toString();
            }
            visited[current] = false; // target must not be mark to find again
            return;
        }
        // visit whole neighbors
        for (int neighbor = 0; neighbor < adjMatrix[current].length; neighbor++) {
            if (adjMatrix[current][neighbor] != 99999 && adjMatrix[current][neighbor] != 0 && !visited[neighbor]) {
                stack.add(neighbor); // add stack neighbor
                currentDistance+=adjMatrix[current][neighbor]; // update distance to go forward
                dfsRecursive(neighbor, target, stack);
                stack.remove(); // remove stack to return
                currentDistance-=adjMatrix[current][neighbor]; // update distance tp come back
            }
        }
        visited[current] = false; // findin another way
    }
    private void convertPath(String path){
        // split and add array
        String[] pathArr = path.split(",");
        System.out.print("Shortest Path ");
        for(String part: pathArr){
            // convert string to integer
            int index = Integer.parseInt(part);
            System.out.print("--> "+cities[index]);
        }
        System.out.println();
    }
}