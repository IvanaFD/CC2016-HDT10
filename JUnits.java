/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 10
 * Ivana Figueroa - 24785
 * 
 * Clase JUnits
 * Pruebas unitarias para la implementación del grafo dirigido y el algoritmo Floyd
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class JUnits {

    // ibgresar datos de los nodos y su matiz de adyacencia inicial
    private final String[] cities = {
        "A: Ciudad de Guatemala ", 
        "B: Zacapa", 
        "C: Chiquimula", 
        "D: Quetzaltenango", 
        "E: Coban"
    };
    
    private final int[][] initialMatrix = {
        {0, 3, Integer.MAX_VALUE, 7, Integer.MAX_VALUE},
        {Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 8},
        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2, Integer.MAX_VALUE},
        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 3},
        {4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
    };


    /**
     * Prueba la funcionalidad de agregar aristas al grafo.
     */
    @Test
    public void testAddEdge() {
        DirectionGraph graph = new DirectionGraph(cities, initialMatrix);
        
    
        assertEquals(3, graph.getWeight(0, 1)); 
        

        graph.addEdge(0, 4, 5);  
        assertEquals(5, graph.getWeight(0, 4));
    }

    //Prueba la funcionalidad de eliminar aristas del grafo.
    @Test
    public void testRemoveEdge() {
        DirectionGraph graph = new DirectionGraph(cities, initialMatrix);
        

        graph.removeEdge(0, 1); 
        assertEquals(Integer.MAX_VALUE, graph.getWeight(0, 1));
    }
    

    //Prueba el algoritmo Floyd
    @Test
    public void testFloydWarshallAlgorithm() {
        DirectionGraph graph = new DirectionGraph(cities, initialMatrix);
        int[][] shortestPaths = FWA.calcShortestPaths(graph);
        
      
        assertEquals(9, shortestPaths[0][4]);
        assertEquals(3, shortestPaths[3][4]); 
        assertEquals(12, shortestPaths[2][1]);
    }


    // Prueba el calculo del centro del grafo.
    @Test
    public void testFindGraphCenter() {
        DirectionGraph graph = new DirectionGraph(cities, initialMatrix);
        String center = FWA.findGraphCenter(graph);
        
       
        assertEquals("E: Coban", center);
    }
}