package graph;
import java.util.*;

public class Graph_with_cities {
    private Map<String,ArrayList<Neighbours>> adjList;
    private ArrayList<String> cities;
    
    public Graph_with_cities(){
        adjList = new HashMap<>();
        cities = new ArrayList<>();
    }
    
    public void addEdge(Neighbours edges){
        if(checkCity(edges.cityA)==0){
            ArrayList<Neighbours> neighb = new ArrayList<>();
            adjList.put(edges.cityA, neighb);
            cities.add(edges.cityA);
        }
        if(checkCity(edges.cityB)==0){
            ArrayList<Neighbours> neighb = new ArrayList<>();
            adjList.put(edges.cityB, neighb);
            cities.add(edges.cityB);
        }
        
        (adjList.get(edges.cityA)).add(edges);        
        Neighbours edgeb = new Neighbours(edges.cityB, edges.cityA, edges.distance);
        (adjList.get(edges.cityB)).add(edgeb);
    }
    
    public int checkCity(String city){
        if (adjList.isEmpty()) return 0;
        for(Map.Entry entry : adjList.entrySet()){
            if(entry.getKey()== city) return 1;
        }
        return 0;
    }
    
    /*public ArrayList<Neighbours> getNeighb(String city){
        if (checkCity(city) == 0) return null;
        return new ArrayList<>(adjList.get(city));
    }*/
    
    public void showGraph(){
        for(Map.Entry entry : adjList.entrySet()){
            //ArrayList<Neighbours> nbs = getNeighb((String) entry.getKey());
            ArrayList<Neighbours> nbs = adjList.get(entry.getKey());
            for(Neighbours n : nbs){
                System.out.printf(entry.getKey() + " -> ");
                System.out.println(n.cityB + " | Distance: " +n.distance);
            }
        }
    }
    
    public ArrayList<Neighbours> test(String origin, String destination){
        ArrayList<Neighbours> nbList = adjList.get(origin);
        cities.remove(origin);
        for(Neighbours nb : nbList){
            if(nb.cityB == destination)return nbList;
            
        }
        return null;
    }
}
