/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 10
 * Ivana Figueroa - 24785
 * 
 * Clase DirectionGraph
 * Implementación de grafo dirigido usando matriz de adyacencia
 *
 */
import java.util.*;

public class DirectionGraph{

private int[][] adjacencyMatrix; //matiz para almacenar las distancias estre los nodos
private String[] cities; // nombre de los nodos que son las ciudades
private static final int INF = Integer.MAX_VALUE; // valor para conexiones que no existen



  /**
   * Contructor para inicializar el grafo
   * @param cities , nombres de los nodos
   * @param initialMatrix , mariz inicial de adyacencia 
     */
public DirectionGraph(String[] cities, int[][] initialMatrix) {
        this.cities = cities;
        this.adjacencyMatrix = new int[cities.length][cities.length];
        
       
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                this.adjacencyMatrix[i][j] = initialMatrix[i][j];
            }
        }
    }


     /**
     * agrega una conexion dirigida entre dos nodos.
     * @param source , indice del nodo origen
     * @param destination , indice del nodo destino
     * @param weight , Distancia o peso de la conexion
     */
    public void addEdge(int source, int destination, int weight) {
        if (isValidIndex(source) && isValidIndex(destination)) {
            adjacencyMatrix[source][destination] = weight;
        }
    }

      /**
     * elimina una conexion entre dos nodo.
     * @param source , indice del nodo origen
     * @param destination , indice del nodo destino
     */
    public void removeEdge(int source, int destination) {
        if (isValidIndex(source) && isValidIndex(destination)) {
            adjacencyMatrix[source][destination] = INF;
        }
    }

     /**
     * obtiene la distancia entre dos nodos.
     * @param source , indice del nodo origen
     * @param destination , indice del nodo destino
     * @return Distancia entre bodos o INF si no hay conexion
     */
    public int getWeight(int source, int destination) {
        if (isValidIndex(source) && isValidIndex(destination)) {
            return adjacencyMatrix[source][destination];
        }
        return INF;
    }

     /**
     * obtiene una copia de la matriz de adyacencia actual.
     * @return Copia de la matriz de conexiones
     */
    public int[][] getAdjacencyMatrix() {
        int[][] copy = new int[cities.length][cities.length];
        for (int i = 0; i < cities.length; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, copy[i], 0, cities.length);
        }
        return copy;
    }


    /**
     * obtiene los nombres de los nodos.
     * @return Arreglo con nombres de nodos
     */
    public String[] getCities() {
        return cities;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < cities.length;
    }
}