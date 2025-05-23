/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 10
 * Ivana Figueroa - 24785
 * 
 * Clase FWA
 * Implementacion del algoritmo Floyd-Warshall
 * para encontrar los caminos más cortos y calcular el centro de un grafo dirigido 
 */

import java.util.Arrays;


    /**
     * calcula las distancias mas cortas entre todos los pares de nodos en el grafo.
     * @param graph grafo dirigido de entrada
     * @return matriz con las distancias mas cortas entre todos los nodos
     */
public class FWA {
    public static int[][] calcShortestPaths(DirectionGraph graph) {
        int[][] distances = graph.getAdjacencyMatrix();
        int n = distances.length;
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && 
                        distances[k][j] != Integer.MAX_VALUE) {
                        if (distances[i][j] > distances[i][k] + distances[k][j]) {
                            distances[i][j] = distances[i][k] + distances[k][j];
                        }
                    }
                }
            }
        }
        return distances;
    }


    /**
     * Encuentra el centro del grafo (nodo con minima excentricidad).
     * @param graph Grafo dirigido de entrada
     * @return Nombre de la ciudad que representa el centro del grafo
     */
    public static String findGraphCenter(DirectionGraph graph) {
        int[][] distances = calcShortestPaths(graph);
        int[] eccentricities = new int[graph.getCities().length];
        Arrays.fill(eccentricities, Integer.MIN_VALUE);

       
        for (int j = 0; j < distances.length; j++) {
            for (int i = 0; i < distances.length; i++) {
                if (distances[i][j] != Integer.MAX_VALUE) {
                    eccentricities[j] = Math.max(eccentricities[j], distances[i][j]);
                }
            }
        }

        
        int centerIndex = 0;
        for (int i = 1; i < eccentricities.length; i++) {
            if (eccentricities[i] < eccentricities[centerIndex]) {
                centerIndex = i;
            }
        }
        return graph.getCities()[centerIndex];
    }
}