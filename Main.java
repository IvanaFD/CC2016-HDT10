/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 10
 * Ivana Figueroa - 24785
 * 
 * Clase Main
 * demuestra el uso del grafo dirigido y el algoritmo de floy
 * encuentra las rutas mas cortas entre las ciudades y el centro del grafo
 *
 */

public class Main {
    public static void main(String[] args) {
        String[] cities = {
            "A: Ciudad de Gautemala", 
            "B: Zacapa", 
            "C: Chiquimula", 
            "D: Quetzaltenango", 
            "E: Coban"
        };
        
        int[][] initialMatrix = {
            {0, 3, Integer.MAX_VALUE, 7, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 8},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 3},
            {4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };


        //crea el grafo con los datos iniciales
        DirectionGraph graph = new DirectionGraph(cities, initialMatrix);
        
        // calcula las rotas mas cortas
        int[][] shortestPaths = FWA.calcShortestPaths(graph);
        
        // muestra la matriz de las rutas
        System.out.println("Las rutas mas cortas son:");
        printMatrix(shortestPaths);
        
        // encuentra el centro del grafo
        String center = FWA.findGraphCenter(graph);
        System.out.println("\nEl centro del grafo es: " + center);
    }


    /**
     * Imprime la matriz de distancias formateada.
     * @param matrix Matriz a imprimir (∞ representa infinito)
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print((value == Integer.MAX_VALUE ? "∞" : value) + "\t");
            }
            System.out.println();
        }
    }
}