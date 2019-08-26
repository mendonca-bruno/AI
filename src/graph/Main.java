/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author WinSeven
 */
public class Main {
    public static void main(String[] args) {
        Graph_with_cities graph = new Graph_with_cities();
        Neighbours n1 = new Neighbours("Ourinhos", "Band", 60);
        Neighbours n2 = new Neighbours("Ourinhos", "Jacarezinho", 15);
        Neighbours n3 = new Neighbours("Jacarezinho", "Cambara", 20);
        graph.addEdge(n1);
        graph.addEdge(n2);
        graph.addEdge(n3);
        graph.showGraph();
        graph.test("Cambara", "Ourinhos");
    }
}
