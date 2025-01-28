//package main.java;
//
//import java.util.*;
//
//public class FlightNetwork {
//
//    public static Map<String, List<String>> buildGraph(List<String> flights) {
//        Map<String, List<String>> graph = new HashMap<>();
//        for (String flight : flights) 
//        {
//            String[] cities = flight.split("-"); 
//            String from = cities[0]; 
//            String to = cities[1];
//
//            graph.putIfAbsent(from, new ArrayList<>());
//            graph.get(from).add(to);
//        }
//        return graph;
//    }
//
//    public static List<String> findShortestPath(Map<String, List<String>> graph, String source, String destination) {
//        Queue<List<String>> queue = new LinkedList<>(); 
//        Set<String> visited = new HashSet<>(); 
//
//        queue.add(Arrays.asList(source));
//        visited.add(source);
//
//        while (!queue.isEmpty()) {
//            List<String> path = queue.poll(); 
//            String lastCity = path.get(path.size() - 1); 
//
//            if (lastCity.equals(destination)) {
//            	Collections.reverse(path);
//                return path;
//            }
//
//            for (String neighbor : graph.getOrDefault(lastCity, new ArrayList<>())) { 
//                if (!visited.contains(neighbor)) {
//                    visited.add(neighbor); 
//                    List<String> newPath = new ArrayList<>(path); 
//                    newPath.add(neighbor); 
//                    queue.add(newPath); 
//                }
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    public static void main(String[] args) {
//        List<String> flights = Arrays.asList("A-B", "B-C", "A-D", "D-C", "C-E");
//        String source = "A"; 
//        String destination = "E"; 
//
//        Map<String, List<String>> graph = buildGraph(flights);
//        System.out.println("Graph: " + graph);
//
//        List<String> shortestPath = findShortestPath(graph, source, destination);
//        System.out.print("Shortest Path: ");
//        System.out.println(shortestPath);
//
//      
//    }
//}



















package main.java;

import java.util.*;

public class FlightNetwork {

    public static Map<String, List<String>> buildGraph(List<String> flights) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < flights.size(); i++) {
            String flight = flights.get(i);
            String[] cities = flight.split("-"); 
            String from = cities[0]; 
            String to = cities[1];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        return graph;
    }

    public static List<String> findShortestPath(Map<String, List<String>> graph, String source, String destination) {
        Queue<List<String>> queue = new LinkedList<>(); 
        Set<String> visited = new HashSet<>(); 

        queue.add(Arrays.asList(source));
        visited.add(source);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll(); 
            String lastCity = path.get(path.size() - 1); 

            if (lastCity.equals(destination)) {
//                Collections.reverse(path);
                return path;
            }

            for (int i = 0; i < graph.getOrDefault(lastCity, new ArrayList<>()).size(); i++) {
                String neighbor = graph.get(lastCity).get(i);
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor); 
                    List<String> newPath = new ArrayList<>(path); 
                    newPath.add(neighbor); 
                    queue.add(newPath); 
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<String> flights = Arrays.asList("A-B", "B-C", "A-D", "D-C", "C-E");
        String source = "A"; 
        String destination = "E"; 

        Map<String, List<String>> graph = buildGraph(flights);
        System.out.println("Graph: " + graph);

        List<String> shortestPath = findShortestPath(graph, source, destination);
        System.out.print("Shortest Path: ");
        System.out.println(shortestPath);
    }
}